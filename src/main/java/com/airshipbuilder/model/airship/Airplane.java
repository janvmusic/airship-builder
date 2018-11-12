package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Propeller;
import com.airshipbuilder.model.parts.Wing;

import java.util.List;

public class Airplane extends Airship {

    private List<Wing> _wings;
    private List<Propeller> _propellers;
    private Cabin _cabin;

    private Airplane(List<Wing> wings, List<Propeller> propellers, Cabin cabin) {
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
        private List<Wing> _wings;
        private List<Propeller> _propellers;
        private Cabin _cabin;

        private AirplaneBuilder() {

        }

        public static AirplaneBuilder newInstance() {
            return new AirplaneBuilder();
        }

        public AirplaneBuilder addWings(List<Wing> wings) {
            _wings = wings;
            return this;
        }

        public AirplaneBuilder addPropellers(List<Propeller> propellers) {
            _propellers = propellers;
            return this;
        }

        public AirplaneBuilder addCabin(Cabin cabin) {
            _cabin = cabin;
            return this;
        }

        public Airplane build() {
            return new Airplane(_wings, _propellers, _cabin);
        }
    }
}
