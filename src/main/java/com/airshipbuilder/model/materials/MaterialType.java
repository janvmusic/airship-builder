package com.airshipbuilder.model.materials;

public enum MaterialType {
    PLASTIC(10, 20),
    STEEL(100, 50),
    TITANIUM(100, 30),
    WOOD(1, 10);

    private final int _unitPrice;
    private final int _unitWeight;

    MaterialType(int unitPrice, int unitWeight) {
        _unitPrice = unitPrice;
        _unitWeight = unitWeight;
    }

    public int getUnitPrice() {
        return _unitPrice;
    }

    public int getUnitWeight() {
        return _unitWeight;
    }
}
