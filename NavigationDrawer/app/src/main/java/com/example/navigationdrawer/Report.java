package com.example.navigationdrawer;
import android.os.Handler;
import android.os.Looper;
import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

public class Report extends Fragment {

    private EditText editTextName, editTextPhone, editTextEmergencyType, editTextDetails;
    private Button buttonSubmit;

    public Report() {
        // Required empty public constructor
    }

    public static Report newInstance(String param1, String param2) {
        Report fragment = new Report();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
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
        View view = inflater.inflate(R.layout.emergency_report, container, false);

        // Initialize the views
        editTextName = view.findViewById(R.id.editTextName);
        editTextPhone = view.findViewById(R.id.editTextPhone);
        editTextEmergencyType = view.findViewById(R.id.editTextEmergencyType);
        editTextDetails = view.findViewById(R.id.editTextDetails);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }

        // Set up the submit button click listener
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String phone = editTextPhone.getText().toString();
                String type = editTextEmergencyType.getText().toString();
                String details = editTextDetails.getText().toString();

                // Here you can handle the form submission, for example:
                if (name.isEmpty() || phone.isEmpty() || type.isEmpty() || details.isEmpty()) {
                    showSnackbar(view, "Please fill out all fields");
                } else {
                    // Submit the report (e.g., send to server or save locally)
                    showSnackbar(view, "Report submitted");
                }
                makeNotification();
            }
        });

        return view;
    }
    public void makeNotification() {
        String channelID = "CHANNEL_ID_NOTIFICATION";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), channelID)
                .setSmallIcon(R.drawable.nav_notification)
                .setContentTitle("Report Notification")
                .setContentText("Emergency notification message. Stay safe!")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Intent intent = new Intent(getContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("type", editTextEmergencyType.getText().toString());
        intent.putExtra("description", editTextDetails.getText().toString());
        intent.putExtra("fragmentToLoad", "NotificationFragment");

        PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(channelID);
            if (notificationChannel == null) {
                int importance = NotificationManager.IMPORTANCE_HIGH;
                notificationChannel = new NotificationChannel(channelID, "Some description", importance);
                notificationChannel.setLightColor(Color.GREEN);
                notificationChannel.enableVibration(true);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                notificationManager.notify(0, builder.build());
            }
        }, 1500);
    }


    private void showSnackbar(View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE)
                .setAction("CLOSE", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Close the Snackbar when the action is clicked
                    }
                });
        snackbar.show();
    }
}
