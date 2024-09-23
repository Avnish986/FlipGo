package com.flipkart.context;

import com.flipkart.dto.Ride;
import com.flipkart.strategies.RideSearchStrategy;

import java.util.List;

public class RideSearchContext {
    private RideSearchStrategy strategy;

    public RideSearchContext(RideSearchStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Ride> executeSearch(List<Ride> rides, String startLocation, String endLocation) {
        return strategy.search(rides, startLocation, endLocation);
    }
}
