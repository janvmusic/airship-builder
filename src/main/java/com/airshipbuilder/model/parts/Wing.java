package com.airshipbuilder.model.parts;

import com.airshipbuilder.model.materials.MaterialType;

public class Wing {
    private int _wingWeigth;
    private MaterialType _materialType;

    public int getWingWeigth() {
        return _wingWeigth;
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
