package com.example.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

public class Drills extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button buttonTypes;

    public Drills() {
        // Required empty public constructor
    }

    public static Drills newInstance(String param1, String param2) {
        Drills fragment = new Drills();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.emergency_drills, container, false);

        GridView gridViewDrills = view.findViewById(R.id.gridViewDrills);
        List<DrillsItem> drillsList = generateDrillsList();
        buttonTypes=view.findViewById(R.id.buttonTypes);
        buttonTypes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),DrillsType.class);
                startActivity(intent);
            }
        });

        DrillsAdapter adapter = new DrillsAdapter(getContext(), drillsList);
        gridViewDrills.setAdapter(adapter);

        return view;
    }

    private List<DrillsItem> generateDrillsList() {
        List<DrillsItem> drillsList = new ArrayList<>();
        drillsList.add(new DrillsItem("Improving Preparedness", "Drills help individuals and organizations be better prepared for emergencies by familiarizing them with procedures, routes, and safety protocols."));
        drillsList.add(new DrillsItem("Enhancing Response Time", "Practicing emergency scenarios can help reduce the time it takes for individuals to respond, leading to quicker and more efficient evacuation or other necessary actions."));
        drillsList.add(new DrillsItem("Identifying Weaknesses", "Drills can reveal weaknesses in emergency plans, communication systems, and infrastructure, allowing organizations to make improvements."));
        drillsList.add(new DrillsItem("Building Confidence", "Regular practice can build confidence among participants, reducing panic and confusion during actual emergencies."));
        drillsList.add(new DrillsItem("Ensuring Compliance", "Many organizations are required by law or regulation to conduct regular emergency drills to comply with safety standards."));

        return drillsList;
    }
}
