package com.airshipbuilder.comparators;

import com.airshipbuilder.model.airship.Airship;
import com.airshipbuilder.model.comparator.AirshipComparatorType;

import java.util.List;

public interface AirshipComparatorService {

    List<Airship> sort(AirshipComparatorType airshipComparatorType, List<Airship> airshipList);

}
