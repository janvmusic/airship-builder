package com.airshipbuilder.model.comparator;

public enum AirshipComparatorType {
    RANK("RANK"),
    HIGHEST_WEIGHT("HIGHEST_WEIGHT"),
    LOWEST_WEIGHT("LOWEST_WEIGHT"),
    HIGHEST_PRICE("HIGHEST_PRICE"),
    LOWEST_PRICE("LOWEST_PRICE"),
    HIGHEST_FUEL("HIGHEST_FUEL"),
    LOWEST_FUEL("LOWEST_FUEL");

    private final String _name;

    AirshipComparatorType (String name) {
        _name = name;
    }

    public static AirshipComparatorType getComparatorType(String comparatorTypeFromText) throws Exception {
        for (AirshipComparatorType airshipComparatorType : AirshipComparatorType.values()) {
            if (airshipComparatorType.getName().equalsIgnoreCase(comparatorTypeFromText)) {
                return airshipComparatorType;
            }
        }
        throw new Exception(comparatorTypeFromText + " not found");
    }

    public String getName() {
        return _name;
    }
}
