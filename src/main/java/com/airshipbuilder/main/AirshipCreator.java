package com.airshipbuilder.main;

import com.airshipbuilder.comparators.AirshipComparatorService;
import com.airshipbuilder.comparators.AirshipComparatorServiceImpl;
import com.airshipbuilder.model.airship.Airship;
import com.airshipbuilder.model.comparator.AirshipComparatorType;
import com.airshipbuilder.service.AirshipAbstractFactoryService;
import com.airshipbuilder.service.AirshipAbstractFactoryServiceImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AirshipCreator {
    public static void main(String[] args) throws Exception {
        AirshipAbstractFactoryService airshipAbstractFactoryService = new AirshipAbstractFactoryServiceImpl();
        JSONArray airshipsFromFile = airshipAbstractFactoryService.readAirshipsFromFile();
        AirshipComparatorService airshipComparatorService = new AirshipComparatorServiceImpl();

        List<Airship> airships = new ArrayList<>();
        for (Object airshipParts : airshipsFromFile) {
            JSONObject airshipJson = (JSONObject) airshipParts;
            Airship airship = airshipAbstractFactoryService.createAirship(airshipJson);
            airships.add(airship);
        }
        System.out.println("pre order: " + airships);
        System.out.println("=================");
        System.out.println("ordered by rank: " + airshipComparatorService.sort(AirshipComparatorType.RANK, airships));
        System.out.println("=================");
        System.out.println("ordered by highest fuel: " + airshipComparatorService.sort(AirshipComparatorType.HIGHEST_FUEL, airships));
        System.out.println("=================");
        System.out.println("ordered by lowest fuel: " + airshipComparatorService.sort(AirshipComparatorType.LOWEST_FUEL, airships));
        System.out.println("=================");
        System.out.println("ordered by highest price: " + airshipComparatorService.sort(AirshipComparatorType.HIGHEST_PRICE, airships));
        System.out.println("=================");
        System.out.println("ordered by lowest price: " + airshipComparatorService.sort(AirshipComparatorType.LOWEST_PRICE, airships));
        System.out.println("=================");
        System.out.println("ordered by highest weight: " + airshipComparatorService.sort(AirshipComparatorType.HIGHEST_WEIGHT, airships));
        System.out.println("=================");
        System.out.println("ordered by lowest weight: " + airshipComparatorService.sort(AirshipComparatorType.LOWEST_WEIGHT, airships));
    }
}
