package com.airshipbuilder.service;

import com.airshipbuilder.model.airship.*;
import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.parts.*;
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
            AirshipPartType partType = AirshipPartType.getAirshipTypeFromString(airshipPartType)
                    .orElseThrow(() -> new Exception(airshipPartType + " not found"));

            switch (partType) {
                case CABIN:
                    JSONObject cabinElementsJson = (JSONObject) inputValues.get(airshipPartType);
                    Cabin cabin = partFactoryService.createCabin(cabinElementsJson);
                    airplaneBuilder.addCabin(cabin);
                    break;
                case PROPELLERS:
                    JSONArray propellerElementsJson = (JSONArray) inputValues.get(airshipPartType);
                    for (Object propellerElements : propellerElementsJson) {
                        Propeller propeller = partFactoryService.createPropeller((JSONObject) propellerElements);
                        airplaneBuilder.addPropellers(propeller);
                    }
                    break;
                case WINGS:
                    JSONArray wingElementsJson = (JSONArray) inputValues.get(airshipPartType);
                    for (Object wingElements : wingElementsJson) {
                        Wing wing = partFactoryService.createWing((JSONObject) wingElements);
                        airplaneBuilder.addWings(wing);
                    }
                    break;
                case FUEL_TYPE:
                    String fuelTypeString = (String) inputValues.get(airshipPartType);
                    FuelType fuelType = FuelType.getFuelTypeFromText(fuelTypeString)
                            .orElseThrow(() -> new Exception(fuelTypeString + " not found"));
                    airplaneBuilder.withFuelType(fuelType);
                    break;
                case FUEL_CAPACITY:
                    Long fuelCapacity = (Long) inputValues.get(airshipPartType);
                    airplaneBuilder.withFuelCapacity(fuelCapacity.intValue());
                    break;
                case AIRSHIP_CATEGORY:
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

    private Airship createDrone(JSONObject inputValues) throws Exception {
        Drone.DroneBuilder droneBuilder = Drone.DroneBuilder.newInstance();

        Set airshipParts = inputValues.keySet();
        for (Object airshipPart : airshipParts) {
            String airshipPartType = (String) airshipPart;
            AirshipPartType partType = AirshipPartType.getAirshipTypeFromString(airshipPartType)
                    .orElseThrow(() -> new Exception(airshipPartType + " not found"));

            switch (partType) {
                case WINGS:
                    JSONArray wingElementsJson = (JSONArray) inputValues.get(airshipPartType);
                    for (Object wingElements : wingElementsJson) {
                        Wing wing = partFactoryService.createWing((JSONObject) wingElements);
                        droneBuilder.addWing(wing);
                    }
                    break;
                case PROPELLERS:
                    JSONArray propellerElementsJson = (JSONArray) inputValues.get(airshipPartType);
                    for (Object propellerElements : propellerElementsJson) {
                        Propeller propeller = partFactoryService.createPropeller((JSONObject) propellerElements);
                        droneBuilder.addPropeller(propeller);
                    }
                    break;
                case ROCKET:
                    JSONArray rocketElementsJson = (JSONArray) inputValues.get(airshipPartType);
                    for (Object rocketElements : rocketElementsJson) {
                        Rocket rocket = partFactoryService.createRocket((JSONObject) rocketElements);
                        droneBuilder.addRocket(rocket);
                    }
                    break;
                case FUEL_TYPE:
                    String fuelTypeString = (String) inputValues.get(airshipPartType);
                    FuelType fuelType = FuelType.getFuelTypeFromText(fuelTypeString)
                            .orElseThrow(() -> new Exception(fuelTypeString + " not found"));
                    droneBuilder.withFuelType(fuelType);
                    break;
                case FUEL_CAPACITY:
                    Long fuelCapacity = (Long) inputValues.get(airshipPartType);
                    droneBuilder.withFuelCapacity(fuelCapacity.intValue());
                    break;
                case AIRSHIP_CATEGORY:
                    String categoryTypeString = (String) inputValues.get(airshipPartType);
                    AirshipCategoryType airshipCategoryType = AirshipCategoryType.getAirshipCategoryTypeFromText(categoryTypeString)
                            .orElseThrow(() -> new Exception(categoryTypeString + " not found"));
                    droneBuilder.withCategory(airshipCategoryType);
                default:
                    break;
            }
        }

        return droneBuilder.build();
    }

    private Airship createHelicopter(JSONObject inputValues) throws Exception {
        Helicopter.HelicopterBuilder helicopterBuilder = Helicopter.HelicopterBuilder.newInstance();

        Set airshipParts = inputValues.keySet();
        for (Object airshipPart : airshipParts) {
            String airshipPartType = (String) airshipPart;
            AirshipPartType partType = AirshipPartType.getAirshipTypeFromString(airshipPartType)
                    .orElseThrow(() -> new Exception(airshipPartType + " not found"));

            switch (partType) {
                case PROPELLERS:
                    JSONArray propellerElementsJson = (JSONArray) inputValues.get(airshipPartType);
                    for (Object propellerElements : propellerElementsJson) {
                        Propeller propeller = partFactoryService.createPropeller((JSONObject) propellerElements);
                        helicopterBuilder.addPropeller(propeller);
                    }
                    break;
                case CABIN:
                    JSONObject cabinElementsJson = (JSONObject) inputValues.get(airshipPartType);
                    Cabin cabin = partFactoryService.createCabin(cabinElementsJson);
                    helicopterBuilder.addCabin(cabin);
                    break;
                case FUEL_TYPE:
                    String fuelTypeString = (String) inputValues.get(airshipPartType);
                    FuelType fuelType = FuelType.getFuelTypeFromText(fuelTypeString)
                            .orElseThrow(() -> new Exception(fuelTypeString + " not found"));
                    helicopterBuilder.withFuelType(fuelType);
                    break;
                case FUEL_CAPACITY:
                    Long fuelCapacity = (Long) inputValues.get(airshipPartType);
                    helicopterBuilder.withFuelCapacity(fuelCapacity.intValue());
                    break;
                case AIRSHIP_CATEGORY:
                    String categoryTypeString = (String) inputValues.get(airshipPartType);
                    AirshipCategoryType airshipCategoryType = AirshipCategoryType.getAirshipCategoryTypeFromText(categoryTypeString)
                            .orElseThrow(() -> new Exception(categoryTypeString + " not found"));
                    helicopterBuilder.withCategory(airshipCategoryType);
                default:
                    break;
            }
        }

        return helicopterBuilder.build();
    }

    private Airship createJet(JSONObject inputValues) throws Exception {
        Jet.JetBuilder jetBuilder = Jet.JetBuilder.newInstance();

        Set airshipParts = inputValues.keySet();
        for (Object airshipPart : airshipParts) {
            String airshipPartType = (String) airshipPart;
            AirshipPartType partType = AirshipPartType.getAirshipTypeFromString(airshipPartType)
                    .orElseThrow(() -> new Exception(airshipPartType + " not found"));

            switch (partType) {
                case WINGS:
                    JSONArray wingElementsJson = (JSONArray) inputValues.get(airshipPartType);
                    for (Object wingElements : wingElementsJson) {
                        Wing wing = partFactoryService.createWing((JSONObject) wingElements);
                        jetBuilder.addWings(wing);
                    }
                    break;
                case CABIN:
                    JSONObject cabinElementsJson = (JSONObject) inputValues.get(airshipPartType);
                    Cabin cabin = partFactoryService.createCabin(cabinElementsJson);
                    jetBuilder.addCabin(cabin);
                    break;
                case ROCKET:
                    JSONArray rocketElementsJson = (JSONArray) inputValues.get(airshipPartType);
                    for (Object rocketElements : rocketElementsJson) {
                        Rocket rocket = partFactoryService.createRocket((JSONObject) rocketElements);
                        jetBuilder.addRockets(rocket);
                    }
                    break;
                case FUEL_TYPE:
                    String fuelTypeString = (String) inputValues.get(airshipPartType);
                    FuelType fuelType = FuelType.getFuelTypeFromText(fuelTypeString)
                            .orElseThrow(() -> new Exception(fuelTypeString + " not found"));
                    jetBuilder.withFuelType(fuelType);
                    break;
                case FUEL_CAPACITY:
                    Long fuelCapacity = (Long) inputValues.get(airshipPartType);
                    jetBuilder.withFuelCapacity(fuelCapacity.intValue());
                    break;
                case AIRSHIP_CATEGORY:
                    String categoryTypeString = (String) inputValues.get(airshipPartType);
                    AirshipCategoryType airshipCategoryType = AirshipCategoryType.getAirshipCategoryTypeFromText(categoryTypeString)
                            .orElseThrow(() -> new Exception(categoryTypeString + " not found"));
                    jetBuilder.withCategory(airshipCategoryType);
                default:
                    break;
            }
        }

        return jetBuilder.build();
    }

    private Airship createSpaceRocket(JSONObject inputValues) throws Exception {
        SpaceRocket.SpaceRocketBuilder spaceRocketBuilder = SpaceRocket.SpaceRocketBuilder.newInstance();

        Set airshipParts = inputValues.keySet();
        for (Object airshipPart : airshipParts) {
            String airshipPartType = (String) airshipPart;
            AirshipPartType partType = AirshipPartType.getAirshipTypeFromString(airshipPartType)
                    .orElseThrow(() -> new Exception(airshipPartType + " not found"));

            switch (partType) {
                case ROCKET:
                    JSONArray rocketElementsJson = (JSONArray) inputValues.get(airshipPartType);
                    for (Object rocketElements : rocketElementsJson) {
                        Rocket rocket = partFactoryService.createRocket((JSONObject) rocketElements);
                        spaceRocketBuilder.addRockets(rocket);
                    }
                    break;
                case CABIN:
                    JSONObject cabinElementsJson = (JSONObject) inputValues.get(airshipPartType);
                    Cabin cabin = partFactoryService.createCabin(cabinElementsJson);
                    spaceRocketBuilder.addCabin(cabin);
                    break;
                case FUEL_TYPE:
                    String fuelTypeString = (String) inputValues.get(airshipPartType);
                    FuelType fuelType = FuelType.getFuelTypeFromText(fuelTypeString)
                            .orElseThrow(() -> new Exception(fuelTypeString + " not found"));
                    spaceRocketBuilder.withFuelType(fuelType);
                    break;
                case FUEL_CAPACITY:
                    Long fuelCapacity = (Long) inputValues.get(airshipPartType);
                    spaceRocketBuilder.withFuelCapacity(fuelCapacity.intValue());
                    break;
                case AIRSHIP_CATEGORY:
                    String categoryTypeString = (String) inputValues.get(airshipPartType);
                    AirshipCategoryType airshipCategoryType = AirshipCategoryType.getAirshipCategoryTypeFromText(categoryTypeString)
                            .orElseThrow(() -> new Exception(categoryTypeString + " not found"));
                    spaceRocketBuilder.withCategory(airshipCategoryType);
                default:
                    break;
            }
        }

        return spaceRocketBuilder.build();
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
