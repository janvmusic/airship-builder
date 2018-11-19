package com.airshipbuilder.model.parts;

import com.airshipbuilder.model.materials.MaterialType;

public class Cabin {
    private int _cabinWeight;
    private MaterialType _materialType;

    public Cabin(int cabinWeight, MaterialType materialType) {
        _cabinWeight = cabinWeight;
        _materialType = materialType;
    }

    public int getCabinWeight() {
        return _cabinWeight;
    }

    public MaterialType getMaterialType() {
        return _materialType;
    }

    public int getTotalPrice() {
        return _materialType.getUnitPrice() * _cabinWeight;
    }
}
