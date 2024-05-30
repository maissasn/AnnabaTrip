package com.example.firebasauthapp;

public class Hotel {
    private String name;
    private String description;
    private String mapLink;
    private int imageResId; // Resource ID for the image

    public Hotel(String name, String description, String mapLink, int imageResId) {
        this.name = name;
        this.description = description;
        this.mapLink = mapLink;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getMapLink() {
        return mapLink;
    }

    public int getImageResId() {
        return imageResId;
    }

    // This method was missing an implementation
    public int getImageResource() {
        return imageResId;
    }
}
