package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Propeller;
import com.airshipbuilder.model.parts.Wing;
import com.airshipbuilder.model.type.AirshipCategoryType;

import java.util.ArrayList;
import java.util.List;

public class Airplane extends Airship {

    private List<Wing> _wings;
    private List<Propeller> _propellers;
    private Cabin _cabin;

    private Airplane(List<Wing> wings, List<Propeller> propellers, Cabin cabin, int _fuelCapacity,
                     FuelType _fuelType, AirshipCategoryType _airshipCategoryType) {
        super(_fuelType, _airshipCategoryType, _fuelCapacity);
        _wings = wings;
        _propellers = propellers;
        _cabin = cabin;
    }

    public List<Wing> getWings() {
        return _wings;
    }

    public List<Propeller> getPropellers() {
        return _propellers;
    }

    public Cabin getCabin() {
        return _cabin;
    }

    @Override
    public int getTotalPrice() {
        return 0;
    }

    @Override
    public int getWeight() {
        return 0;
    }

    public static class AirplaneBuilder {
        private List<Wing> _wings = new ArrayList<>();
        private List<Propeller> _propellers = new ArrayList<>();
        private Cabin _cabin;
        private FuelType _fuelType;
        private int _fuelCapacity;
        private AirshipCategoryType _airshipCategoryType;

        private AirplaneBuilder() {

        }

        public static AirplaneBuilder newInstance() {
            return new AirplaneBuilder();
        }

        public AirplaneBuilder addWings(Wing wing) {
            _wings.add(wing);
            return this;
        }

        public AirplaneBuilder addPropellers(Propeller propeller) {
            _propellers.add(propeller);
            return this;
        }

        public AirplaneBuilder addCabin(Cabin cabin) {
            _cabin = cabin;
            return this;
        }

        public AirplaneBuilder withFuelType(FuelType fuelType) {
            _fuelType = fuelType;
            return this;
        }

        public AirplaneBuilder withFuelCapacity(int fuelCapacity) {
            _fuelCapacity = fuelCapacity;
            return this;
        }

        public AirplaneBuilder withCategory(AirshipCategoryType airshipCategoryType) {
            _airshipCategoryType = airshipCategoryType;
            return this;
        }

        public Airplane build() {
            return new Airplane(_wings, _propellers, _cabin, _fuelCapacity, _fuelType, _airshipCategoryType);
        }
    }
}
