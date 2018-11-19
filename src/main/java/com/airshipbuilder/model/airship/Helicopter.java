package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Propeller;
import com.airshipbuilder.model.parts.Rocket;
import com.airshipbuilder.model.parts.Wing;
import com.airshipbuilder.model.type.AirshipCategoryType;

import java.util.ArrayList;
import java.util.List;

public class Helicopter extends Airship {

    private List<Propeller> _propellers;
    private Cabin _cabin;

    private Helicopter(List<Propeller> propellers, Cabin cabin, int _fuelCapacity, FuelType _fuelType, AirshipCategoryType _airshipCategoryType) {
        super(_fuelType, _airshipCategoryType, _fuelCapacity);
        _propellers = propellers;
        _cabin = cabin;
    }

    public Cabin getCabin() {
        return _cabin;
    }

    public List<Propeller> getPropellers() {
        return _propellers;
    }

    @Override
    public int getTotalPrice() {
        int propellersTotalPrice = _propellers.stream().mapToInt(Propeller::getTotalPrice).sum();
        return _cabin.getTotalPrice() + propellersTotalPrice;
    }

    @Override
    public int getWeight() {
        int propellersTotalWeight = _propellers.stream().mapToInt(Propeller::getPropellerWeight).sum();
        return _cabin.getCabinWeight() + propellersTotalWeight;
    }

    public static class HelicopterBuilder extends AirshipBuilder {
        private List<Propeller> _propellers = new ArrayList<>();
        private Cabin _cabin;

        private HelicopterBuilder() {
        }

        public static HelicopterBuilder newInstance() {
            return new HelicopterBuilder();
        }

        public HelicopterBuilder addCabin(Cabin cabin) {
            _cabin = cabin;
            return this;
        }

        @Override
        public HelicopterBuilder addPropeller(Propeller propeller) {
            _propellers.add(propeller);
            return this;
        }

        @Override
        public HelicopterBuilder addRocket(Rocket rocket) {
            System.out.println("Method not implemented: addRocket for helicopter");
            return this;
        }

        @Override
        public HelicopterBuilder addWing(Wing wing) {
            System.out.println("Method not implemented: addWing for helicopter");
            return this;
        }

        public Helicopter build() {
            return new Helicopter(_propellers, _cabin, getFuelCapacity(), getFuelType(), getAirshipCategoryType());
        }
    }
}
