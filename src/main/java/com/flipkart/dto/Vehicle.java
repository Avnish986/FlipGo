package com.flipkart.dto;

public class Vehicle {
    private String type;
    private int capacity;

    private boolean isAc;

    public Vehicle(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public Vehicle(String type, int capacity, boolean isAc) {
        this.type = type;
        this.capacity = capacity;
        this.isAc = isAc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAc() {
        return isAc;
    }

    public void setAc(boolean ac) {
        isAc = ac;
    }
}
