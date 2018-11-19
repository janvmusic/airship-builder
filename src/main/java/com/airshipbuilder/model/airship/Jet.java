package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Propeller;
import com.airshipbuilder.model.parts.Rocket;
import com.airshipbuilder.model.parts.Wing;
import com.airshipbuilder.model.type.AirshipCategoryType;

import java.util.ArrayList;
import java.util.List;

public class Jet extends Airship {
    private List<Wing> _wings;
    private List<Rocket> _rockets;
    private Cabin _cabin;

    private Jet(List<Wing> wings, List<Rocket> rockets, Cabin cabin, int _fuelCapacity, FuelType _fuelType, AirshipCategoryType _airshipCategoryType) {
        super(_fuelType, _airshipCategoryType, _fuelCapacity);
        _wings = wings;
        _rockets = rockets;
        _cabin = cabin;
    }

    public Cabin getCabin() {
        return _cabin;
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

    public static class JetBuilder extends AirshipBuilder {
        private List<Wing> _wings = new ArrayList<>();
        private List<Rocket> _rockets = new ArrayList<>();
        private Cabin _cabin;

        private JetBuilder() {
        }

        public static JetBuilder newInstance() {
            return new JetBuilder();
        }

        public JetBuilder addCabin(Cabin cabin) {
            _cabin = cabin;
            return this;
        }

        @Override
        public JetBuilder addPropeller(Propeller propeller) {
            System.out.println("Method not implemented: addPropeller for jets");
            return this;
        }

        @Override
        public JetBuilder addRocket(Rocket rocket) {
            _rockets.add(rocket);
            return this;
        }

        @Override
        public JetBuilder addWing(Wing wing) {
            _wings.add(wing);
            return this;
        }

        public Jet build() {
            return new Jet(_wings, _rockets, _cabin, getFuelCapacity(), getFuelType(), getAirshipCategoryType());
        }
    }
}
