//package com.example.navigationdrawer;
//
//import android.content.Intent;
//import android.os.Bundle;
//import androidx.fragment.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
///**
// * A simple {@link Fragment} subclass.
// * Use the {@link Notification#newInstance} factory method to
// * create an instance of this fragment.
// */
//public class Notification extends Fragment {
//
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    private String mParam1;
//    private String mParam2;
//    private TextView tv_emergency_type;
//    private TextView tv_emergency_details;
//
//    public Notification() {
//        // Required empty public constructor
//    }
//
//    public static Notification newInstance(String param1, String param2) {
//        Notification fragment = new Notification();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_notification, container, false);
//
//        // Initialize the views
//        tv_emergency_type = view.findViewById(R.id.tv_emergency_type);
//        tv_emergency_details = view.findViewById(R.id.tv_emergency_details);
//
//        // Get the intent that started this activity
//        Intent intent = getActivity().getIntent();
//        if (intent != null) {
//            String type = intent.getStringExtra("type");
//            String description = intent.getStringExtra("description");
//
//            // Set the text to the TextViews
//            tv_emergency_type.setText(type);
//            tv_emergency_details.setText(description);
//        }
//
//        return view;
//    }
//}
package com.example.navigationdrawer;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Notification#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Notification extends Fragment {

    private static final String ARG_TYPE = "type";
    private static final String ARG_DESCRIPTION = "description";

    private String mType;
    private String mDescription;
    private TextView tvEmergencyType;
    private TextView tvEmergencyDetails;

    public Notification() {
        // Required empty public constructor
    }

    public static Notification newInstance(String type, String description) {
        Notification fragment = new Notification();
        Bundle args = new Bundle();
        args.putString(ARG_TYPE, type);
        args.putString(ARG_DESCRIPTION, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mType = getArguments().getString(ARG_TYPE);
            mDescription = getArguments().getString(ARG_DESCRIPTION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        // Initialize the views
        tvEmergencyType = view.findViewById(R.id.tv_emergency_type);
        tvEmergencyDetails = view.findViewById(R.id.tv_emergency_details);

        // Set the text to the TextViews
        tvEmergencyType.setText(mType);
        tvEmergencyDetails.setText(mDescription);

        return view;
    }
}
