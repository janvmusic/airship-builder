package com.airshipbuilder.service;

import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Propeller;
import com.airshipbuilder.model.parts.Rocket;
import com.airshipbuilder.model.parts.Wing;
import org.json.simple.JSONObject;

interface PartFactoryService {
    Cabin createCabin(JSONObject propellerJson) throws Exception;

    Propeller createPropeller(JSONObject propellerJson) throws Exception;

    Rocket createRocket(JSONObject rocketJson) throws Exception;

    Wing createWing(JSONObject wingsJson) throws Exception;
}
