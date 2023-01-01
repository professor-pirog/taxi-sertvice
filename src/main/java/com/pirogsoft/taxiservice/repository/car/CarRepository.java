package com.pirogsoft.taxiservice.repository.car;

import com.pirogsoft.taxiservice.model.car.Car;
import com.pirogsoft.taxiservice.model.car.Category;

import java.util.List;

public interface CarRepository {

    List<Car> findAvailableCars(int capacity, Category category);

    void update(Car car);
}
