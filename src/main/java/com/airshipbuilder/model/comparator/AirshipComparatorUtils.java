package com.airshipbuilder.model.comparator;

import com.airshipbuilder.model.airship.Airship;

import java.util.Comparator;

public class AirshipComparatorUtils {

    public static final Comparator<Airship> FUEL_COMPARATOR = new Comparator<Airship>() {
        @Override
        public int compare(Airship airship1, Airship airship2) {
            return Integer.compare(airship1.getFuelCapacity(), airship2.getFuelCapacity());
        }
    };

    public static final Comparator<Airship> PRICE_COMPARATOR = new Comparator<Airship>() {
        @Override
        public int compare(Airship airship1, Airship airship2) {
            return Integer.compare(airship1.getTotalPrice(), airship2.getTotalPrice());
        }
    };

    public static final Comparator<Airship> WEIGHT_COMPARATOR = new Comparator<Airship>() {
        @Override
        public int compare(Airship airship1, Airship airship2) {
            return Integer.compare(airship1.getWeight(), airship2.getWeight());
        }
    };
}
