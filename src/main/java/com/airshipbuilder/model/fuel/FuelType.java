package com.airshipbuilder.model.fuel;

public enum FuelType {
    AIR_FUEL(100),
    BATTERY(2),
    DIESEL(150),
    GASOLINE(50),
    WATER(1);

    private final int _unitPrice;

    FuelType(int unitPrice) {
        _unitPrice = unitPrice;
    }

    public int getUnitPrice() {
        return _unitPrice;
    }
}
