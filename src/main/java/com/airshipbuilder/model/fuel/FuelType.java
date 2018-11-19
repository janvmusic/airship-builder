package com.airshipbuilder.model.fuel;

import com.airshipbuilder.model.materials.MaterialType;

import java.util.Optional;

public enum FuelType {
    AIR_FUEL(100, "air_fuel"),
    BATTERY(2, "battery"),
    DIESEL(150, "diesel"),
    GASOLINE(50, "gasoline"),
    WATER(1, "water");

    private final int _unitPrice;
    private final String _name;

    FuelType(int unitPrice, String name) {
        _unitPrice = unitPrice;
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public int getUnitPrice() {
        return _unitPrice;
    }

    public static Optional<FuelType> getFuelTypeFromText(String text) {
        for (FuelType fuelType : FuelType.values()) {
            if (fuelType.getName().equalsIgnoreCase(text)) {
                return Optional.of(fuelType);
            }
        }
        return Optional.empty();
    }
}
