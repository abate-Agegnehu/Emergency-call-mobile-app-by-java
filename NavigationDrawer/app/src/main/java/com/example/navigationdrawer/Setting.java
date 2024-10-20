package com.example.navigationdrawer;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

public class Setting extends Fragment {

    private SeekBar brightnessSeekBar;
    private Switch toggleThemeButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.emergency_setting, container, false);

        brightnessSeekBar = view.findViewById(R.id.brightness_seekbar);
        toggleThemeButton = view.findViewById(R.id.toggle_theme_button);

        // Request permission to modify system settings if needed
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.System.canWrite(getActivity())) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:" + getActivity().getPackageName()));
                startActivity(intent);
            }
        }

        // Set initial brightness
        int brightness = getScreenBrightness();
        brightnessSeekBar.setProgress(brightness);

        // Handle brightness change
        brightnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setScreenBrightness(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }
        });

        // Handle theme toggle
        toggleThemeButton.setOnClickListener(v -> {
            int nightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
            if (nightMode == Configuration.UI_MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            getActivity().recreate(); // Recreate the activity to apply the new theme
        });

        return view;
    }

    private int getScreenBrightness() {
        try {
            ContentResolver resolver = getActivity().getContentResolver();
            return Settings.System.getInt(resolver, Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return 128;
        }
    }

    private void setScreenBrightness(int brightness) {
        ContentResolver resolver = getActivity().getContentResolver();
        Settings.System.putInt(resolver, Settings.System.SCREEN_BRIGHTNESS, brightness);
    }
}
