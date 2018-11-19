package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.parts.Propeller;
import com.airshipbuilder.model.parts.Rocket;
import com.airshipbuilder.model.parts.Wing;
import com.airshipbuilder.model.type.AirshipCategoryType;

public abstract class AirshipBuilder {
    private FuelType _fuelType;
    private int _fuelCapacity;
    private AirshipCategoryType _airshipCategoryType;
    private int _rank;

    public abstract AirshipBuilder addPropeller(Propeller propeller);

    public abstract AirshipBuilder addRocket(Rocket rocket);

    public abstract AirshipBuilder addWing(Wing wing);

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

    public AirshipBuilder withRank(int rank) {
        _rank = rank;
        return this;
    }

    FuelType getFuelType() {
        return _fuelType;
    }

    int getFuelCapacity() {
        return _fuelCapacity;
    }

    AirshipCategoryType getAirshipCategoryType() {
        return _airshipCategoryType;
    }

    public int getRank() {
        return _rank;
    }
}
