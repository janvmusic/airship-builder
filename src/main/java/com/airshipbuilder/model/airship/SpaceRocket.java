package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Propeller;
import com.airshipbuilder.model.parts.Rocket;
import com.airshipbuilder.model.parts.Wing;
import com.airshipbuilder.model.type.AirshipCategoryType;

import java.util.ArrayList;
import java.util.List;

public class SpaceRocket extends Airship {

    private List<Rocket> _rockets;
    private Cabin _cabin;

    private SpaceRocket(List<Rocket> rockets, Cabin cabin, int _fuelCapacity, FuelType _fuelType, AirshipCategoryType _airshipCategoryType) {
        super(_fuelType, _airshipCategoryType, _fuelCapacity);
        _rockets = rockets;
        _cabin = cabin;
    }

    public Cabin getCabin() {
        return _cabin;
    }

    public List<Rocket> getRocket() {
        return _rockets;
    }

    @Override
    public int getTotalPrice() {
        int rocketsTotalPrice = _rockets.stream().mapToInt(Rocket::getTotalPrice).sum();

        return _cabin.getTotalPrice() + rocketsTotalPrice;
    }

    @Override
    public int getWeight() {
        int rocketsTotalWeight = _rockets.stream().mapToInt(Rocket::getRocketWeight).sum();

        return _cabin.getCabinWeight() + rocketsTotalWeight;
    }

    public static class SpaceRocketBuilder extends AirshipBuilder {
        private List<Rocket> _rockets = new ArrayList<>();
        private Cabin _cabin;

        private SpaceRocketBuilder() {
        }

        public static SpaceRocketBuilder newInstance() {
            return new SpaceRocketBuilder();
        }

        public SpaceRocketBuilder addCabin(Cabin cabin) {
            _cabin = cabin;
            return this;
        }

        @Override
        public SpaceRocketBuilder addPropeller(Propeller propeller) {
            System.out.println("Method not implemented: addPropeller for space rockets");
            return this;
        }

        @Override
        public SpaceRocketBuilder addRocket(Rocket rocket) {
            _rockets.add(rocket);
            return this;
        }

        @Override
        public SpaceRocketBuilder addWing(Wing wing) {
            System.out.println("Method not implemented: addPropeller for space rockets");
            return this;
        }


        public SpaceRocket build() {
            return new SpaceRocket(_rockets, _cabin, getFuelCapacity(), getFuelType(), getAirshipCategoryType());
        }
    }
}
