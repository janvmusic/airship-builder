package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Propeller;

import java.util.List;

public class Helicopter extends Airship {

    private List<Propeller> _propellers;
    private Cabin _cabin;

    private Helicopter(List<Propeller> propellers, Cabin cabin) {
        _propellers = propellers;
        _cabin = cabin;
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

    public static class HelicopterBuilder {
        private List<Propeller> _propellers;
        private Cabin _cabin;

        private HelicopterBuilder() {
        }

        public static HelicopterBuilder newInstance() {
            return new HelicopterBuilder();
        }

        public HelicopterBuilder addCabin(Cabin cabin) {
            _cabin = cabin;
            return this;
        }

        public HelicopterBuilder addPropellers(List<Propeller> propellers) {
            _propellers = propellers;
            return this;
        }

        public Helicopter build() {
            return new Helicopter(_propellers, _cabin);
        }
    }
}
