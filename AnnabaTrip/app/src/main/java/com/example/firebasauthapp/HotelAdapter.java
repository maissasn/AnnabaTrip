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

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {
    private Context context;
    private List<Hotel> hotelList;
    private List<Hotel> filteredHotelList;

    public HotelAdapter(Context context, List<Hotel> hotelList) {
        this.context = context;
        this.hotelList = hotelList;
        this.filteredHotelList = new ArrayList<>(hotelList); // Initialize with all hotels
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hotel
                , parent, false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
        Hotel hotel = filteredHotelList.get(position);
        holder.hotelName.setText(hotel.getName());
        holder.hotelDescription.setText(hotel.getDescription());
        holder.hotelImage.setImageResource(hotel.getImageResource());
    }

    @Override
    public int getItemCount() {
        return filteredHotelList.size();
    }

    public void filter(String query) {
        filteredHotelList.clear();
        if (query.isEmpty()) {
            filteredHotelList.addAll(hotelList);
        } else {
            for (Hotel hotel : hotelList) {
                if (hotel.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredHotelList.add(hotel);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class HotelViewHolder extends RecyclerView.ViewHolder {
        TextView hotelName, hotelDescription;
        ImageView hotelImage;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);
            hotelName = itemView.findViewById(R.id.hotelName);
            hotelDescription = itemView.findViewById(R.id.hotelDescription);
            hotelImage = itemView.findViewById(R.id.hotelImage);
        }
    }}