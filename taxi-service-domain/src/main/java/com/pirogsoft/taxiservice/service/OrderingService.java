package com.pirogsoft.taxiservice.service;

import com.pirogsoft.taxiservice.model.NewTripInfo;
import com.pirogsoft.taxiservice.model.car.Car;
import com.pirogsoft.taxiservice.model.car.Status;
import com.pirogsoft.taxiservice.model.trip.TripOrder;
import com.pirogsoft.taxiservice.repository.car.CarRepository;
import com.pirogsoft.taxiservice.repository.trip.TripOrderRepository;
import com.pirogsoft.taxiservice.service.price.PriceStrategy;
import com.pirogsoft.taxiservice.transaction.TransactionManager;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class OrderingService {

    private final CarRepository carRepository;

    private final PriceStrategy priceStrategy;

    private final TransactionManager transactionManager;

    private final TripOrderRepository tripOrderRepository;

    public OrderingService(
            CarRepository carRepository,
            PriceStrategy priceStrategy,
            TransactionManager transactionManager,
            TripOrderRepository tripOrderRepository
    ) {
        this.carRepository = carRepository;
        this.priceStrategy = priceStrategy;
        this.transactionManager = transactionManager;
        this.tripOrderRepository = tripOrderRepository;
    }

    public Optional<NewTripInfo> findAndOrder(TripOrder tripOrder) {
        return transactionManager.doInTransaction(() -> {
            List<Car> cars = carRepository.findAvailableCars(tripOrder.getCapacity(), tripOrder.getCategory());
            Optional<NewTripInfo> newTripInfoOptional = cars
                    .stream()
                    .map(car -> new NewTripInfo(car, priceStrategy.calculatePrice(
                            tripOrder.getDeparture(),
                            tripOrder.getDestination(),
                            car
                    )))
                    .min(Comparator.comparing(NewTripInfo::getPrice));
            newTripInfoOptional.ifPresent(newTripInfo -> {
                        Car car = newTripInfo.getCar();
                        car.setStatus(Status.ON_ROUTE);
                        carRepository.update(car);
                        tripOrder.setCar(car);
                        tripOrder.setPrice(newTripInfo.getPrice());
                        tripOrderRepository.insert(tripOrder);
                    }
            );
            return newTripInfoOptional;
        });
    }

}
