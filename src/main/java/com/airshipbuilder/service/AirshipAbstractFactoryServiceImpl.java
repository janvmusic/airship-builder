package com.airshipbuilder.service;

import com.airshipbuilder.model.airship.Airship;
import com.airshipbuilder.model.type.AirshipType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AirshipAbstractFactoryServiceImpl implements AirshipAbstractFactoryService {

    @Override
    public Airship createAirship(JSONObject airshipJson) throws Exception {
        String airshipTypeFromFile = airshipJson.get("airshipType").toString();
        AirshipType airshipTypeFromString = AirshipType.getAirshipTypeFromString(airshipTypeFromFile)
                .orElseThrow(() -> new Exception(airshipTypeFromFile + " not found"));

        switch (airshipTypeFromString) {
            case AIRPLANE:
                return createAirplane(airshipJson);
            case DRONE:
                return createDrone(airshipJson);
            case HELICOPTER:
                return createHelicopter(airshipJson);
            case JET:
                return createJet(airshipJson);
            case SPACE_ROCKET:
                return createSpaceRocket(airshipJson);
            default:
                System.out.println("Not valid option");

        }

        return null;
    }

    private Airship createAirplane(JSONObject inputValues) {
        return null;
    }

    private Airship createDrone(JSONObject inputValues) {
        return null;
    }

    private Airship createHelicopter(JSONObject inputValues) {
        return null;
    }

    private Airship createJet(JSONObject inputValues) {
        return null;
    }

    private Airship createSpaceRocket(JSONObject inputValues) {
        return null;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public JSONArray readAirshipsFromFile() {
        JSONParser parser = new JSONParser();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("json/airship_examples.json").getFile());
            Object airshipElementsFromJson = parser.parse(new FileReader(file));

            return (JSONArray) airshipElementsFromJson;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


}
