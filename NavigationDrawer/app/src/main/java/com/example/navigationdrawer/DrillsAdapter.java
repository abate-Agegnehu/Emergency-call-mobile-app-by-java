package com.example.navigationdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class DrillsAdapter extends ArrayAdapter<DrillsItem> {
    private Context context;
    private List<DrillsItem> drillsList;

    public DrillsAdapter(@NonNull Context context, List<DrillsItem> drillsList) {
        super(context, 0, drillsList);
        this.context = context;
        this.drillsList = drillsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.drils_item_layout, parent, false);
        }

        DrillsItem currentItem = drillsList.get(position);
        TextView textViewType = itemView.findViewById(R.id.textViewType);
        TextView textViewDescription = itemView.findViewById(R.id.textViewDescription);

        textViewType.setText(currentItem.getType());
        textViewDescription.setText(currentItem.getDescription());


        return itemView;
    }
}
