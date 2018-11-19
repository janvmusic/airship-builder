package com.airshipbuilder.model.airship;

import com.airshipbuilder.model.fuel.FuelType;
import com.airshipbuilder.model.parts.Cabin;
import com.airshipbuilder.model.parts.Propeller;
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

    public List<Propeller> getPropellers() {
        return _propellers;
    }

    public Cabin getCabin() {
        return _cabin;
    }

    @Override
    public int getTotalPrice() {
        return 0;
    }

    @Override
    public int getWeight() {
        return 0;
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

        public HelicopterBuilder addPropeller(Propeller propeller) {
            _propellers.add(propeller);
            return this;
        }

        public Helicopter build() {
            return new Helicopter(_propellers, _cabin, getFuelCapacity(), getFuelType(), getAirshipCategoryType());
        }
    }
}
