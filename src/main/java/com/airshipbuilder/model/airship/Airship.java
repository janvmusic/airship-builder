package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Propeller;
import com.airshipbuilder.model.parts.Rocket;
import com.airshipbuilder.model.parts.Wing;
import com.airshipbuilder.model.type.AirshipCategoryType;
import com.airshipbuilder.model.type.AirshipType;

import java.util.Collections;
import java.util.List;

public abstract class Airship implements Comparable<Airship> {

    private FuelType _fuelType;
    private AirshipCategoryType _airshipCategoryType;
    private int _fuelCapacity;
    private int _rank;

    Airship (FuelType fuelType, AirshipCategoryType airshipCategoryType, int fuelCapacity, int rank) {
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

    public abstract AirshipType getAirshipType();

    public AirshipCategoryType getAirshipCategoryType() {
        return _airshipCategoryType;
    }

    public List<Wing> getWings() {
        return Collections.emptyList();
    }

    public List<Propeller> getPropellers() {
        return Collections.emptyList();
    }

    public List<Rocket> getRockets() {
        return Collections.emptyList();
    }

    public Cabin getCabin() {
        return null;
    }

    public int getFuelCapacity() {
        return _fuelCapacity;
    }

    public int getRank() {
        return _rank;
    }

    @Override
    public int compareTo(Airship otherAirship) {
        int rankCompareResult = Integer.compare(this.getRank(), otherAirship.getRank());
        if (rankCompareResult != 0) {
            return rankCompareResult;
        }

        int airshipTypeCompareResult = this.getAirshipCategoryType().compareTo(otherAirship.getAirshipCategoryType());
        if (airshipTypeCompareResult != 0) {
            return rankCompareResult;
        }

        int priceCompareResult = Integer.compare(otherAirship.getTotalPrice(), this.getTotalPrice());
        if (priceCompareResult != 0) {
            return rankCompareResult;
        }

        return 0;
    }
}
