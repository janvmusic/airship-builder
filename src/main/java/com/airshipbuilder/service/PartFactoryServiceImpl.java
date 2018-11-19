package com.airshipbuilder.service;

import com.airshipbuilder.model.materials.MaterialType;
import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Propeller;
import com.airshipbuilder.model.parts.Rocket;
import com.airshipbuilder.model.parts.Wing;
import org.json.simple.JSONObject;

public class PartFactoryServiceImpl implements PartFactoryService {

    @Override
    public Cabin createCabin(JSONObject cabinElementJson) throws Exception {
        Long weight = (Long) cabinElementJson.get("weight");
        String materialTypeText = (String) cabinElementJson.get("materialType");
        MaterialType materialType = MaterialType.getMaterialTypeFromText(materialTypeText)
                .orElseThrow(() -> new Exception(materialTypeText + " not found"));

        return new Cabin(weight.intValue(), materialType);
    }

    @Override
    public Propeller createPropeller(JSONObject propellerJson) throws Exception {
        Long weight = (Long) propellerJson.get("weight");
        String materialTypeText = (String) propellerJson.get("materialType");
        MaterialType materialType = MaterialType.getMaterialTypeFromText(materialTypeText)
                .orElseThrow(() -> new Exception(materialTypeText + " not found"));

        return new Propeller(weight.intValue(), materialType);
    }

    @Override
    public Rocket createRocket(JSONObject rocketJson) throws Exception {
        Long weight = (Long) rocketJson.get("weight");
        String materialTypeText = (String) rocketJson.get("materialType");
        MaterialType materialType = MaterialType.getMaterialTypeFromText(materialTypeText)
                .orElseThrow(() -> new Exception(materialTypeText + " not found"));

        return new Rocket(weight.intValue(), materialType);
    }

    @Override
    public Wing createWing(JSONObject wingsJson) throws Exception {
        Long weight = (Long) wingsJson.get("weight");
        String materialTypeText = (String) wingsJson.get("materialType");
        MaterialType materialType = MaterialType.getMaterialTypeFromText(materialTypeText)
                .orElseThrow(() -> new Exception(materialTypeText + " not found"));

        return new Wing(weight.intValue(), materialType);
    }
}
