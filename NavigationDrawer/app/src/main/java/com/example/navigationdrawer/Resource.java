package com.example.navigationdrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Arrays; // Added import for Arrays
import java.util.List;

public class Resource extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public Resource() {
        // Required empty public constructor
    }

    public static Resource newInstance(String param1, String param2) {
        Resource fragment = new Resource();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.emergency_resource, container, false);

        GridView gridViewResources = view.findViewById(R.id.gridViewResources);
        List<ResourceItem> resourceList = generateResourceList(); // Your method to generate resource data

        ResourceAdapter adapter = new ResourceAdapter(getContext(), resourceList);
        gridViewResources.setAdapter(adapter);

        return view;
    }

    private List<ResourceItem> generateResourceList() {
        List<ResourceItem> resourceList = new ArrayList<>();
        // Add your emergency resource items here
        resourceList.add(new ResourceItem(R.drawable.medicalsupply, "Basic medical supplies", "A collection of supplies and equipment for use in giving first aid.",
                Arrays.asList("Identify the type of injury or medical emergency.",
                        "Open the first aid kit and locate the necessary supplies.",
                        "Clean and disinfect the wound area if needed.",
                        " Apply bandages or dressings to the wound.",
                        "Administer any necessary medications as instructed.")));



        resourceList.add(new ResourceItem(R.drawable.fireextingusher, " Fire Extinguisher.", "A device used to extinguish or control small fires in emergency situations.",
                Arrays.asList("Pull the pin or safety clip to unlock the fire extinguisher.",
                        "Aim the nozzle or hose at the base of the fire.",
                        "Squeeze the handle to release the extinguishing agent.",
                        "Sweep the nozzle or hose from side to side to cover the flames completely.",
                        " Monitor the area for re-ignition and evacuate if necessary.")));



        resourceList.add(new ResourceItem(R.drawable.emergencyblanket, "Emergency Blanket.", "A lightweight blanket designed to reduce heat loss in a person's body.",
                Arrays.asList("Remove the emergency blanket from its packaging.",
                        "Unfold the blanket and wrap it around the person, covering their entire body.",
                        "Ensure the person's head and neck are also covered for maximum heat retention.",
                        " Keep the person warm and dry until professional medical help arrives.")));


        resourceList.add(new ResourceItem(R.drawable.flashlight, "Flashlight", "A portable hand-held electric light.",
                Arrays.asList(" Turn on the flashlight using the power button or switch.",
                        "Point the beam of light in the desired direction.",
                        "Adjust the focus or brightness of the flashlight if necessary.",
                        "  Use the flashlight to navigate in low-light or dark conditions."
                     )));



        resourceList.add(new ResourceItem(R.drawable.whistle, "Whistle", "A small device that makes a loud sound when blown through, used to signal.",
                Arrays.asList("Position the whistle between your lips.",
                        "Take a deep breath.",
                        "Blow into the whistle with a sharp, steady breath.",
                        " Repeat blowing the whistle in short bursts to signal for help."
                       )));


        resourceList.add(new ResourceItem(R.drawable.waterpurification, "Water Purification Tablets", "Tablets used to kill harmful microorganisms in water, making it safe to drink.",
                Arrays.asList(" Fill a clean container with water from a questionable source.",
                        "Add the recommended number of water purification tablets to the container.",
                        "Stir the water to dissolve the tablets completely.",
                        " Wait for the specified time for the tablets to purify the water.",
                        "Filter the purified water if necessary before drinking.")));


        resourceList.add(new ResourceItem(R.drawable.multitool, "Multi-tool", " A hand tool that combines several individual functions in a single unit.",
                Arrays.asList("Identify the tool or function needed for the task.",
                        "Open the multi-tool to access the desired tool.",
                        "Use the tool as intended, such as cutting, screwing, or gripping.",
                        "Close the multi-tool and store it safely after use."
                       )));
        resourceList.add(new ResourceItem(R.drawable.cpr, "CPR Mask", "A device used to safely deliver rescue breaths during a cardiac arrest.",
                Arrays.asList("Ensure the person is lying on their back on a firm surface.",
                        "Tilt the person's head back slightly to open the airway.",
                        "Place the CPR mask over the person's mouth and nose, ensuring a tight seal.",
                        "Administer rescue breaths by blowing into the mask as instructed.",
                        "Continue CPR until medical help arrives.")));


        resourceList.add(new ResourceItem(R.drawable.reflective, "Reflective Vest", "A vest with reflective material to enhance visibility in low light conditions.",
                Arrays.asList("Put on the reflective vest over your clothing.",
                        "Ensure the reflective material is visible from all directions.",
                        "Adjust the straps for a comfortable and secure fit.",
                        "Use the reflective vest in low-light conditions or when visibility is limited.")));


        resourceList.add(new ResourceItem(R.drawable.foodsuply, "Emergency Food Supply", " Non-perishable food items that can provide nutrition in emergency situations.",
                Arrays.asList("Open the emergency food packaging.",
                        "Consume the food directly or prepare it according to the instructions.",
                        "Ensure adequate hydration when consuming emergency food.",
                        " Store any leftover food properly for future use."
                      )));
        return resourceList;
    }
}
