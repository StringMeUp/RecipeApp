package com.example.recipeapp.mainAndAdpters;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.R;
import com.example.recipeapp.modelSpoonacular.ResultsItem;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ExploreSupportActivity extends MainActivity {
    //views
    TextView cuisineTitle;
    CircleImageView cuisineImage;
    RecyclerView cuisineRecycler;
    RecyclerView.LayoutManager cuisineManager;
    RecyclerView.Adapter cuisineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore_support);
        getAdditionalData();
    }

    public void getAdditionalData() {
        Intent intent = getIntent();
        if (intent == null) {
            System.out.println("Contents is empty!");
        } else {
            cuisineTitle = findViewById(R.id.cuisine_txt);
            cuisineImage = findViewById(R.id.cuisine_image);
            Bundle getData = getIntent().getBundleExtra("dataAcquired");
            ArrayList<ResultsItem> receivedData = (ArrayList<ResultsItem>) getData.getSerializable("data");
            //sets Text to Cuisine Value
            String title = getIntent().getStringExtra("title");
            if(title.equals("Indian")){
                cuisineImage.setImageResource(R.drawable.indianflag);
            }else if(title.equals("German")){
                cuisineImage.setImageResource(R.drawable.germanflag);
            }else if(title.equals("Italian")){
                cuisineImage.setImageResource(R.drawable.italianflag);
            }else{
                cuisineImage.setImageResource(R.drawable.chineseflag);
            }
            cuisineTitle.setText(title);
            //sets Recycler
            cuisineRecycler = findViewById(R.id.cuisine_recyclerView);
            cuisineManager = new LinearLayoutManager(this);
            cuisineRecycler.setLayoutManager(cuisineManager);
            cuisineAdapter = new ExploreSupportAdapter(receivedData);
            cuisineRecycler.setAdapter(cuisineAdapter);
        }
    }
}
