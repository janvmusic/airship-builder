package com.airshipbuilder.comparators;

import com.airshipbuilder.model.airship.Airship;
import com.airshipbuilder.model.comparator.AirshipComparatorUtils;
import com.airshipbuilder.model.comparator.AirshipComparatorType;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AirshipComparatorServiceImpl implements AirshipComparatorService {

    @Override
    public List<Airship> sort(AirshipComparatorType airshipComparatorType, List<Airship> airshipList) {
        switch (airshipComparatorType) {
            case RANK:
                return sortByRank(airshipList);
            case LOWEST_FUEL:
                return sortByFuel(airshipList, true);
            case HIGHEST_FUEL:
                return sortByFuel(airshipList, false);
            case LOWEST_PRICE:
                return sortByPrice(airshipList, true);
            case HIGHEST_PRICE:
                return sortByPrice(airshipList, false);
            case LOWEST_WEIGHT:
                return sortByWeight(airshipList, true);
            case HIGHEST_WEIGHT:
                return sortByWeight(airshipList, false);
            default:
                return airshipList;
        }
    }

    private List<Airship> sortByWeight(List<Airship> airshipList, boolean isLowest) {
        Comparator<Airship> comparator = isLowest ? //
                AirshipComparatorUtils.WEIGHT_COMPARATOR : //
                Collections.reverseOrder(AirshipComparatorUtils.WEIGHT_COMPARATOR);

        Collections.sort(airshipList, comparator);
        return Collections.unmodifiableList(airshipList);
    }

    private List<Airship> sortByPrice(List<Airship> airshipList, boolean isLowest) {
        Comparator<Airship> comparator = isLowest ? //
                AirshipComparatorUtils.PRICE_COMPARATOR : //
                Collections.reverseOrder(AirshipComparatorUtils.PRICE_COMPARATOR);

        Collections.sort(airshipList, comparator);
        return Collections.unmodifiableList(airshipList);
    }

    private List<Airship> sortByFuel(List<Airship> airshipList, boolean isLowest) {
        Comparator<Airship> comparator = isLowest ? //
                AirshipComparatorUtils.FUEL_COMPARATOR : //
                Collections.reverseOrder(AirshipComparatorUtils.FUEL_COMPARATOR);

        Collections.sort(airshipList, comparator);
        return Collections.unmodifiableList(airshipList);
    }

    private List<Airship> sortByRank(List<Airship> airshipList) {
        Collections.sort(airshipList);
        return Collections.unmodifiableList(airshipList);
    }
}
