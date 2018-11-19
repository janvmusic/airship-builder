package com.airshipbuilder.service;

import com.airshipbuilder.model.airship.Airship;
import com.airshipbuilder.model.type.AirshipType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface AirshipAbstractFactoryService {

    Airship createAirship(JSONObject airshipJson) throws Exception;

    JSONArray readAirshipsFromFile();
}
