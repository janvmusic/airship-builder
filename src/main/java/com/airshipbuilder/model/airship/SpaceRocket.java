package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Rocket;
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

    public List<Rocket> getRockets() {
        return _rockets;
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

        public SpaceRocketBuilder addRockets(Rocket rocket) {
            _rockets.add(rocket);
            return this;
        }

        public SpaceRocket build() {
            return new SpaceRocket(_rockets, _cabin, getFuelCapacity(), getFuelType(), getAirshipCategoryType());
        }
    }
}
