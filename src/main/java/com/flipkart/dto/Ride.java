package com.flipkart.dto;

import com.flipkart.exception.SeatAvailabilityException;

import java.time.LocalDateTime;

public class Ride {

    private User driver;
    private Vehicle vehicle;
    private String workPlace;
    private String startLocation;
    private String endLocation;
    private LocalDateTime startTime;
    private int costPerSeat;
    private int availableSeats;

    public Ride(User driver, Vehicle vehicle, String workPlace, String startLocation, String endLocation, LocalDateTime startTime, int costPerSeat, int availableSeats) {
        this.driver = driver;
        this.vehicle = vehicle;
        this.workPlace = workPlace;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startTime = startTime;
        this.costPerSeat = costPerSeat;
        this.availableSeats = availableSeats;
    }

    public Ride(User driver, Vehicle vehicle, String workPlace, String startLocation, String endLocation, LocalDateTime startTime, int costPerSeat) {
        this.driver = driver;
        this.vehicle = vehicle;
        this.workPlace = workPlace;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startTime = startTime;
        this.costPerSeat = costPerSeat;
        this.availableSeats = vehicle.getCapacity();
    }

    public boolean hasAvailableSeats() {
        return availableSeats > 0;
    }

    public void bookSeat() {
        if(availableSeats < 0) {
            throw new SeatAvailabilityException("No seats left");
        } else {
            availableSeats--;
        }
    }

    public String getRideDetails() {
        return String.format("%s -> %s, Driver: %s, Vehicle: %s, Start Time: %s, Cost Per Seat: %d, Available Seats: %d",
                startLocation, endLocation, driver.getName(), vehicle.getType(), startTime, costPerSeat, availableSeats);
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }


    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getCostPerSeat() {
        return costPerSeat;
    }

    public void setCostPerSeat(int costPerSeat) {
        this.costPerSeat = costPerSeat;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }
}
