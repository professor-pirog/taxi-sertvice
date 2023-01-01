package com.pirogsoft.taxiservice.model.car;

import com.pirogsoft.taxiservice.model.user.User;

public class Car {

    private final User driver;

    private final String carNameEng;

    private final String carNameRu;

    private final Category carCategory;

    private Status status;

    private final int capacity;

    public Car(User driver, String carNameEng, String carNameRu, Category carCategory, Status status, int capacity) {
        this.driver = driver;
        this.carNameEng = carNameEng;
        this.carNameRu = carNameRu;
        this.carCategory = carCategory;
        this.status = status;
        this.capacity = capacity;
    }

    public User getDriver() {
        return driver;
    }

    public String getCarNameEng() {
        return carNameEng;
    }

    public String getCarNameRu() {
        return carNameRu;
    }

    public Category getCarCategory() {
        return carCategory;
    }

    public Status getStatus() {
        return status;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
