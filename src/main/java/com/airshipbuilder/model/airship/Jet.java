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

public class Jet extends Airship {
    private List<Wing> _wings;
    private List<Rocket> _rockets;
    private Cabin _cabin;

    private Jet(List<Wing> wings, List<Rocket> rockets, Cabin cabin, int _fuelCapacity, FuelType _fuelType,
                AirshipCategoryType _airshipCategoryType, int rank) {
        super(_fuelType, _airshipCategoryType, _fuelCapacity, rank);
        _wings = wings;
        _rockets = rockets;
        _cabin = cabin;
    }

    @Override
    public Cabin getCabin() {
        return _cabin;
    }

    @Override
    public List<Rocket> getRockets() {
        return _rockets;
    }

    @Override
    public List<Wing> getWings() {
        return _wings;
    }

    @Override
    public AirshipType getAirshipType(){
        return AirshipType.JET;
    }

    @Override
    public int getTotalPrice() {
        int rocketsTotalPrice = _rockets.stream().mapToInt(Rocket::getTotalPrice).sum();
        int wingsTotalPrice = _wings.stream().mapToInt(Wing::getTotalPrice).sum();

        return _cabin.getTotalPrice() + rocketsTotalPrice + wingsTotalPrice;
    }

    @Override
    public int getWeight() {
        int rocketsTotalWeight = _rockets.stream().mapToInt(Rocket::getRocketWeight).sum();
        int wingsTotalWeight = _wings.stream().mapToInt(Wing::getWingWeight).sum();

        return _cabin.getCabinWeight() + rocketsTotalWeight + wingsTotalWeight;
    }

    public static class JetBuilder extends AirshipBuilder {
        private List<Wing> _wings = new ArrayList<>();
        private List<Rocket> _rockets = new ArrayList<>();
        private Cabin _cabin;

        private JetBuilder() {
        }

        public static JetBuilder newInstance() {
            return new JetBuilder();
        }

        public JetBuilder addCabin(Cabin cabin) {
            _cabin = cabin;
            return this;
        }

        @Override
        public JetBuilder addPropeller(Propeller propeller) {
            System.out.println("Method not implemented: addPropeller for jets");
            return this;
        }

        @Override
        public JetBuilder addRocket(Rocket rocket) {
            _rockets.add(rocket);
            return this;
        }

        @Override
        public JetBuilder addWing(Wing wing) {
            _wings.add(wing);
            return this;
        }

        public Jet build() {
            return new Jet(_wings, _rockets, _cabin, getFuelCapacity(), getFuelType(), getAirshipCategoryType(),
                    getRank());
        }
    }

    @Override
    public String toString () {
        return new StringJoiner(", ", Jet.class.getSimpleName() + "[", "]") //
                .add("rank=" + getRank()) //
                .add("airshipCategoryType=" + getAirshipType()) //
                .add("totalPrice=" + getTotalPrice()) //
                .add("weight=" + getWeight()) //
                .add("fuelType=" + getFuelType()) //
                .add("fuelCapacity=" + getFuelCapacity()) //
                .add("numberOfRockets=" + _rockets.size()) //
                .add("cabin=" + _cabin) //
                .toString();
    }
}
