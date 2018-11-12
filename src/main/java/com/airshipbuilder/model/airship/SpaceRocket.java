package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Rocket;

import java.util.List;

public class SpaceRocket extends Airship {

    private List<Rocket> _rockets;
    private Cabin _cabin;

    public SpaceRocket(List<Rocket> rockets, Cabin cabin) {
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

    public static class SpaceRocketBuilder {
        private List<Rocket> _rockets;
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

        public SpaceRocketBuilder addRockets(List<Rocket> rockets) {
            _rockets = rockets;
            return this;
        }

        public SpaceRocket build() {
            return new SpaceRocket(_rockets, _cabin);
        }
    }
}
