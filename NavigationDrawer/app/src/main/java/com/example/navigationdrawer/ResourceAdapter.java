package com.example.navigationdrawer;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.navigationdrawer.ResourceItem;

import java.util.List;

public class ResourceAdapter extends ArrayAdapter<ResourceItem> {
    private Context context;
    private List<ResourceItem> resourceList;

    public ResourceAdapter(@NonNull Context context, List<ResourceItem> resourceList) {
        super(context, 0, resourceList);
        this.context = context;
        this.resourceList = resourceList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.grid_item_layout, parent, false);
        }

        ResourceItem currentItem = resourceList.get(position);
        ImageView imageViewResource = itemView.findViewById(R.id.imageViewResource);
        TextView textViewType = itemView.findViewById(R.id.textViewType);
        TextView textViewDescription = itemView.findViewById(R.id.textViewDescription);
        Button buttonSteps = itemView.findViewById(R.id.buttonSteps);

        imageViewResource.setImageResource(currentItem.getImageResource());
        textViewType.setText(currentItem.getType());
        textViewDescription.setText(currentItem.getDescription());
        buttonSteps.setOnClickListener(v -> {
            // Convert List<String> to a formatted String
            StringBuilder stepsBuilder = new StringBuilder();
            int i=0;
            for (String step : currentItem.getSteps()) {
                i++;
                stepsBuilder.append(i+". "+step).append("\n");  // Append each step with a new line
            }
            String stepsText = stepsBuilder.toString().trim();  // Remove trailing whitespace

            // Show formatted steps in a Toast
            AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AlertDialogStyle);
            builder.setTitle("Steps");
            builder.setMessage(stepsText);
            builder.setPositiveButton("Close", null);
            builder.show();
        });


        return itemView;
    }

}
