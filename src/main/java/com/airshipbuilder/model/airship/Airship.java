package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.type.AirshipCategoryType;

public abstract class Airship {

    private FuelType _fuelType;
    private AirshipCategoryType _airshipCategoryType;
    private int _fuelCapacity;

    Airship(FuelType fuelType, AirshipCategoryType airshipCategoryType, int fuelCapacity) {
        _fuelType = fuelType;
        _airshipCategoryType = airshipCategoryType;
        _fuelCapacity = fuelCapacity;
    }

    public abstract int getTotalPrice();

    public abstract int getWeight();

    public FuelType getFuelType() {
        return _fuelType;
    }

    public AirshipCategoryType getAirshipType() {
        return _airshipCategoryType;
    }

    public int getFuelCapacity() {
        return _fuelCapacity;
    }
}
