package com.airshipbuilder.main;

import com.airshipbuilder.model.airship.Airship;
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

        List<Airship> airships = new ArrayList<>();
        for (Object airshipParts : airshipsFromFile) {
            JSONObject airshipJson = (JSONObject) airshipParts;
            Airship airship = airshipAbstractFactoryService.createAirship(airshipJson);
            airships.add(airship);
        }
        System.out.println("Finished! Air total: " + airships.size());
    }
}
