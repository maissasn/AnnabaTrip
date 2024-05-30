package com.example.firebasauthapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PlageAdapter extends RecyclerView.Adapter<PlageAdapter.PlageViewHolder> {
    private Context context;
    private List<Plage> plageList;
    private List<Plage> filteredPlageList;

    public PlageAdapter(Context context, List<Plage> plageList) {
        this.context = context;
        this.plageList = plageList;
        this.filteredPlageList = new ArrayList<>(plageList); // Initialize with all beaches
    }

    @NonNull
    @Override
    public PlageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_plage, parent, false);
        return new PlageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlageViewHolder holder, int position) {
        Plage plage = filteredPlageList.get(position);
        holder.plageName.setText(plage.getName());
        holder.plageDescription.setText(plage.getDescription());
        holder.plageImage.setImageResource(plage.getImageResource());
    }

    @Override
    public int getItemCount() {
        return filteredPlageList.size();
    }

    public void filter(String query) {
        filteredPlageList.clear();
        if (query.isEmpty()) {
            filteredPlageList.addAll(plageList);
        } else {
            for (Plage plage : plageList) {
                if (plage.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredPlageList.add(plage);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class PlageViewHolder extends RecyclerView.ViewHolder {
        TextView plageName, plageDescription;
        ImageView plageImage;

        public PlageViewHolder(@NonNull View itemView) {
            super(itemView);
            plageName = itemView.findViewById(R.id.plageName);
            plageDescription = itemView.findViewById(R.id.plageDescription);
            plageImage = itemView.findViewById(R.id.plageImage);
        }
    }
}
