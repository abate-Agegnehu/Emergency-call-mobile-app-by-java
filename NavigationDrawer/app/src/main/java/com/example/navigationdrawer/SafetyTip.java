package com.example.navigationdrawer;

public class SafetyTip {
    private String title;
    private String description;
private int image;
    public SafetyTip(String title, String description,int image) {
        this.title = title;
        this.description = description;
        this.image=image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    public int getImage() {
        return image;
    }

}
