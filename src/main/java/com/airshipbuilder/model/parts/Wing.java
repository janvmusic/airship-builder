package com.airshipbuilder.model.parts;

import com.airshipbuilder.model.materials.MaterialType;

import java.util.StringJoiner;

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

    public int getTotalPrice() {
        return _materialType.getUnitPrice() * _wingWeight;
    }

    @Override
    public String toString () {
        return new StringJoiner(", ", Wing.class.getSimpleName() + "[", "]") //
                .add("wingWeight=" + _wingWeight) //
                .add("materialType=" + _materialType) //
                .toString();
    }
}
