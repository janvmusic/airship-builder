package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.type.AirshipCategoryType;

public class AirshipBuilder {
    private FuelType _fuelType;
    private int _fuelCapacity;
    private AirshipCategoryType _airshipCategoryType;

    public AirshipBuilder withFuelType(FuelType fuelType) {
        _fuelType = fuelType;
        return this;
    }

    public AirshipBuilder withFuelCapacity(int fuelCapacity) {
        _fuelCapacity = fuelCapacity;
        return this;
    }

    public AirshipBuilder withCategory(AirshipCategoryType airshipCategoryType) {
        _airshipCategoryType = airshipCategoryType;
        return this;
    }

    public FuelType getFuelType() {
        return _fuelType;
    }

    public int getFuelCapacity() {
        return _fuelCapacity;
    }

    public AirshipCategoryType getAirshipCategoryType() {
        return _airshipCategoryType;
    }
}
