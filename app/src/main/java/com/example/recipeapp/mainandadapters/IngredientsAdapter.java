package com.example.recipeapp.mainandadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.R;

import java.util.ArrayList;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.FavoritesViewHolder> {
    private ArrayList<String> linesList;

    public IngredientsAdapter(ArrayList<String> linesList) {
        this.linesList = linesList;
    }
    public class FavoritesViewHolder extends RecyclerView.ViewHolder {
        TextView linesTextView;
        Context context;

        public FavoritesViewHolder(@NonNull View itemView) {
            super(itemView);
            linesTextView = itemView.findViewById(R.id.ingredientLines_txt);
            context = itemView.getContext();
        }
    }

    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredients_recycler, parent, false);
        return new FavoritesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesViewHolder holder, int position) {
        ArrayList<String> linesPosition = new ArrayList<>(linesList);
        String currentItem = linesPosition.get(position);
        holder.linesTextView.setText(currentItem);
    }

    @Override
    public int getItemCount() {
        return linesList.size();
    }
}
