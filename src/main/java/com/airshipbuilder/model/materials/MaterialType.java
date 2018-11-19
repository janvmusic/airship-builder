package com.airshipbuilder.model.materials;

import com.airshipbuilder.model.type.AirshipType;

import java.util.Optional;

public enum MaterialType {
    PLASTIC(10, 20, "plastic"),
    STEEL(100, 50, "steel"),
    TITANIUM(100, 30, "titanium"),
    WOOD(1, 10, "wood");

    private final int _unitPrice;
    private final int _unitWeight;
    private final String _name;

    MaterialType(int unitPrice, int unitWeight, String name) {
        _unitPrice = unitPrice;
        _unitWeight = unitWeight;
        _name = name;
    }

    public int getUnitPrice() {
        return _unitPrice;
    }

    public int getUnitWeight() {
        return _unitWeight;
    }

    public String getName() {
        return _name;
    }

    public static Optional<MaterialType> getMaterialTypeFromText(String text) {
        for (MaterialType materialType : MaterialType.values()) {
            if (materialType.getName().equalsIgnoreCase(text)) {
                return Optional.of(materialType);
            }
        }
        return Optional.empty();
    }
}
