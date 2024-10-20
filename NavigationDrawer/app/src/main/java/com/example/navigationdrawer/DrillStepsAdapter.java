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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DrillStepsAdapter extends ArrayAdapter<DrillStepsItem> {
    private Context context;
    private List<DrillStepsItem> drillStepList;

    public DrillStepsAdapter(@NonNull Context context, List<DrillStepsItem> drillStepList) {
        super(context, 0, drillStepList);
        this.context = context;
        this.drillStepList = drillStepList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.drils_item_steps, parent, false);
        }

        DrillStepsItem currentItem = drillStepList.get(position);
        TextView textViewType = itemView.findViewById(R.id.textViewSteps);
        ImageView imageViewResource = itemView.findViewById(R.id.stepsimage);
        Button buttonDetails = itemView.findViewById(R.id.buttonDetails);

        textViewType.setText(currentItem.getType());
        imageViewResource.setImageResource(currentItem.getImage());
        buttonDetails.setOnClickListener(v -> {
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
