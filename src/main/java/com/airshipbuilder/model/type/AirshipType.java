package com.airshipbuilder.model.type;

public enum AirshipType {
    AIRPLANE("airplane"),
    DRONE("drone"),
    HELICOPTER("helicopter"),
    JET("jet"),
    SPACE_ROCKET("space_rocket");

    private String _name;

    AirshipType(String name) {
        _name = name;
    }

    public static AirshipType getAirshipTypeFromString(String airshipTypeFromText) throws Exception {
        for (AirshipType airshipType : AirshipType.values()) {
            if (airshipType.getName().equalsIgnoreCase(airshipTypeFromText)) {
                return airshipType;
            }
        }
        throw new Exception(airshipTypeFromText + " not found");
    }

    public String getName() {
        return _name;
    }
}
