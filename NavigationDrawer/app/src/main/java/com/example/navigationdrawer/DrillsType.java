package com.example.navigationdrawer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class DrillsType extends Activity {
    Button buttonSteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergency_drills_type);

        GridView gridViewDrills = findViewById(R.id.gridViewDrillsTypes);
        List<DrillsItem> drillsList = generateDrillsList();
        buttonSteps=findViewById(R.id.buttonSteps);
        buttonSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DrillsType.this,DrillSteps.class);
                startActivity(intent);
            }
        });

        DrillsAdapter adapter = new DrillsAdapter(DrillsType.this, drillsList);
        gridViewDrills.setAdapter(adapter);
    }

    private List<DrillsItem> generateDrillsList() {
        List<DrillsItem> drillsList = new ArrayList<>();
        drillsList.add(new DrillsItem("Fire Drills", "Practice evacuations in case of a fire, including the use of fire alarms, exit routes, and assembly points."));
        drillsList.add(new DrillsItem("Earthquake Drills", "Simulations of earthquake scenarios, including \"Drop, Cover, and Hold On\" techniques and evacuation procedures."));
        drillsList.add(new DrillsItem("Lockdown Drills", "Preparation for situations involving active shooters or other threats, focusing on securing rooms and maintaining safety."));
        drillsList.add(new DrillsItem("Tornado Drills", "Procedures for seeking shelter during a tornado, often involving moving to designated safe areas."));
        drillsList.add(new DrillsItem("Medical Emergency Drills", "Simulations of medical emergencies, including first aid response and the use of medical equipment."));
        drillsList.add(new DrillsItem("Evacuation Drills", " General drills for evacuating buildings or areas, applicable to various types of emergencies."));

        return drillsList;
    }


}
