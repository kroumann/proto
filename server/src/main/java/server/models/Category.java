package server.models;

import java.util.*;


public class Category {

    private String name;
    private String description;
    private String imageurl;

    protected  Category() {}

    public Category(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageurl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageurl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageurl = imageUrl;
    }
}
