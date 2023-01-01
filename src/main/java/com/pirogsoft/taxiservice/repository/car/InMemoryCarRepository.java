package com.pirogsoft.taxiservice.repository.car;

import com.pirogsoft.taxiservice.model.car.Car;
import com.pirogsoft.taxiservice.model.car.Category;
import com.pirogsoft.taxiservice.model.car.Status;
import com.pirogsoft.taxiservice.model.user.User;

import java.util.List;

public class InMemoryCarRepository implements CarRepository {

    @Override
    public List<Car> findAvailableCars(int capacity, Category category) {
        return List.of(
                new Car(
                        new User(null, "Иван", "Иванов", "+380984120000", "Pidor@hui.com"),
                        "huidai",
                        "хуйдай",
                        Category.ECONOMY,
                        Status.AVAILABLE,
                        4
                )
        );
    }

    @Override
    public void update(Car car) {

    }
}
