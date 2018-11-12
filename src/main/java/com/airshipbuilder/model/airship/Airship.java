package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.type.AirshipType;

abstract class Airship {

    private FuelType _fuelType;
    private AirshipType _airshipType;
    private int _fuelCapacity;

    public abstract int getTotalPrice();
    public abstract int getWeight();

    public FuelType getFuelType() {
        return _fuelType;
    }

    public AirshipType getAirshipType() {
        return _airshipType;
    }

    public int getFuelCapacity() {
        return _fuelCapacity;
    }
}
