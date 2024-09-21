package com.flipkart.strategies.impl;

import com.flipkart.dto.Ride;
import com.flipkart.strategies.RideSearchStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleTypeSearchStrategy implements RideSearchStrategy {

    private String vehicleType;

    public VehicleTypeSearchStrategy(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public List<Ride> search(List<Ride> rides, String startLocation, String endLocation) {
        return rides.stream()
                .filter(ride -> ride.getStartLocation().equals(startLocation)
                        && ride.getEndLocation().equals(endLocation)
                        && ride.getVehicle().getType().equalsIgnoreCase(vehicleType))
                .collect(Collectors.toList());
    }
}
