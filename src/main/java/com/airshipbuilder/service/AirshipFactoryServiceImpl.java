package com.airshipbuilder.service;

import com.airshipbuilder.model.airship.Airplane;
import com.airshipbuilder.model.airship.Airship;
import com.airshipbuilder.model.type.AirshipType;

import java.util.HashMap;
import java.util.Map;

public class AirshipFactoryServiceImpl implements AirshipFactoryService {

    @Override
    public Airship createAirship(AirshipType airshipType, String inputValues) {
        switch (airshipType) {
            case AIRPLANE:
                return createAirplane(inputValues);
            case DRONE:
                return createDrone(inputValues);
            case HELICOPTER:
                return createHelicopter(inputValues);
            case JET:
                return createJet(inputValues);
            case SPACE_ROCKET:
                return createSpaceRocket(inputValues);
            default:
                System.out.println("Not valid option");

        }

        return null;
    }

    private Airship createAirplane(String inputValues) {
        Map<String, String> airplanOptions = createAishipOptions(inputValues);
        return null;
    }

    private Airship createDrone(String inputValues) {
        Map<String, String> airplanOptions = createAishipOptions(inputValues);
        return null;
    }

    private Airship createHelicopter(String inputValues) {
        Map<String, String> airplanOptions = createAishipOptions(inputValues);
        return null;
    }

    private Airship createJet(String inputValues) {
        Map<String, String> airplanOptions = createAishipOptions(inputValues);
        return null;
    }

    private Airship createSpaceRocket(String inputValues) {
        Map<String, String> airplanOptions = createAishipOptions(inputValues);
        return null;
    }

    private Map<String, String> createAishipOptions(String inputValues) {
        Map<String, String> airshipOptions = new HashMap<>();
        String[] pairs = inputValues.split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            airshipOptions.put(keyValue[0], keyValue[1]);
        }

        return airshipOptions;
    }


}
