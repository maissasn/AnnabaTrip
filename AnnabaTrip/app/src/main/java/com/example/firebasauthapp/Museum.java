package com.example.firebasauthapp;

public class Museum {
    private String name;
    private String description;
    private String mapLink;
    private int imageResId;

    public Museum(String name, String description, String mapLink, int imageResId) {
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

    public int getImageResource() {
        return imageResId;
    }
}
