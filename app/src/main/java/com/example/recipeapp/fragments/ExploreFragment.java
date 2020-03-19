package com.example.recipeapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.R;
import com.example.recipeapp.helperclass.Background;
import com.example.recipeapp.mainandadapters.ExploreAdapter;
import com.example.recipeapp.mainandadapters.ExploreSupportActivity;
import com.example.recipeapp.modelspoonacular.RandomCuisineItems;
import com.example.recipeapp.modelspoonacular.ResultsItem;
import com.example.recipeapp.network.JsonRecipeInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExploreFragment extends Fragment implements ExploreAdapter.onPositionClick {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_explore, container, false);
        //views
        RecyclerView exploreRecycler;
        RecyclerView.LayoutManager exploreManager;
        RecyclerView.Adapter exploreAdapter;
        //variables
        ArrayList<Background> backgroundContent = new ArrayList<>();
        backgroundContent.add(new Background("Indian", R.drawable.indian));
        backgroundContent.add(new Background("Chinese", R.drawable.chinese));
        backgroundContent.add(new Background("Italian", R.drawable.italian));
        backgroundContent.add(new Background("German", R.drawable.german));

        //initiating Recycler
        exploreRecycler = view.findViewById(R.id.explore_recyclerView);
        exploreManager = new GridLayoutManager(getActivity(), 2);
        exploreRecycler.setLayoutManager(exploreManager);
        exploreAdapter = new ExploreAdapter(backgroundContent, this);
        exploreRecycler.setAdapter(exploreAdapter);
        return view;
    }

    @Override
    public void onItemClick(int position) {
        //views
        //parameters/variables
        final String apiKey = "22982be7fa42470191c17aeba5531735";
        final String cuisine;
        if (position == 0) {
            cuisine = "Indian";
        } else if (position == 1) {
            cuisine = "Chinese";
        } else if (position == 2) {
            cuisine = "Italian";
        } else {
            cuisine = "German";
        }
        System.out.println(cuisine);
        Call<RandomCuisineItems> cuisineItemsCall = JsonRecipeInterface.jsonRecipeInterfaceS.getCuisine(cuisine, apiKey);
        cuisineItemsCall.enqueue(new Callback<RandomCuisineItems>() {
            @Override
            public void onResponse(Call<RandomCuisineItems> call, Response<RandomCuisineItems> response) {
                if (!response.isSuccessful()) {
                    System.out.println("The response was not successful" + response.code());
                } else {
                    RandomCuisineItems randomCuisineItems = response.body();
                    List<ResultsItem> recipesItems = randomCuisineItems.getResults();
                    ArrayList<ResultsItem> dataAcquired = new ArrayList<>(recipesItems);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("data", dataAcquired);
                    Intent passData = new Intent(getView().getContext(), ExploreSupportActivity.class);
                    passData.putExtra("dataAcquired", bundle);
                    passData.putExtra("title", cuisine);
                    startActivity(passData);
                }
            }

            @Override
            public void onFailure(Call<RandomCuisineItems> call, Throwable t) {
                t.printStackTrace();
                System.out.println("Call was not successful! " + t.getMessage());
            }
        });
    }
}
