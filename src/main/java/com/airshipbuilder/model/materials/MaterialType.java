package com.airshipbuilder.model.materials;

public enum MaterialType {
    PLASTIC(10, "plastic"),
    STEEL(100, "steel"),
    TITANIUM(100, "titanium"),
    WOOD(1, "wood");

    private final int _unitPrice;
    private final String _name;

    MaterialType(int unitPrice, String name) {
        _unitPrice = unitPrice;
        _name = name;
    }

    public static MaterialType getMaterialTypeFromText(String materialTypeFromText) throws Exception {
        for (MaterialType materialType : MaterialType.values()) {
            if (materialType.getName().equalsIgnoreCase(materialTypeFromText)) {
                return materialType;
            }
        }
        throw new Exception(materialTypeFromText + " not found");
    }

    public int getUnitPrice() {
        return _unitPrice;
    }

    public String getName() {
        return _name;
    }
}
