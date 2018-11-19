package com.airshipbuilder.model.type;

import com.airshipbuilder.model.materials.MaterialType;

import java.util.Optional;

public enum AirshipCategoryType {
    COMMERCIAL("commercial"),
    MILITARY("military"),
    PHOTOGRAPHY("photography");

    private String _name;

    AirshipCategoryType(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public static Optional<AirshipCategoryType> getAirshipCategoryTypeFromText(String text) {
        for (AirshipCategoryType airshipCategoryType : AirshipCategoryType.values()) {
            if (airshipCategoryType.getName().equalsIgnoreCase(text)) {
                return Optional.of(airshipCategoryType);
            }
        }
        return Optional.empty();
    }
}
