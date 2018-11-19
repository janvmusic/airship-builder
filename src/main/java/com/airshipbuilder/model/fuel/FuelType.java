package com.airshipbuilder.model.fuel;

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

    public static FuelType getFuelTypeFromText(String fuelTypeFromText) throws Exception {
        for (FuelType fuelType : FuelType.values()) {
            if (fuelType.getName().equalsIgnoreCase(fuelTypeFromText)) {
                return fuelType;
            }
        }
        throw new Exception(fuelTypeFromText + " not found");
    }

    public String getName() {
        return _name;
    }

    public int getUnitPrice() {
        return _unitPrice;
    }
}
