package com.airshipbuilder.model.parts;

import com.airshipbuilder.model.materials.MaterialType;

public class Propeller {
    private int _propellerWeight;
    private MaterialType _materialType;

    public Propeller(int propellerWeight, MaterialType materialType) {
        _propellerWeight = propellerWeight;
        _materialType = materialType;
    }

    public int getPropellerWeight() {
        return _propellerWeight;
    }

    public MaterialType getMaterialType() {
        return _materialType;
    }

    public int getTotalPrice() {
        return _materialType.getUnitPrice() * _propellerWeight;
    }
}
