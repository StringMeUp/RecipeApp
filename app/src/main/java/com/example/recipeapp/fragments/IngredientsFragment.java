package com.example.recipeapp.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recipeapp.R;
import com.example.recipeapp.mainandadapters.IngredientsAdapter;
import com.example.recipeapp.modeledamam.CHOLE;
import com.example.recipeapp.modeledamam.ENERCKCAL;
import com.example.recipeapp.modeledamam.FAT;
import com.example.recipeapp.modeledamam.HitsItem;
import com.example.recipeapp.modeledamam.SUGAR;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IngredientsFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_ingredients, container, false);
        //RecyclerViews
        RecyclerView linesRecyclerView;
        RecyclerView.LayoutManager linesManager;
        RecyclerView.Adapter linesAdapter;
        //views
        TextView mealTitle = view.findViewById(R.id.meal_txt);
        ImageView mealImage = view.findViewById(R.id.meal_imageView);
        ImageView heartImage = view.findViewById(R.id.heart_image);
        //HorizontalScrollView
        HorizontalScrollView scrollValues = view.findViewById(R.id.values_scrollView);
        //ScrollView views
        TextView firstValue = view.findViewById(R.id.value_one_txt);
        TextView secondValue = view.findViewById(R.id.value_two_txt);
        TextView thirdValue = view.findViewById(R.id.value_three_txt);
        TextView fourthValue = view.findViewById(R.id.value_four_txt);
        //gets passed data from MainActivity via Intent and Bundle
        Intent intent = getActivity().getIntent();
        if (intent == null) {
            Toast.makeText(getContext(), "Intent is empty", Toast.LENGTH_SHORT).show();
        } else {
            Bundle bundle = intent.getExtras();
            HitsItem passedItems = (HitsItem) bundle.getSerializable("passOn");
            //setTitle to mealTitle
            mealTitle.setText(passedItems.getRecipe().getLabel());
            //underlines textTitle
            mealTitle.setPaintFlags(mealTitle.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            //setImage to mealImage
            Glide.with(mealImage)
                    .load(passedItems.getRecipe().getImage())
                    .override(300, 300)
                    .into(mealImage);
            //loop through IngredientsLines and initiate RecyclerView
            List<String> ingredientLinesList = passedItems.getRecipe().getIngredientLines();
            ArrayList<String> linesList = new ArrayList<>(ingredientLinesList);
            linesRecyclerView = view.findViewById(R.id.ingredient_lines_recycler);
            linesManager = new LinearLayoutManager(getActivity());
            linesAdapter = new IngredientsAdapter(linesList);
            linesRecyclerView.setLayoutManager(linesManager);
            linesRecyclerView.setAdapter(linesAdapter);
            //Updated comment: onClick Heart ImageView checks whether SharedPrefs is empty
            //if empty creates an ArrayList, the necessary item is added to it
            //further wrapping it up into a HashSet
            //if not empty same process is repeated and the HashSet is updated (addALL)
            //and passed/put into shared
            heartImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //change background (heart-image) onClick listener
                    heartImage.setImageResource(R.drawable.heart_image_red);
                    Runnable run = new Runnable() {
                        @Override
                        public void run() {
                            //Save to DefaultShared Preferences and forward to Favorites
                            SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(getActivity());
                            Set<String> myTitles = shared.getStringSet("labels", null);
                            if (myTitles == null) {
                                ArrayList<String> titlesContainer = new ArrayList<>();
                                titlesContainer.add(passedItems.getRecipe().getLabel());
                                myTitles = new HashSet<>(titlesContainer);
                                Toast.makeText(getActivity(), "Saved to Favorites!", Toast.LENGTH_SHORT).show();
                            } else {
                                ArrayList<String> titlesContainer = new ArrayList<>(myTitles);
                                titlesContainer.add(passedItems.getRecipe().getLabel());
                                myTitles.addAll(titlesContainer);
                                Toast.makeText(getActivity(), "Saved to Favorites!", Toast.LENGTH_SHORT).show();
                            }
                            SharedPreferences.Editor editor = shared.edit();
                            editor.putStringSet("labels", myTitles);
                            editor.apply();
                        }
                    };

                    Handler handler = new Handler();
                    handler.postDelayed(run, 500);
                }
            });
            //setting HorizontalScrollView Values
            //Cholesterol Value
            CHOLE chole = passedItems.getRecipe().getTotalNutrients().getCHOLE();
            if (chole == null) {
                firstValue.setText("N/A");
            } else {
                int choleInt = (int) chole.getQuantity();
                String choleQuantity = String.valueOf(choleInt);
                String choleLabel = chole.getLabel();
                String totalChole = "";
                totalChole += choleLabel + "\n";
                totalChole += choleQuantity;
                totalChole += chole.getUnit();
                firstValue.setText(totalChole);
            }
            //Fat value
            FAT fat = passedItems.getRecipe().getTotalDaily().getFAT();
            if (fat == null) {
                thirdValue.setText("N/A");
            } else {
                int fatInt = (int) fat.getQuantity();
                String fatQuantity = String.valueOf(fatInt);
                String fatUnit = fat.getUnit();
                String totalFat = "";
                totalFat += fat.getLabel() + "\n";
                totalFat += fatQuantity;
                totalFat += fatUnit;
                secondValue.setText(totalFat);
            }
            //Energy value
            ENERCKCAL enerckcal = passedItems.getRecipe().getTotalNutrients().getENERCKCAL();
            if (enerckcal == null) {
                thirdValue.setText("N/A");
            } else {
                int intEnergy = (int) enerckcal.getQuantity();
                String energyQuantity = String.valueOf(intEnergy);
                String unit = enerckcal.getUnit();
                String energyValues = "";
                energyValues += "Energy" + "\n" + energyQuantity + "\n";
                energyValues += unit;
                thirdValue.setText(energyValues);
            }
            //Sugar value
            SUGAR sugar = passedItems.getRecipe().getTotalNutrients().getSUGAR();
            if (sugar == null) {
                fourthValue.setText("N/A");
            } else {
                String suggarContent = "";
                int doubleSugar = (int) sugar.getQuantity();
                String sugarQuantity = String.valueOf(doubleSugar);
                suggarContent += "Sugars" + "\n" + sugarQuantity;
                suggarContent += sugar.getUnit();
                fourthValue.setText(suggarContent);
            }
        }
        return view;
    }
}