package com.example.navigationdrawer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Contact#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Contact extends Fragment implements AdapterView.OnItemClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    GridView grid;
    String[] data;
    EmergencyTypeAdapter emergencyTypeAdapter;

    public Contact() {
    }

    public static Contact newInstance(String param1, String param2) {
        Contact fragment = new Contact();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.emergency_contact, container, false);

        data = getResources().getStringArray(R.array.emergency);
        emergencyTypeAdapter = new EmergencyTypeAdapter(getContext(), data);
        grid = view.findViewById(R.id.emergency_type_contact);
        grid.setAdapter(emergencyTypeAdapter);
        grid.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       if(position==0){
           Intent intentObject = new Intent(getActivity(), Medical.class);
           startActivity(intentObject);
       }
        if(position==1){
            Intent intentObject = new Intent(getActivity(), Natural.class);
            startActivity(intentObject);
        }
        if(position==2){
            Intent intentObject = new Intent(getActivity(), Fire.class);
            startActivity(intentObject);
        }
        if(position==3){
            Intent intentObject = new Intent(getActivity(), PublicSafety.class);
            startActivity(intentObject);
        }
        if(position==4){
            Intent intentObject = new Intent(getActivity(), Transportaion.class);
            startActivity(intentObject);
        }
    }
}
