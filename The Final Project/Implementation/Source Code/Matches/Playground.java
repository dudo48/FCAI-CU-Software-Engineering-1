package Matches;

import AbstractObjects.IDGenerator;
import Actor.PlaygroundOwner;

import java.util.Arrays;

/**
 * A class for a playground. Which players book and playground owners own.
 */

public class Playground {
    private String name;
    private int ID;
    private String location;
    private boolean isActive;
    private boolean natural_grass;
    private boolean[] work_days;
    private boolean[] work_hours;
    private double cost_per_hour;
    private int length;
    private int width;
    private PlaygroundOwner owner;

    public Playground(String name, String location, boolean natural_grass, boolean[] work_days, boolean[] work_hours, double cost_per_hour, int length, int width, PlaygroundOwner owner) {
        this.name = name;
        this.location = location;
        this.natural_grass = natural_grass;
        this.work_days = work_days;
        this.work_hours = work_hours;
        this.cost_per_hour = cost_per_hour;
        this.length = length;
        this.width = width;
        this.isActive = false;
        this.owner = owner;
        this.ID = IDGenerator.Playground();
    }

    public int getID() {
        return ID;
    }

    public double getCost_per_hour() {
        return cost_per_hour;
    }

    public PlaygroundOwner getOwner() {
        return owner;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Playground Details\n" +
                "\nName: " + name +
                "\nID: " + ID +
                "\nLocation: " + location +
                "\nActivated: " + isActive +
                "\nNatural Grass: " + natural_grass +
                "\nOpening Days(if first element day is Saturday): " + Arrays.toString(work_days) +
                "\nOpening hours(if first hour is 12 AM): " + Arrays.toString(work_hours) +
                "\nHourly Cost: " + cost_per_hour +
                "\nDimensions(in metres): " + length + "x" + width;
    }
}
