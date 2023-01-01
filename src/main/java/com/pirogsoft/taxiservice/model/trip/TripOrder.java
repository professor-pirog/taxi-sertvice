package com.pirogsoft.taxiservice.model.trip;

import com.pirogsoft.taxiservice.model.car.Car;
import com.pirogsoft.taxiservice.model.car.Category;
import com.pirogsoft.taxiservice.model.user.User;

import java.math.BigDecimal;
import java.time.Instant;

public class TripOrder {

    private int id;
    private final AddressPoint departure;
    private final AddressPoint destination;
    private final Category category;
    private final int capacity;
    private final User user;
    private final Instant timestamp;

    private Car car;

    private BigDecimal price;

    public TripOrder(AddressPoint departure, AddressPoint destination, Category category, int capacity, User user, Instant timestamp) {
        this.departure = departure;
        this.destination = destination;
        this.category = category;
        this.capacity = capacity;
        this.user = user;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public AddressPoint getDeparture() {
        return departure;
    }

    public AddressPoint getDestination() {
        return destination;
    }

    public Category getCategory() {
        return category;
    }

    public int getCapacity() {
        return capacity;
    }

    public User getUser() {
        return user;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Car getCar() {
        return car;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
