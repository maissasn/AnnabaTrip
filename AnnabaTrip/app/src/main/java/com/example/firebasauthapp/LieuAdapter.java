package com.example.firebasauthapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class LieuAdapter extends RecyclerView.Adapter<LieuAdapter.LieuViewHolder> {

    private Context context;
    private List<Lieu> lieuList;
    private List<Lieu> filteredLieuList;

    public LieuAdapter(Context context, List<Lieu> lieuList) {
        this.context = context;
        this.lieuList = lieuList;
        this.filteredLieuList = new ArrayList<>(lieuList);
    }

    @NonNull
    @Override
    public LieuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lieu, parent, false);
        return new LieuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LieuViewHolder holder, int position) {
        Lieu lieu = filteredLieuList.get(position);
        holder.lieuName.setText(lieu.getName());
        holder.lieuDescription.setText(lieu.getDescription());
        holder.lieuImage.setImageResource(lieu.getImageResource());
        holder.openMapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(lieu.getMapLink()));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return filteredLieuList.size();
    }

    public void filter(String query) {
        filteredLieuList.clear();
        if (query.isEmpty()) {
            filteredLieuList.addAll(lieuList);
        } else {
            for (Lieu lieu : lieuList) {
                if (lieu.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredLieuList.add(lieu);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class LieuViewHolder extends RecyclerView.ViewHolder {
        TextView lieuName, lieuDescription;
        ImageView lieuImage;
        Button openMapButton;

        public LieuViewHolder(@NonNull View itemView) {
            super(itemView);
            lieuName = itemView.findViewById(R.id.lieuName);
            lieuDescription = itemView.findViewById(R.id.lieuDescription);
            lieuImage = itemView.findViewById(R.id.lieuImage);
            openMapButton = itemView.findViewById(R.id.openMapButton);
        }
    }
}
