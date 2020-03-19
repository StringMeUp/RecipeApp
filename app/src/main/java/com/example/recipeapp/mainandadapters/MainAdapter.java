package com.example.recipeapp.mainandadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recipeapp.R;
import com.example.recipeapp.modeledamam.HitsItem;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.mViewHolder> {
    private List<HitsItem> hitsItems;
    private Context context;
    private OnItemClickListener mListener;

    MainAdapter(List<HitsItem> hitsItems, Context context, OnItemClickListener listener) {
        this.hitsItems = hitsItems;
        this.context = context;
        this.mListener = listener;
    }

    public class mViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTextView;
        ImageView mImageView;
        CardView cardView;

        mViewHolder(@NonNull View itemView, Context context, List<HitsItem> hitsItems) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView_title);
            mImageView = itemView.findViewById(R.id.circle_imageView);
            cardView = itemView.findViewById(R.id.card_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClicked(v, getAdapterPosition(), hitsItems);
        }
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_recycler, parent, false);
        return new mViewHolder(v, context, hitsItems);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        HitsItem item = hitsItems.get(position);
        holder.mTextView.setText(item.getRecipe().getLabel());
        Glide.with(holder.mImageView)
                .load(item.getRecipe().getImage())
                .override(400, 300)
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return hitsItems.size();
    }
    //the interface passes data between the adapter and other parts of the app
    public interface OnItemClickListener {
        void onItemClicked(View view, int position, List<HitsItem> hitsItem);
    }
}