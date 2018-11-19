package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.parts.Propeller;
import com.airshipbuilder.model.parts.Rocket;
import com.airshipbuilder.model.parts.Wing;
import com.airshipbuilder.model.type.AirshipCategoryType;

import java.util.ArrayList;
import java.util.List;

public class Drone extends Airship {
    private List<Wing> _wings;
    private List<Propeller> _propellers;
    private List<Rocket> _rockets;

    private Drone(List<Wing> wings, List<Propeller> propellers, List<Rocket> rockets, int _fuelCapacity, FuelType _fuelType, AirshipCategoryType _airshipCategoryType) {
        super(_fuelType, _airshipCategoryType, _fuelCapacity);
        _wings = wings;
        _propellers = propellers;
        _rockets = rockets;
    }

    public List<Propeller> getPropellers() {
        return _propellers;
    }

    public List<Rocket> getRockets() {
        return _rockets;
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

    public static class DroneBuilder extends AirshipBuilder {
        private List<Wing> _wings = new ArrayList<>();
        private List<Propeller> _propellers = new ArrayList<>();
        private List<Rocket> _rockets = new ArrayList<>();

        private DroneBuilder() {
        }

        public static DroneBuilder newInstance() {
            return new DroneBuilder();
        }

        @Override
        public DroneBuilder addPropeller(Propeller propeller) {
            _propellers.add(propeller);
            return this;
        }

        @Override
        public DroneBuilder addRocket(Rocket rocket) {
            _rockets.add(rocket);
            return this;
        }

        @Override
        public DroneBuilder addWing(Wing wings) {
            _wings.add(wings);
            return this;
        }

        public Drone build() {
            return new Drone(_wings, _propellers, _rockets, getFuelCapacity(), getFuelType(), getAirshipCategoryType());
        }
    }
}
