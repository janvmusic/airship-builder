package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Rocket;
import com.airshipbuilder.model.parts.Wing;

import java.util.List;

public class Jet extends Airship {
    private List<Wing> _wings;
    private List<Rocket> _rockets;
    private Cabin _cabin;

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
    
}
