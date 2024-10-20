package com.example.navigationdrawer;

import android.Manifest;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class Request extends Fragment {

    private EditText nameEditText, phoneEditText, typeEditText, locationEditText, detailsEditText;
    private Button requestButton;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public Request() {
        // Required empty public constructor
    }

    public static Request newInstance(String param1, String param2) {
        Request fragment = new Request();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.emergency_request_assistance, container, false);

        nameEditText = view.findViewById(R.id.nameEditText);
        phoneEditText = view.findViewById(R.id.phoneEditText);
        typeEditText = view.findViewById(R.id.typeEditText);
        locationEditText = view.findViewById(R.id.locationEditText);
        detailsEditText = view.findViewById(R.id.editTextDetails);
        requestButton = view.findViewById(R.id.requestButton);

        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String phone = phoneEditText.getText().toString().trim();
                String type = typeEditText.getText().toString().trim();
                String location = locationEditText.getText().toString().trim();
                String details = detailsEditText.getText().toString().trim();

                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.SEND_SMS}, 1);
                } else {
                    // Permission already granted, send SMS
                    sendSms(name, phone, type, location, details);
                }

                new Handler().postDelayed(() -> makeSuccessDialog(), 2000);
            }
        });

        return view;
    }

    private void sendSms(String name, String phone, String type, String location, String details) {
        if (phone.isEmpty()) {
            Toast.makeText(getContext(), "Phone number cannot be empty!", Toast.LENGTH_SHORT).show();
            return;
        }

        String message = "Emergency Assistance Request\n\nName: " + name +
                "\nPhone: " + phone +
                "\nEmergency Type: " + type +
                "\nLocation: " + location +
                "\nDetails: " + details;

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone, null, message, null, null);
            Toast.makeText(getContext(), "Assistance request sent successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getContext(), "Failed to send assistance request. Please try again.", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Permission granted, proceed with sending SMS
            String name = nameEditText.getText().toString().trim();
            String phone = phoneEditText.getText().toString().trim();
            String type = typeEditText.getText().toString().trim();
            String location = locationEditText.getText().toString().trim();
            String details = detailsEditText.getText().toString().trim();
            sendSms(name, phone, type, location, details);
        } else {
            Toast.makeText(getContext(), "Permission denied to send SMS", Toast.LENGTH_SHORT).show();
        }
    }

    public void makeSuccessDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setView(LayoutInflater.from(getContext()).inflate(R.layout.emergency_alert, null))
                .create();
        alertDialog.show();
        if (alertDialog.getWindow() != null) alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        alertDialog.findViewById(R.id.successDone).setOnClickListener(v -> {
            alertDialog.dismiss();
            Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
        });
    }
}
