package com.airshipbuilder.model.type;

public enum AirshipCategoryType {
    COMMERCIAL("commercial"),
    MILITARY("military"),
    PHOTOGRAPHY("photography");

    private String _name;

    AirshipCategoryType(String name) {
        _name = name;
    }

    public static AirshipCategoryType getAirshipCategoryTypeFromText(String airshipCategoryTypeFromText) throws Exception {
        for (AirshipCategoryType airshipCategoryType : AirshipCategoryType.values()) {
            if (airshipCategoryType.getName().equalsIgnoreCase(airshipCategoryTypeFromText)) {
                return airshipCategoryType;
            }
        }
        throw new Exception(airshipCategoryTypeFromText + " not found");
    }

    public String getName() {
        return _name;
    }
}
