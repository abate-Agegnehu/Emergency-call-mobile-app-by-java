package com.example.navigationdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class PublicSafety extends Activity implements AdapterView.OnItemClickListener {
    GridView gridView;
    String[] data;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list);

        data = getResources().getStringArray(R.array.safety_contact);
        gridView = findViewById(R.id.contact_list);
        contactAdapter = new ContactAdapter(this, data);
        gridView.setAdapter(contactAdapter);
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Selected item is: " + data[position] + " with position " + (1 + position), Toast.LENGTH_SHORT).show();
    }
}
