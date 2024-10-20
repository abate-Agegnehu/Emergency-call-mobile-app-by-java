package com.example.navigationdrawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Safety extends Fragment {

    private RecyclerView recyclerViewSafetyTips;
    private SafetyTipAdapter safetyTipAdapter;
    private List<SafetyTip> safetyTipList;

    public Safety() {
        // Required empty public constructor
    }

    public static Safety newInstance(String param1, String param2) {
        Safety fragment = new Safety();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Handle parameters if necessary
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.emergency_safety, container, false);

        // Initialize RecyclerView
        recyclerViewSafetyTips = view.findViewById(R.id.recyclerViewSafetyTips);
        recyclerViewSafetyTips.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewSafetyTips.setHasFixedSize(true);

        // Initialize safety tips list and adapter
        safetyTipList = new ArrayList<>();
        safetyTipAdapter = new SafetyTipAdapter(safetyTipList);
        recyclerViewSafetyTips.setAdapter(safetyTipAdapter);

        // Add some sample safety tips
        addSampleSafetyTips();

        return view;
    }

    private void addSampleSafetyTips() {
        safetyTipList.add(new SafetyTip("Stay Calm", "In an emergency, it's important to stay calm and think clearly.",R.drawable.staycalm));
        safetyTipList.add(new SafetyTip("Call for Help", "Always call for help immediately if you encounter an emergency situation.",R.drawable.callforhelp));
        safetyTipList.add(new SafetyTip("Follow Instructions", "Follow the instructions given by emergency personnel or authorities.",R.drawable.followinstruction));
        safetyTipList.add(new SafetyTip("Know Your Exits", "Familiarize yourself with the emergency exits in any building you enter.",R.drawable.knowexit));
        safetyTipList.add(new SafetyTip("Have an Emergency Kit", "Keep an emergency kit with essential items such as first aid supplies, flashlight, and water.",R.drawable.emergencykit));
        safetyTipList.add(new SafetyTip("Stay Informed", "Stay updated with emergency alerts and news to be aware of potential risks.",R.drawable.stayinformed));
        safetyTipList.add(new SafetyTip("Practice Fire Safety", "Know how to use fire extinguishers and have an evacuation plan in case of fire.",R.drawable.safetypractic));
        safetyTipList.add(new SafetyTip("Be Aware of Surroundings", "Stay aware of your surroundings and potential hazards.",R.drawable.beawareofyoursurrounding));
        safetyTipList.add(new SafetyTip("Stay Connected", "Have a communication plan with family or friends in case of emergencies.",R.drawable.stayconnected));
        safetyTipList.add(new SafetyTip("Seek Shelter", "Know where to find shelter in case of severe weather or natural disasters.",R.drawable.seekshelter));
        safetyTipAdapter.notifyDataSetChanged();
    }

}
