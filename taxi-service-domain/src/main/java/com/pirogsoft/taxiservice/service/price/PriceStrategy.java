package com.pirogsoft.taxiservice.service.price;

import com.pirogsoft.taxiservice.model.car.Car;
import com.pirogsoft.taxiservice.model.trip.Point;

import java.math.BigDecimal;

public interface PriceStrategy {

    BigDecimal calculatePrice(Point departure, Point destination, Car car);
}
