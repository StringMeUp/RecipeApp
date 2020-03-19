package com.example.recipeapp.mainAndAdpters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.R;
import com.example.recipeapp.helperClass.Background;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ExploreViewHOlder> {
    private ArrayList<Background> backgroundContent;
    private onPositionClick positionClick;

    public ExploreAdapter(ArrayList<Background> backgroundContent, onPositionClick positionClick) {
        this.backgroundContent = backgroundContent;
        this.positionClick = positionClick;
    }

    public class ExploreViewHOlder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        private CircleImageView exploreImage;
        private TextView exploreTextView;

        public ExploreViewHOlder(@NonNull View itemView) {
            super(itemView);
            exploreImage = itemView.findViewById(R.id.image_of_interest);
            exploreTextView = itemView.findViewById(R.id.title_of_interest);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            positionClick.onItemClick(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public ExploreViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.explore_recycler, parent, false);
        return new ExploreViewHOlder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreViewHOlder holder, int position) {
        Background background = backgroundContent.get(position);
        holder.exploreTextView.setText(background.getCuisine());
        holder.exploreImage.setImageResource(background.getBackgroundImage());
    }

    @Override
    public int getItemCount() {
        return backgroundContent.size();
    }

    public interface onPositionClick {
        void onItemClick(int position);

    }
}
