package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Propeller;

import java.util.List;

public class Helicopter extends Airship {

    private List<Propeller> _propellers;
    private Cabin _cabin;

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
}
