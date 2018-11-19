package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Propeller;
import com.airshipbuilder.model.parts.Rocket;
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

    public Cabin getCabin() {
        return _cabin;
    }

    public List<Propeller> getPropellers() {
        return _propellers;
    }

    public List<Wing> getWings() {
        return _wings;
    }

    @Override
    public int getTotalPrice() {
        return 0;
    }

    @Override
    public int getWeight() {
        return 0;
    }

    public static class AirplaneBuilder extends AirshipBuilder {
        private List<Wing> _wings = new ArrayList<>();
        private List<Propeller> _propellers = new ArrayList<>();
        private Cabin _cabin;

        private AirplaneBuilder() {

        }

        public static AirplaneBuilder newInstance() {
            return new AirplaneBuilder();
        }

        public AirplaneBuilder addCabin(Cabin cabin) {
            _cabin = cabin;
            return this;
        }

        @Override
        public AirplaneBuilder addPropeller(Propeller propeller) {
            _propellers.add(propeller);
            return this;
        }

        @Override
        public AirplaneBuilder addRocket(Rocket rocket) {
            System.out.println("Method not implemented: addRocket for airplane");
            return this;
        }

        @Override
        public AirplaneBuilder addWing(Wing wing) {
            _wings.add(wing);
            return this;
        }

        public Airplane build() {
            return new Airplane(_wings, _propellers, _cabin, getFuelCapacity(), getFuelType(), getAirshipCategoryType());
        }
    }
}
