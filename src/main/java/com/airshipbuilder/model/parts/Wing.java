package com.airshipbuilder.model.parts;

import com.airshipbuilder.model.materials.MaterialType;

public class Wing {
    private int _wingWeight;
    private MaterialType _materialType;

    public Wing(int wingWeight, MaterialType materialType) {
        _wingWeight = wingWeight;
        _materialType = materialType;
    }

    public int getWingWeight() {
        return _wingWeight;
    }

    public MaterialType getMaterialType() {
        return _materialType;
    }

    public int getTotalWeight() {
        return 0;
    }

    public int getTotalPrice() {
        return 0;
    }
}
