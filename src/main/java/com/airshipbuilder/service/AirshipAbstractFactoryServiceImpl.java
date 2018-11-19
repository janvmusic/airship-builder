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
        AirshipType airshipTypeFromString = AirshipType.getAirshipTypeFromString(airshipTypeFromFile);

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
            AirshipPartType partType = AirshipPartType.getAirshipTypeFromString(airshipPartType);

            switch (partType) {
                case CABIN:
                    Cabin cabin = createCabin(inputValues, airshipPartType);
                    airplaneBuilder.addCabin(cabin);
                    break;
                case PROPELLERS:
                    addPropellers(inputValues, airplaneBuilder, airshipPartType);
                    break;
                case WINGS:
                    addWings(inputValues, airplaneBuilder, airshipPartType);
                    break;
                case FUEL_TYPE:
                    FuelType fuelType = createFuelType(inputValues, airshipPartType);
                    airplaneBuilder.withFuelType(fuelType);
                    break;
                case FUEL_CAPACITY:
                    Long fuelCapacity = (Long) inputValues.get(airshipPartType);
                    airplaneBuilder.withFuelCapacity(fuelCapacity.intValue());
                    break;
                case AIRSHIP_CATEGORY:
                    AirshipCategoryType airshipCategoryType = getAirshipCategoryType(inputValues, airshipPartType);
                    airplaneBuilder.withCategory(airshipCategoryType);
                    break;
                case RANK:
                    Long rank = (Long) inputValues.get(airshipPartType);
                    airplaneBuilder.withRank(rank.intValue());
                    break;
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
            AirshipPartType partType = AirshipPartType.getAirshipTypeFromString(airshipPartType);

            switch (partType) {
                case PROPELLERS:
                    addPropellers(inputValues, droneBuilder, airshipPartType);
                    break;
                case ROCKET:
                    addRockets(inputValues, droneBuilder, airshipPartType);
                    break;
                case WINGS:
                    addWings(inputValues, droneBuilder, airshipPartType);
                    break;
                case FUEL_TYPE:
                    FuelType fuelType = createFuelType(inputValues, airshipPartType);
                    droneBuilder.withFuelType(fuelType);
                    break;
                case FUEL_CAPACITY:
                    Long fuelCapacity = (Long) inputValues.get(airshipPartType);
                    droneBuilder.withFuelCapacity(fuelCapacity.intValue());
                    break;
                case AIRSHIP_CATEGORY:
                    AirshipCategoryType airshipCategoryType = getAirshipCategoryType(inputValues, airshipPartType);
                    droneBuilder.withCategory(airshipCategoryType);
                    break;
                case RANK:
                    Long rank = (Long) inputValues.get(airshipPartType);
                    droneBuilder.withRank(rank.intValue());
                    break;
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
            AirshipPartType partType = AirshipPartType.getAirshipTypeFromString(airshipPartType);

            switch (partType) {
                case CABIN:
                    Cabin cabin = createCabin(inputValues, airshipPartType);
                    helicopterBuilder.addCabin(cabin);
                    break;
                case PROPELLERS:
                    addPropellers(inputValues, helicopterBuilder, airshipPartType);
                    break;
                case FUEL_TYPE:
                    FuelType fuelType = createFuelType(inputValues, airshipPartType);
                    helicopterBuilder.withFuelType(fuelType);
                    break;
                case FUEL_CAPACITY:
                    Long fuelCapacity = (Long) inputValues.get(airshipPartType);
                    helicopterBuilder.withFuelCapacity(fuelCapacity.intValue());
                    break;
                case AIRSHIP_CATEGORY:
                    AirshipCategoryType airshipCategoryType = getAirshipCategoryType(inputValues, airshipPartType);
                    helicopterBuilder.withCategory(airshipCategoryType);
                    break;
                case RANK:
                    Long rank = (Long) inputValues.get(airshipPartType);
                    helicopterBuilder.withRank(rank.intValue());
                    break;
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
            AirshipPartType partType = AirshipPartType.getAirshipTypeFromString(airshipPartType);


            switch (partType) {
                case CABIN:
                    Cabin cabin = createCabin(inputValues, airshipPartType);
                    jetBuilder.addCabin(cabin);
                    break;
                case ROCKET:
                    addRockets(inputValues, jetBuilder, airshipPartType);
                    break;
                case WINGS:
                    addWings(inputValues, jetBuilder, airshipPartType);
                    break;
                case FUEL_TYPE:
                    FuelType fuelType = createFuelType(inputValues, airshipPartType);
                    jetBuilder.withFuelType(fuelType);
                    break;
                case FUEL_CAPACITY:
                    Long fuelCapacity = (Long) inputValues.get(airshipPartType);
                    jetBuilder.withFuelCapacity(fuelCapacity.intValue());
                    break;
                case AIRSHIP_CATEGORY:
                    AirshipCategoryType airshipCategoryType = getAirshipCategoryType(inputValues, airshipPartType);
                    jetBuilder.withCategory(airshipCategoryType);
                    break;
                case RANK:
                    Long rank = (Long) inputValues.get(airshipPartType);
                    jetBuilder.withRank(rank.intValue());
                    break;
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
            AirshipPartType partType = AirshipPartType.getAirshipTypeFromString(airshipPartType);

            switch (partType) {
                case CABIN:
                    Cabin cabin = createCabin(inputValues, airshipPartType);
                    spaceRocketBuilder.addCabin(cabin);
                    break;
                case ROCKET:
                    addRockets(inputValues, spaceRocketBuilder, airshipPartType);
                    break;
                case FUEL_TYPE:
                    FuelType fuelType = createFuelType(inputValues, airshipPartType);
                    spaceRocketBuilder.withFuelType(fuelType);
                    break;
                case FUEL_CAPACITY:
                    Long fuelCapacity = (Long) inputValues.get(airshipPartType);
                    spaceRocketBuilder.withFuelCapacity(fuelCapacity.intValue());
                    break;
                case AIRSHIP_CATEGORY:
                    AirshipCategoryType airshipCategoryType = getAirshipCategoryType(inputValues, airshipPartType);
                    spaceRocketBuilder.withCategory(airshipCategoryType);
                    break;
                case RANK:
                    Long rank = (Long) inputValues.get(airshipPartType);
                    spaceRocketBuilder.withRank(rank.intValue());
                    break;
                default:
                    break;
            }
        }

        return spaceRocketBuilder.build();
    }

    private Cabin createCabin(JSONObject inputValues, String airshipPartType) throws Exception {
        JSONObject cabinElementsJson = (JSONObject) inputValues.get(airshipPartType);
        return partFactoryService.createCabin(cabinElementsJson);
    }

    private void addPropellers(JSONObject inputValues, AirshipBuilder airshipBuilder, String airshipPartType)
            throws Exception {
        JSONArray propellerElementsJson = (JSONArray) inputValues.get(airshipPartType);
        for (Object propellerElements : propellerElementsJson) {
            Propeller propeller = partFactoryService.createPropeller((JSONObject) propellerElements);
            airshipBuilder.addPropeller(propeller);
        }
    }

    private void addRockets(JSONObject inputValues, AirshipBuilder airshipBuilder, String airshipPartType)
            throws Exception {
        JSONArray rocketElementsJson = (JSONArray) inputValues.get(airshipPartType);
        for (Object rocketElements : rocketElementsJson) {
            Rocket rocket = partFactoryService.createRocket((JSONObject) rocketElements);
            airshipBuilder.addRocket(rocket);
        }
    }

    private void addWings(JSONObject inputValues, AirshipBuilder airshipBuilder, String airshipPartType)
            throws Exception {
        JSONArray wingElementsJson = (JSONArray) inputValues.get(airshipPartType);
        for (Object wingElements : wingElementsJson) {
            Wing wing = partFactoryService.createWing((JSONObject) wingElements);
            airshipBuilder.addWing(wing);
        }
    }

    private FuelType createFuelType(JSONObject inputValues, String airshipPartType) throws Exception {
        String fuelTypeString = (String) inputValues.get(airshipPartType);
        return FuelType.getFuelTypeFromText(fuelTypeString);
    }

    private AirshipCategoryType getAirshipCategoryType(JSONObject inputValues, String airshipPartType)
            throws Exception {
        String categoryTypeString = (String) inputValues.get(airshipPartType);
        return AirshipCategoryType.getAirshipCategoryTypeFromText(categoryTypeString);
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
