package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Propeller;
import com.airshipbuilder.model.parts.Rocket;
import com.airshipbuilder.model.parts.Wing;
import com.airshipbuilder.model.type.AirshipCategoryType;
import com.airshipbuilder.model.type.AirshipType;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Airplane extends Airship {

    private List<Wing> _wings;
    private List<Propeller> _propellers;
    private Cabin _cabin;

    private Airplane(List<Wing> wings, List<Propeller> propellers, Cabin cabin, int _fuelCapacity,
                     FuelType _fuelType, AirshipCategoryType _airshipCategoryType, int rank) {
        super(_fuelType, _airshipCategoryType, _fuelCapacity, rank);
        _wings = wings;
        _propellers = propellers;
        _cabin = cabin;
    }

    @Override
    public Cabin getCabin() {
        return _cabin;
    }

    @Override
    public List<Propeller> getPropellers() {
        return _propellers;
    }

    @Override
    public List<Wing> getWings() {
        return _wings;
    }

    @Override
    public AirshipType getAirshipType() {
        return AirshipType.AIRPLANE;
    }

    @Override
    public int getTotalPrice() {
        int propellersTotalPrice = _propellers.stream().mapToInt(Propeller::getTotalPrice).sum();
        int wingsTotalPrice = _wings.stream().mapToInt(Wing::getTotalPrice).sum();

        return _cabin.getTotalPrice() + propellersTotalPrice + wingsTotalPrice;
    }

    @Override
    public int getWeight() {
        int propellerTotalWeight = _propellers.stream().mapToInt(Propeller::getPropellerWeight).sum();
        int wingsTotalWeight = _wings.stream().mapToInt(Wing::getWingWeight).sum();

        return _cabin.getCabinWeight() + propellerTotalWeight + wingsTotalWeight;
    }

    public static class AirplaneBuilder extends AirshipBuilder {
        private List<Wing> _wings = new ArrayList<>();
        private List<Propeller> _propellers = new ArrayList<>();
        private Cabin _cabin;

        private AirplaneBuilder() {

        }

        public static AirplaneBuilder newInstance() {
            return new AirplaneBuilder();
        }

        public AirplaneBuilder addCabin(Cabin cabin) {
            _cabin = cabin;
            return this;
        }

        @Override
        public AirplaneBuilder addPropeller(Propeller propeller) {
            _propellers.add(propeller);
            return this;
        }

        @Override
        public AirplaneBuilder addRocket(Rocket rocket) {
            System.out.println("Method not implemented: addRocket for airplane");
            return this;
        }

        @Override
        public AirplaneBuilder addWing(Wing wing) {
            _wings.add(wing);
            return this;
        }

        public Airplane build() {
            return new Airplane(_wings, _propellers, _cabin, getFuelCapacity(), getFuelType(), getAirshipCategoryType(),
                    getRank());
        }
    }

    @Override
    public String toString () {
        return new StringJoiner(", ", Airplane.class.getSimpleName() + "[", "]") //
                .add("rank=" + getRank()) //
                .add("airshipCategoryType=" + getAirshipType()) //
                .add("totalPrice=" + getTotalPrice()) //
                .add("weight=" + getWeight()) //
                .add("fuelType=" + getFuelType()) //
                .add("fuelCapacity=" + getFuelCapacity()) //
                .add("numberOfWings=" + _wings.size()) //
                .add("numberOfPropellers=" + _propellers.size()) //
                .add("cabin=" + _cabin) //
                .toString();
    }
}
