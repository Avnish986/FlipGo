package com.flipkart;

import com.flipkart.app.FlipGo;
import com.flipkart.dto.Bike;
import com.flipkart.dto.Car;
import com.flipkart.dto.User;
import com.flipkart.dto.Vehicle;
import com.flipkart.strategies.impl.ACSearchStrategy;
import com.flipkart.strategies.impl.VehicleTypeSearchStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FlipGo app = new FlipGo();

        User driver1 = new User("Driver01", "Male");
        User driver2 = new User("Driver02", "Female");
        User driver3 = new User("Driver03", "Female");


        Vehicle vehicle1 = new Car();
        Vehicle vehicle2 = new Bike();
        Vehicle vehicle3 = new Car();

        app.registerRide(driver1, vehicle1, "Flipkart", "HSR", "Bellandur", "22:30", 500, 4);
        app.registerRide(driver3, vehicle3, "ABCompany", "Koramangala", "Bellandur", "12:30", 400, 4);
        app.registerRide(driver2, vehicle2, "Flipkart","HSR", "Bellandur", "12:36", 300, 1);

        app.searchRides("HSR", "Bellandur");
        app.searchRidesBasedOnType("HSR", "Bellandur", "Bike");
        app.searchRidesStrategyContext("HSR", "Bellandur", new VehicleTypeSearchStrategy("Car"));

        app.bookRide("HSR", "Bellandur", "Driver01");
    }
}