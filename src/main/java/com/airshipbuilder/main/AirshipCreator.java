package com.airshipbuilder.main;

import com.airshipbuilder.service.AirshipAbstractFactoryService;
import com.airshipbuilder.service.AirshipAbstractFactoryServiceImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AirshipCreator {
    public static void main(String[] args) throws Exception {
        AirshipAbstractFactoryService airshipAbstractFactoryService = new AirshipAbstractFactoryServiceImpl();
        JSONArray airshipsFromFile = airshipAbstractFactoryService.readAirshipsFromFile();

        for (Object airship : airshipsFromFile) {
            JSONObject airshipJson = (JSONObject) airship;
            airshipAbstractFactoryService.createAirship(airshipJson);
        }

    }
}
