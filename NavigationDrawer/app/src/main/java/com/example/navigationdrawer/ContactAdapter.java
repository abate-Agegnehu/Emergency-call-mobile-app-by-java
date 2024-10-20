package com.example.navigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ContactAdapter extends ArrayAdapter<String> {
    Context context;
    String[] data;

    public ContactAdapter(Context context, String[] data) {
        super(context, R.layout.contact_list_design, data);
        this.data = data;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater viewLoader = LayoutInflater.from(context);
            convertView = viewLoader.inflate(R.layout.contact_list_design, parent, false);
            holder = new ViewHolder();
            holder.itemName = convertView.findViewById(R.id.contact_list_number);
            holder.callButton = convertView.findViewById(R.id.call_button);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.itemName.setText(data[position]);

        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = holder.itemName.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phoneNumber));
                context.startActivity(callIntent);
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView itemName;
        Button callButton;
    }
}
