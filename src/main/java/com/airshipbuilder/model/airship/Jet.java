package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Rocket;
import com.airshipbuilder.model.parts.Wing;

import java.util.List;

public class Jet extends Airship {
    private List<Wing> _wings;
    private List<Rocket> _rockets;
    private Cabin _cabin;

    public Jet(List<Wing> wings, List<Rocket> rockets, Cabin cabin) {
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
        private List<Wing> _wings;
        private List<Rocket> _rockets;
        private Cabin _cabin;

        private JetBuilder() {
        }

        public static JetBuilder newInstance() {
            return new JetBuilder();
        }

        public JetBuilder addWings(List<Wing> wings) {
            _wings = wings;
            return this;
        }

        public JetBuilder addCabin(Cabin cabin) {
            _cabin = cabin;
            return this;
        }

        public JetBuilder addRockets(List<Rocket> rockets) {
            _rockets = rockets;
            return this;
        }

        public Jet build() {
            return new Jet(_wings, _rockets, _cabin);
        }
    }
}
