package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.parts.Propeller;
import com.airshipbuilder.model.parts.Rocket;
import com.airshipbuilder.model.parts.Wing;
import com.airshipbuilder.model.type.AirshipCategoryType;
import com.airshipbuilder.model.type.AirshipType;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Drone extends Airship {
    private List<Wing> _wings;
    private List<Propeller> _propellers;
    private List<Rocket> _rockets;

    private Drone(List<Wing> wings, List<Propeller> propellers, List<Rocket> rockets, int _fuelCapacity,
                  FuelType _fuelType, AirshipCategoryType _airshipCategoryType, int rank) {
        super(_fuelType, _airshipCategoryType, _fuelCapacity, rank);
        _wings = wings;
        _propellers = propellers;
        _rockets = rockets;
    }

    @Override
    public List<Propeller> getPropellers() {
        return _propellers;
    }

    @Override
    public List<Rocket> getRockets() {
        return _rockets;
    }

    @Override
    public List<Wing> getWings() {
        return _wings;
    }

    @Override
    public AirshipType getAirshipType(){
        return AirshipType.DRONE;
    }

    @Override
    public int getTotalPrice() {
        int propellersTotalPrice = _propellers.stream().mapToInt(Propeller::getTotalPrice).sum();
        int rocketsTotalPrice = _rockets.stream().mapToInt(Rocket::getTotalPrice).sum();
        int wingsTotalPrice = _wings.stream().mapToInt(Wing::getTotalPrice).sum();

        return propellersTotalPrice + rocketsTotalPrice + wingsTotalPrice;
    }

    @Override
    public int getWeight() {
        int propellersTotalWeight = _propellers.stream().mapToInt(Propeller::getPropellerWeight).sum();
        int rocketsTotalWeight = _rockets.stream().mapToInt(Rocket::getRocketWeight).sum();
        int wingsTotalWeight = _wings.stream().mapToInt(Wing::getWingWeight).sum();

        return propellersTotalWeight + rocketsTotalWeight + wingsTotalWeight;
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
            return new Drone(_wings, _propellers, _rockets, getFuelCapacity(), getFuelType(), getAirshipCategoryType(),
                    getRank());
        }
    }

    @Override
    public String toString () {
        return new StringJoiner(", ", Drone.class.getSimpleName() + "[", "]") //
                .add("rank=" + getRank()) //
                .add("airshipCategoryType=" + getAirshipType()) //
                .add("totalPrice=" + getTotalPrice()) //
                .add("weight=" + getWeight()) //
                .add("fuelType=" + getFuelType()) //
                .add("fuelCapacity=" + getFuelCapacity()) //
                .add("numberOfWings=" + _wings.size()) //
                .add("numberOfPropellers=" + _propellers.size()) //
                .add("numberOfRockets=" + _rockets.size()) //
                .toString();
    }
}
