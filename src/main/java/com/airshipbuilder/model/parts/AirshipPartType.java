package com.airshipbuilder.model.parts;

import java.util.Optional;

public enum AirshipPartType {
    CABIN("cabin"),
    PROPELLERS("propellers"),
    ROCKET("rockets"),
    WINGS("wings");

    private String _partName;

    AirshipPartType(String partName) {
        _partName = partName;
    }

    public String getPartName() {
        return _partName;
    }

    public static Optional<AirshipPartType> getAirshipTypeFromString(String text) {
        for (AirshipPartType airshipPartType : AirshipPartType.values()) {
            if (airshipPartType.getPartName().equalsIgnoreCase(text)) {
                return Optional.of(airshipPartType);
            }
        }
        return Optional.empty();
    }
}
