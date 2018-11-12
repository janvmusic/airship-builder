package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Propeller;
import com.airshipbuilder.model.parts.Wing;

import java.util.List;

public class Airplane extends Airship {

    private List<Wing> _wings;
    private List<Propeller> _propellers;
    private Cabin _cabin;

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
}
