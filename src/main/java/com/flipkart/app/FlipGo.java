package com.flipkart.app;

import com.flipkart.dto.Ride;
import com.flipkart.dto.User;
import com.flipkart.dto.Vehicle;
import com.flipkart.exception.SeatAvailabilityException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FlipGo {
    private List<Ride> rides;

    public FlipGo() {
        this.rides = new ArrayList<>();
    }

    //Register Ride
    public void registerRide(User driver, Vehicle vehicle, String workPlace, String startLocation, String endLocation, String startTime, int costPerSeat, int availableSeats) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime parsedTime = LocalTime.parse(startTime, timeFormatter);
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), parsedTime);
        rides.add(new Ride(driver, vehicle, workPlace, startLocation, endLocation, dateTime, costPerSeat, availableSeats));
        System.out.println(driver.getName() + " " +startLocation + " -> " + endLocation + " registered");
    }

    //Search Rides
    public void searchRides(String startLocation, String endLocation){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneHourLater = now.plusHours(1);

        List<Ride> availableRides = rides.stream().filter(ride ->ride.getStartLocation().equals(startLocation)
                && ride.getEndLocation().equals(endLocation) && ride.hasAvailableSeats() && ride.getStartTime().isAfter(now) && ride.getStartTime().isBefore(oneHourLater))
                .sorted(Comparator.comparingInt(Ride::getCostPerSeat)).toList();

        if(availableRides.isEmpty()) {
            System.out.println("No available rides");
        } else {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime parsedTime = LocalTime.parse(now.format(timeFormatter), timeFormatter);
            System.out.println("Rides available ( searched at " + parsedTime + ")");
            availableRides.forEach(ride -> System.out.println(ride.getRideDetails()));
        }
        /*
        for (Ride ride : rides) {
            if (ride.getStartLocation().equals(startLocation) && ride.getEndLocation().equals(endLocation)) {
                System.out.println(ride.getRideDetails());
            }
        }

         */
    }

    public void searchRidesBasedOnType(String startLocation, String endLocation, String type){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneHourLater = now.plusHours(1);

        List<Ride> availableRides = rides.stream().filter(ride ->ride.getStartLocation().equals(startLocation)
                        && ride.getEndLocation().equals(endLocation) && ride.getVehicle().getType().equals(type) && ride.hasAvailableSeats() && ride.getStartTime().isAfter(now) && ride.getStartTime().isBefore(oneHourLater))
                .sorted(Comparator.comparingInt(Ride::getCostPerSeat)).toList();

        if(availableRides.isEmpty()) {
            System.out.println("No available rides");
        } else {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime parsedTime = LocalTime.parse(now.format(timeFormatter), timeFormatter);
            System.out.println("Rides available ( searched at " + parsedTime + ")");
            availableRides.forEach(ride -> System.out.println(ride.getRideDetails()));
        }
        /*
        for (Ride ride : rides) {
            if (ride.getStartLocation().equals(startLocation) && ride.getEndLocation().equals(endLocation)) {
                System.out.println(ride.getRideDetails());
            }
        }

         */
    }

    //Book a ride
    public void bookRide(String startLocation, String endLocation, String driverName){
        try {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime oneHourLater = now.plusHours(1);
            for (Ride ride : rides) {
                if(ride.getDriver().getName().equals(driverName) && ride.getStartLocation().equals(startLocation) && ride.getEndLocation().equals(endLocation) && ride.getStartTime().isAfter(now) && ride.getStartTime().isBefore(oneHourLater)) {
                    if(ride.hasAvailableSeats()) {
                        ride.bookSeat();
                        System.out.println("Seat Booked in " +ride.getDriver().getName() + "'s " + ride.getStartLocation() + " -> " + ride.getEndLocation() + ".Available Seats = " + ride.getAvailableSeats());
                        return;
                    }
                }
            }
            System.out.println("No available rides for " + driverName + " starting from " + startLocation + " to " + endLocation);
        } catch (SeatAvailabilityException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
