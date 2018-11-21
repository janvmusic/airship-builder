package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.type.AirshipCategoryType;

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

    public abstract int getTotalPrice ();

    public abstract int getWeight ();

    public FuelType getFuelType () {
        return _fuelType;
    }

    public AirshipCategoryType getAirshipType () {
        return _airshipCategoryType;
    }

    public int getFuelCapacity () {
        return _fuelCapacity;
    }

    public int getRank () {
        return _rank;
    }

    @Override
    public int compareTo(Airship otherAirship) {
        int rankCompareResult = Integer.compare(this.getRank(), otherAirship.getRank());
        if (rankCompareResult != 0) {
            return rankCompareResult;
        }

        int airshipTypeCompareResult = this.getAirshipType().compareTo(otherAirship.getAirshipType());
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
