package com.devdream.cookall.core.entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Recipe extends RealmObject {

    @PrimaryKey
    private String id;
    private String title;
    private String description;

    public Recipe() {
    }

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
