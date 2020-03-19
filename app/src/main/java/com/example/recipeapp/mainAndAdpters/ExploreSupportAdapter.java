package com.example.recipeapp.mainAndAdpters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recipeapp.R;
import com.example.recipeapp.modelSpoonacular.ResultsItem;

import java.util.ArrayList;

public class ExploreSupportAdapter extends RecyclerView.Adapter<ExploreSupportAdapter.CuisineViewHolder> {
    private ArrayList<ResultsItem> receivedData;

    ExploreSupportAdapter(ArrayList<ResultsItem> receivedData) {
        this.receivedData = receivedData;
    }

    public class CuisineViewHolder extends RecyclerView.ViewHolder {
        TextView foodText;
        ImageView foodImage;

        CuisineViewHolder(@NonNull View itemView) {
            super(itemView);
            foodText = itemView.findViewById(R.id.food_txt);
            foodImage = itemView.findViewById(R.id.food_image);
        }
    }

    @NonNull
    @Override
    public CuisineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cuisineView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cuisine_recycler, parent, false);
        return new CuisineViewHolder(cuisineView);
    }

    @Override
    public void onBindViewHolder(@NonNull CuisineViewHolder holder, int position) {
        ResultsItem item = receivedData.get(position);
        final String baseUri = "https://spoonacular.com/recipeImages/" + item.getImage();
        holder.foodText.setText(item.getTitle());
        Glide.with(holder.foodImage)
                .load(baseUri)
                .into(holder.foodImage);
    }

    @Override
    public int getItemCount() {
        return receivedData.size();
    }
}
