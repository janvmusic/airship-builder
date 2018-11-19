package com.airshipbuilder.model.type;

import java.util.Optional;

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

    public String getName() {
        return _name;
    }

    public static Optional<AirshipType> getAirshipTypeFromString(String text) {
        for (AirshipType airshipType : AirshipType.values()) {
            if (airshipType.getName().equalsIgnoreCase(text)) {
                return Optional.of(airshipType);
            }
        }
        return Optional.empty();
    }
}
