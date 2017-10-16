package com.devdream.cookall.core.models;

public class Recipe {

    public final String id;
    public final String recipeName;
    public final String details;

    public Recipe(String id, String recipeName, String details) {
        this.id = id;
        this.recipeName = recipeName;
        this.details = details;
    }

    @Override
    public String toString() {
        return recipeName;
    }

}
