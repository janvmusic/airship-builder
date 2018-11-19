package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Rocket;
import com.airshipbuilder.model.parts.Wing;
import com.airshipbuilder.model.type.AirshipCategoryType;

import java.util.ArrayList;
import java.util.List;

public class Jet extends Airship {
    private List<Wing> _wings;
    private List<Rocket> _rockets;
    private Cabin _cabin;

    public Jet(List<Wing> wings, List<Rocket> rockets, Cabin cabin, int _fuelCapacity, FuelType _fuelType, AirshipCategoryType _airshipCategoryType) {
        super(_fuelType, _airshipCategoryType, _fuelCapacity);
        _wings = wings;
        _rockets = rockets;
        _cabin = cabin;
    }

    public List<Wing> getWings() {
        return _wings;
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

    public static class JetBuilder {
        private List<Wing> _wings = new ArrayList<>();
        private List<Rocket> _rockets = new ArrayList<>();
        private Cabin _cabin;
        private int _fuelCapacity;
        private FuelType _fuelType;
        private AirshipCategoryType _airshipCategoryType;

        private JetBuilder() {
        }

        public static JetBuilder newInstance() {
            return new JetBuilder();
        }

        public JetBuilder addWings(Wing wing) {
            _wings.add(wing);
            return this;
        }

        public JetBuilder addCabin(Cabin cabin) {
            _cabin = cabin;
            return this;
        }

        public JetBuilder addRockets(Rocket rocket) {
            _rockets.add(rocket);
            return this;
        }

        public JetBuilder withFuelType(FuelType fuelType) {
            _fuelType = fuelType;
            return this;
        }

        public JetBuilder withFuelCapacity(int fuelCapacity) {
            _fuelCapacity = fuelCapacity;
            return this;
        }

        public JetBuilder withCategory(AirshipCategoryType airshipCategoryType) {
            _airshipCategoryType = airshipCategoryType;
            return this;
        }

        public Jet build() {
            return new Jet(_wings, _rockets, _cabin, _fuelCapacity, _fuelType, _airshipCategoryType);
        }
    }
}
