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

public class MuseumAdapter extends RecyclerView.Adapter<MuseumAdapter.MuseumViewHolder> {

    private Context context;
    private List<Museum> museumList;
    private List<Museum> filteredMuseumList;

    public MuseumAdapter(Context context, List<Museum> museumList) {
        this.context = context;
        this.museumList = museumList;
        this.filteredMuseumList = new ArrayList<>(museumList);
    }

    @NonNull
    @Override
    public MuseumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_museum, parent, false);
        return new MuseumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MuseumViewHolder holder, int position) {
        Museum museum = filteredMuseumList.get(position);
        holder.museumName.setText(museum.getName());
        holder.museumDescription.setText(museum.getDescription());
        holder.museumImage.setImageResource(museum.getImageResource());
        holder.openMapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(museum.getMapLink()));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return filteredMuseumList.size();
    }

    public void filter(String query) {
        filteredMuseumList.clear();
        if (query.isEmpty()) {
            filteredMuseumList.addAll(museumList);
        } else {
            for (Museum museum : museumList) {
                if (museum.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredMuseumList.add(museum);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class MuseumViewHolder extends RecyclerView.ViewHolder {
        TextView museumName, museumDescription;
        ImageView museumImage;
        Button openMapButton;

        public MuseumViewHolder(@NonNull View itemView) {
            super(itemView);
            museumName = itemView.findViewById(R.id.museumName);
            museumDescription = itemView.findViewById(R.id.museumDescription);
            museumImage = itemView.findViewById(R.id.museumImage);
            openMapButton = itemView.findViewById(R.id.openMapButton);
        }
    }
}
