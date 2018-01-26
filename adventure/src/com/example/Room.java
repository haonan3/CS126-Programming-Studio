package com.example;

public class Room {
    private String name;
    private String description;
    private String[] items = new String[0];
    private Directions[] directions;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getItems() {
        return items;
    }

    public Directions[] getDirection() {
        return directions;
    }
}
