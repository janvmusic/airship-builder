package com.airshipbuilder.model.parts;

import com.airshipbuilder.model.materials.MaterialType;

public class Propeller {
    private int _propellerWeigth;
    private MaterialType _materialType;

    public int getPropellerWeigth() {
        return _propellerWeigth;
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
