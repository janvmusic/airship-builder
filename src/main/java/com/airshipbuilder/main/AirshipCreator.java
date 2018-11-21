package com.airshipbuilder.main;

import com.airshipbuilder.comparators.AirshipComparatorService;
import com.airshipbuilder.comparators.AirshipComparatorServiceImpl;
import com.airshipbuilder.model.airship.Airship;
import com.airshipbuilder.model.comparator.AirshipComparatorType;
import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.type.AirshipType;
import com.airshipbuilder.service.AirshipAbstractFactoryService;
import com.airshipbuilder.service.AirshipAbstractFactoryServiceImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        Map<AirshipType, Long> groupedByAirshipType = airships.stream() //
                .collect(Collectors.groupingBy(Airship::getAirshipType, Collectors.counting()));
        System.out.println("grouped by airship types: " + groupedByAirshipType);
        System.out.println("=================");

        Map<FuelType, Long> groupedByFuelType = airships.stream() //
                .collect(Collectors.groupingBy(Airship::getFuelType, Collectors.counting()));
        System.out.println("grouped by fuel types: " + groupedByFuelType);
        System.out.println("=================");

        List<Airship> groupedByHasWings = airships.stream() //
                .filter(airship -> !airship.getWings().isEmpty()) //
                .collect(Collectors.toList());
        System.out.println("grouped by has wings: " + groupedByHasWings.size());
        System.out.println("=================");

        List<Airship> groupedByHasRockets = airships.stream() //
                .filter(airship -> !airship.getRockets().isEmpty()) //
                .collect(Collectors.toList());
        System.out.println("grouped by has rockets: " + groupedByHasRockets.size());
        System.out.println("=================");

        List<Airship> groupedByHasCabin = airships.stream() //
                .filter(airship -> null != airship.getCabin()) //
                .collect(Collectors.toList());
        System.out.println("grouped by has cabin: " + groupedByHasCabin.size());
        System.out.println("=================");

        List<Airship> groupedByHasPropellers = airships.stream() //
                .filter(airship -> !airship.getPropellers().isEmpty()) //
                .collect(Collectors.toList());
        System.out.println("grouped by has propellers: " + groupedByHasPropellers.size());
        System.out.println("=================");

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
