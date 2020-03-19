package com.example.recipeapp.mainandadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.R;

import java.util.ArrayList;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder> {
    ArrayList<String> titlesReceived;

    public FavoritesAdapter(ArrayList<String> titlesReceived) {
        this.titlesReceived = titlesReceived;
    }

    public class FavoritesViewHolder extends RecyclerView.ViewHolder {
        TextView favoriteRecipe;
        ImageView favoriteIcon;

        public FavoritesViewHolder(@NonNull View itemView) {
            super(itemView);
            favoriteRecipe = itemView.findViewById(R.id.favorites_textView);
            favoriteIcon = itemView.findViewById(R.id.favorites_imageView);
        }
    }

    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorites_recycler, parent, false);
        return new FavoritesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesViewHolder holder, int position) {
        String title = titlesReceived.get(position);
        holder.favoriteRecipe.setText(title);
        holder.favoriteIcon.setImageResource(R.drawable.heart_image_red);
    }

    @Override
    public int getItemCount() {
        return titlesReceived.size();
    }
}
