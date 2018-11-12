package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.parts.Propeller;
import com.airshipbuilder.model.parts.Rocket;
import com.airshipbuilder.model.parts.Wing;

import java.util.List;

public class Drone extends Airship {
    private List<Wing> _wings;
    private List<Propeller> _propellers;
    private List<Rocket> _rockets;

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
}
