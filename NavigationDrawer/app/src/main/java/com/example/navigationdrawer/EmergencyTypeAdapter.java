package com.example.navigationdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class EmergencyTypeAdapter extends ArrayAdapter<String> {
    Context cont;
    String[] data;

    public EmergencyTypeAdapter(Context context, String[] data) {
        super(context, R.layout.emergency_type, data);
        this.data = data;
        this.cont = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater viewLoader = LayoutInflater.from(cont);
            convertView = viewLoader.inflate(R.layout.emergency_type, parent, false);
            holder = new ViewHolder();
            holder.itemName = convertView.findViewById(R.id.contact_list_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.itemName.setText(data[position]);

        return convertView;
    }

    static class ViewHolder {
        TextView itemName;
    }
}
