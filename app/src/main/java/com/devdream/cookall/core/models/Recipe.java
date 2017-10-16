package com.devdream.cookall.core.models;

public class Recipe {

    private String id;
    private String title;
    private String description;


    public Recipe(String _id, String _title, String _description) {
        id = _id;
        title = _title;
        description = _description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
