package com.airshipbuilder.model.parts;

import com.airshipbuilder.model.materials.MaterialType;

public class Cabin {
    private int _cabinWeigth;
    private MaterialType _materialType;

    public int getCabinWeigth() {
        return _cabinWeigth;
    }

    public MaterialType getMaterialType() {
        return _materialType;
    }

    public int totalWeigth() {
        return 0;
    }

    public int totalPrice() {
        return 0;
    }
}
