package com.airshipbuilder.model.parts;

public enum AirshipPartType {
    CABIN("cabin"),
    PROPELLERS("propellers"),
    ROCKET("rockets"),
    WINGS("wings"),
    FUEL_TYPE("fuelType"),
    FUEL_CAPACITY("fuelCapacity"),
    MATERIAL_TYPE("materialType"),
    AIRSHIP_CATEGORY("categoryType"),
    AIRSHIP_TYPE("airshipType");

    private String _partName;

    AirshipPartType(String partName) {
        _partName = partName;
    }

    public static AirshipPartType getAirshipTypeFromString(String airshipTypeFromString) throws Exception {
        for (AirshipPartType airshipPartType : AirshipPartType.values()) {
            if (airshipPartType.getPartName().equalsIgnoreCase(airshipTypeFromString)) {
                return airshipPartType;
            }
        }
        throw new Exception(airshipTypeFromString + " not found");
    }

    public String getPartName() {
        return _partName;
    }
}
