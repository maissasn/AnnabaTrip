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

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder> {
    private Context context;
    private List<ShoppingPlace> shoppingList;
    private List<ShoppingPlace> filteredShoppingList;

    public ShoppingAdapter(Context context, List<ShoppingPlace> shoppingList) {
        this.context = context;
        this.shoppingList = shoppingList;
        this.filteredShoppingList = new ArrayList<>(shoppingList); // Initialize with all shopping places
    }

    @NonNull
    @Override
    public ShoppingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shopping, parent, false);
        return new ShoppingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingViewHolder holder, int position) {
        ShoppingPlace shoppingPlace = filteredShoppingList.get(position);
        holder.shoppingName.setText(shoppingPlace.getName());
        holder.shoppingDescription.setText(shoppingPlace.getDescription());
        holder.shoppingImage.setImageResource(shoppingPlace.getImageResource());
    }

    @Override
    public int getItemCount() {
        return filteredShoppingList.size();
    }

    public void filter(String query) {
        filteredShoppingList.clear();
        if (query.isEmpty()) {
            filteredShoppingList.addAll(shoppingList);
        } else {
            for (ShoppingPlace shoppingPlace : shoppingList) {
                if (shoppingPlace.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredShoppingList.add(shoppingPlace);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class ShoppingViewHolder extends RecyclerView.ViewHolder {
        TextView shoppingName, shoppingDescription;
        ImageView shoppingImage;

        public ShoppingViewHolder(@NonNull View itemView) {
            super(itemView);
            shoppingName = itemView.findViewById(R.id.shoppingName);
            shoppingDescription = itemView.findViewById(R.id.shoppingDescription);
            shoppingImage = itemView.findViewById(R.id.shoppingImage);
        }
    }
}
