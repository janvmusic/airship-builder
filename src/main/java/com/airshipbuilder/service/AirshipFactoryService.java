package com.airshipbuilder.service;

import com.airshipbuilder.model.airship.Airship;
import com.airshipbuilder.model.type.AirshipType;

public interface AirshipFactoryService {

    Airship createAirship(AirshipType airshipType, String inputValues);

}
