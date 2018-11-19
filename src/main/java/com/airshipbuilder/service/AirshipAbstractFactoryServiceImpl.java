package com.airshipbuilder.service;

import com.airshipbuilder.model.airship.Airplane;
import com.airshipbuilder.model.airship.Airship;
import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Propeller;
import com.airshipbuilder.model.parts.Wing;
import com.airshipbuilder.model.type.AirshipCategoryType;
import com.airshipbuilder.model.type.AirshipType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class AirshipAbstractFactoryServiceImpl implements AirshipAbstractFactoryService {

    private PartFactoryService partFactoryService = new PartFactoryServiceImpl();

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

    private Airship createAirplane(JSONObject inputValues) throws Exception {
        Airplane.AirplaneBuilder airplaneBuilder = Airplane.AirplaneBuilder.newInstance();

        Set airshipParts = inputValues.keySet();
        for (Object airshipPart : airshipParts) {
            String airshipPartType = (String) airshipPart;

            switch (airshipPartType) {
                case "cabin":
                    JSONObject cabinElementsJson = (JSONObject) inputValues.get(airshipPartType);
                    Cabin cabin = partFactoryService.createCabin(cabinElementsJson);
                    airplaneBuilder.addCabin(cabin);
                    break;
                case "propeller":
                    JSONArray propellerElementsJson = (JSONArray) inputValues.get(airshipPartType);
                    for (Object propellerElements : propellerElementsJson) {
                        Propeller propeller = partFactoryService.createPropeller((JSONObject) propellerElements);
                        airplaneBuilder.addPropellers(propeller);
                    }
                    break;
                case "wings":
                    JSONArray wingElementsJson = (JSONArray) inputValues.get(airshipPartType);
                    for (Object wingElements : wingElementsJson) {
                        Wing wing = partFactoryService.createWing((JSONObject) wingElements);
                        airplaneBuilder.addWings(wing);
                    }
                    break;
                case "fuelType":
                    String fuelTypeString = (String) inputValues.get(airshipPartType);
                    FuelType fuelType = FuelType.getFuelTypeFromText(fuelTypeString)
                            .orElseThrow(() -> new Exception(fuelTypeString + " not found"));
                    airplaneBuilder.withFuelType(fuelType);
                    break;
                case "fuelCapacity":
                    Long fuelCapacity = (Long) inputValues.get(airshipPartType);
                    airplaneBuilder.withFuelCapacity(fuelCapacity.intValue());
                    break;
                case "categoryType":
                    String categoryTypeString = (String) inputValues.get(airshipPartType);
                    AirshipCategoryType airshipCategoryType = AirshipCategoryType.getAirshipCategoryTypeFromText(categoryTypeString)
                            .orElseThrow(() -> new Exception(categoryTypeString + " not found"));
                    airplaneBuilder.withCategory(airshipCategoryType);
                default:
                    break;
            }
        }

        return airplaneBuilder.build();
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
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


}
