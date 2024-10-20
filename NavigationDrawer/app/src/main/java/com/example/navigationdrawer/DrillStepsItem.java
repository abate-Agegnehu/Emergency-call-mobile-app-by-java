package com.example.navigationdrawer;

import java.util.List;

public class DrillStepsItem {
    private String type;
    private List<String> steps;
    int image;

    public DrillStepsItem( String type, List<String> steps,int image) {
        this.type = type;
        this.steps = steps;
        this.image=image;
    }


    public String getType() {
        return type;
    }

    public List<String> getSteps() {
        return steps;
    }
    public int getImage() {
        return image;
    }

}
