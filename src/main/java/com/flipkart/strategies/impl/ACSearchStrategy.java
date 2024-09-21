package com.flipkart.strategies.impl;

import com.flipkart.dto.Ride;
import com.flipkart.strategies.RideSearchStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class ACSearchStrategy implements RideSearchStrategy {

    private boolean acRequired;

    public ACSearchStrategy(boolean acRequired) {
        this.acRequired = acRequired;
    }

    @Override
    public List<Ride> search(List<Ride> rides, String startLocation, String endLocation) {
        return rides.stream()
                .filter(ride -> ride.getStartLocation().equals(startLocation)
                        && ride.getEndLocation().equals(endLocation)
                        && ride.getVehicle().isAc() == acRequired)
                .collect(Collectors.toList());
    }
}
