package com.example.recipeapp.helperclass;

public class Background {
    private String cuisine;
    private int backgroundImage;

    public Background(String cuisine, int backgroundImage) {
        this.cuisine = cuisine;
        this.backgroundImage = backgroundImage;
    }

    public String getCuisine() {
        return cuisine;
    }

    public int getBackgroundImage() {
        return backgroundImage;
    }
}
