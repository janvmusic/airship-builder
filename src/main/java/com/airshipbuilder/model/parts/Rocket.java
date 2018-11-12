package com.airshipbuilder.model.parts;

import com.airshipbuilder.model.materials.MaterialType;

public class Rocket {
    private int _rocketWeigth;
    private MaterialType _materialType;

    public int getRocketWeigth() {
        return _rocketWeigth;
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
