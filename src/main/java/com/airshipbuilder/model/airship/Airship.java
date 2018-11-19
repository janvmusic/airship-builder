package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.type.AirshipCategoryType;

public abstract class Airship {

    private FuelType _fuelType;
    private AirshipCategoryType _airshipCategoryType;
    private int _fuelCapacity;
    private int _rank;

    Airship(FuelType fuelType, AirshipCategoryType airshipCategoryType, int fuelCapacity, int rank) {
        _fuelType = fuelType;
        _airshipCategoryType = airshipCategoryType;
        _fuelCapacity = fuelCapacity;
        _rank = rank;
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

    public int getRank() {
        return _rank;
    }
}
