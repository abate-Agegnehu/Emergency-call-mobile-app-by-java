package com.example.navigationdrawer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SafetyTipAdapter extends RecyclerView.Adapter<SafetyTipAdapter.SafetyTipViewHolder> {

    private List<SafetyTip> safetyTipList;

    public SafetyTipAdapter(List<SafetyTip> safetyTipList) {
        this.safetyTipList = safetyTipList;
    }

    @NonNull
    @Override
    public SafetyTipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_safety_tip, parent, false);
        return new SafetyTipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SafetyTipViewHolder holder, int position) {
        SafetyTip safetyTip = safetyTipList.get(position);
        holder.textViewTipTitle.setText(safetyTip.getTitle());
        holder.textViewTipDescription.setText(safetyTip.getDescription());
        holder.imageViewTip.setImageResource(safetyTip.getImage());
    }

    @Override
    public int getItemCount() {
        return safetyTipList.size();
    }

    static class SafetyTipViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTipTitle;
        TextView textViewTipDescription;
        ImageView imageViewTip;

        public SafetyTipViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTipTitle = itemView.findViewById(R.id.textViewTipTitle);
            textViewTipDescription = itemView.findViewById(R.id.textViewTipDescription);
            imageViewTip=itemView.findViewById(R.id.imageViewTip);
        }
    }
}
