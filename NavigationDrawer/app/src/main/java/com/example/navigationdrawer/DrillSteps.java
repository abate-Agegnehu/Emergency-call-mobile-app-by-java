package com.example.navigationdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrillSteps extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drils_steps);
        GridView gridViewDrillSteps =findViewById(R.id.gridViewDrillsSteps);
        List<DrillStepsItem> drillsStepList = generateResourceList(); // Your method to generate resource data

        DrillStepsAdapter adapter = new DrillStepsAdapter(DrillSteps.this, drillsStepList);
        gridViewDrillSteps.setAdapter(adapter);

    }

    private List<DrillStepsItem> generateResourceList() {
        List<DrillStepsItem> drillsStepList = new ArrayList<>();
        // Add your emergency resource items here
        drillsStepList.add(new DrillStepsItem( "Plan the Drill",
                Arrays.asList("Define the objectives and scope of the drill.",
                        "Develop a realistic scenario.",
                        "Coordinate with relevant stakeholders (e.g., fire department, medical personnel)."
                    ),R.drawable.plan));



        drillsStepList.add(new DrillStepsItem("Prepare Participants",
                Arrays.asList("Inform participants about the drill and its purpose.",
                        "Provide training on emergency procedures."
                      ),R.drawable.participant));



        drillsStepList.add(new DrillStepsItem( "Conduct the Drill.",
                Arrays.asList("Execute the scenario as planned.",
                        "Monitor participant actions and adherence to protocols.",
                        "Ensure safety throughout the drill."
                        ),R.drawable.conduct));


        drillsStepList.add(new DrillStepsItem( "Evaluate the Drill",
                Arrays.asList(" Debrief participants to gather feedback.",
                        "Assess the effectiveness of the response and identify areas for improvement.",
                        "Document findings and update emergency plans as needed."
                     ),R.drawable.evaluate));



        drillsStepList.add(new DrillStepsItem( "Follow Up",
                Arrays.asList("Implement necessary changes based on the evaluation.",
                        "Schedule future drills to maintain preparedness."
                       ),R.drawable.followup));


        return drillsStepList;
    }
}
