package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.parts.Propeller;
import com.airshipbuilder.model.parts.Rocket;
import com.airshipbuilder.model.parts.Wing;

import java.util.List;

public class Drone extends Airship {
    private List<Wing> _wings;
    private List<Propeller> _propellers;
    private List<Rocket> _rockets;

    private Drone(List<Wing> wings, List<Propeller> propellers, List<Rocket> rockets) {
        _wings = wings;
        _propellers = propellers;
        _rockets = rockets;
    }

    public List<Wing> getWings() {
        return _wings;
    }

    public List<Propeller> getPropellers() {
        return _propellers;
    }

    public List<Rocket> getRockets() {
        return _rockets;
    }

    @Override
    public int getTotalPrice() {
        return 0;
    }

    @Override
    public int getWeight() {
        return 0;
    }

    public static class DroneBuilder {
        private List<Wing> _wings;
        private List<Propeller> _propellers;
        private List<Rocket> _rockets;

        private DroneBuilder() {
        }

        public static DroneBuilder newInstance() {
            return new DroneBuilder();
        }

        public DroneBuilder addWings(List<Wing> wings) {
            _wings = wings;
            return this;
        }

        public DroneBuilder addPropellers(List<Propeller> propellers) {
            _propellers = propellers;
            return this;
        }

        public DroneBuilder addRockets(List<Rocket> rockets) {
            _rockets = rockets;
            return this;
        }

        public Drone build() {
            return new Drone(_wings, _propellers, _rockets);
        }
    }
}
