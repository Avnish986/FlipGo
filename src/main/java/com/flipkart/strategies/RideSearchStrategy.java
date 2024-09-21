package com.flipkart.strategies;

import com.flipkart.dto.Ride;

import java.util.List;

public interface RideSearchStrategy {

    List<Ride> search(List<Ride> rides, String startLocation, String endLocation);

}
