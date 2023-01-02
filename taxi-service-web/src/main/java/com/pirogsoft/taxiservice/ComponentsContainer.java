package com.pirogsoft.taxiservice;

import com.pirogsoft.taxiservice.repository.car.CarRepository;
import com.pirogsoft.taxiservice.repository.car.InMemoryCarRepository;
import com.pirogsoft.taxiservice.repository.trip.InMemoryTripOrderRepository;
import com.pirogsoft.taxiservice.repository.trip.TripOrderRepository;
import com.pirogsoft.taxiservice.repository.user.UserMemoryRepositoryImpl;
import com.pirogsoft.taxiservice.repository.user.UserRepository;
import com.pirogsoft.taxiservice.service.OrderingService;
import com.pirogsoft.taxiservice.service.UserService;
import com.pirogsoft.taxiservice.service.price.PifagorPriceStrategy;
import com.pirogsoft.taxiservice.service.price.PriceStrategy;
import com.pirogsoft.taxiservice.transaction.EmptyTransactionManager;
import com.pirogsoft.taxiservice.transaction.TransactionManager;

public class ComponentsContainer {

    private static ComponentsContainer instance;

    private UserService userService;

    private UserRepository userRepository;

    private CarRepository carRepository;

    private PriceStrategy priceStrategy;

    private TransactionManager transactionManager;

    private OrderingService orderingService;

    private TripOrderRepository tripOrderRepository;

    private ComponentsContainer() {
    }

    public static synchronized ComponentsContainer getInstance() {
        if (instance == null) {
            instance = new ComponentsContainer();
        }
        return instance;
    }

    public synchronized UserService getUserService() {
        if (userService == null) {
            userService = new UserService(getUserRepository());
        }
        return userService;
    }

    public synchronized UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserMemoryRepositoryImpl();
        }
        return userRepository;
    }

    public CarRepository getCarRepository() {
        if (carRepository == null) {
            carRepository = new InMemoryCarRepository();
        }
        return carRepository;
    }

    public PriceStrategy getPriceStrategy() {
        if (priceStrategy == null) {
            priceStrategy = new PifagorPriceStrategy();
        }
        return priceStrategy;
    }

    public TransactionManager getTransactionManager() {
        if (transactionManager == null) {
            transactionManager = new EmptyTransactionManager();
        }
        return transactionManager;
    }

    public synchronized OrderingService getOrderingService() {
        if (orderingService == null) {
            orderingService = new OrderingService(
                    getCarRepository(),
                    getPriceStrategy(),
                    getTransactionManager(),
                    getTripOrderRepository()
            );
        }
        return orderingService;
    }

    private TripOrderRepository getTripOrderRepository() {
        if (tripOrderRepository == null) {
            tripOrderRepository = new InMemoryTripOrderRepository();
        }
        return tripOrderRepository;
    }
}
