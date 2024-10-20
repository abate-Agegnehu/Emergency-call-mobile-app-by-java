package com.example.navigationdrawer;

import java.util.Arrays;
import java.util.List;

public class ResourceItem {
    private int imageResource;
    private String type;
    private String description;
    private List<String> steps;

    public ResourceItem(int imageResource, String type, String description, List<String> steps) {
        this.imageResource = imageResource;
        this.type = type;
        this.description = description;
        this.steps = steps;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getSteps() {
        return steps;
    }
}
