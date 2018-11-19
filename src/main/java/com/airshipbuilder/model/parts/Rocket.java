package com.airshipbuilder.model.parts;

import com.airshipbuilder.model.materials.MaterialType;

public class Rocket {
    private int _rocketWeight;
    private MaterialType _materialType;

    public Rocket(int rocketWeight, MaterialType materialType) {
        _rocketWeight = rocketWeight;
        _materialType = materialType;
    }

    public int getRocketWeight() {
        return _rocketWeight;
    }

    public MaterialType getMaterialType() {
        return _materialType;
    }

    public int getTotalPrice() {
        return _materialType.getUnitPrice() * _rocketWeight;
    }
}
