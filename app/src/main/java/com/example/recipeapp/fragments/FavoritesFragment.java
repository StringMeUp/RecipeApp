package com.example.recipeapp.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.R;
import com.example.recipeapp.mainandadapters.FavoritesAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FavoritesFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_favorites, container, false);
        //Welcome Toast
        //Toast.makeText(getActivity(), "Hello, here you can add/delete your favorite recipes!", Toast.LENGTH_SHORT).show();
        //Fetch Data And Filter
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(getActivity());
        Set<String> receivingContainer = shared.getStringSet("labels", null);
        if (receivingContainer == null) {
            Toast.makeText(getActivity(), "Your list is empty!", Toast.LENGTH_SHORT).show();
        }
        ArrayList<String> titlesReceived = new ArrayList<>(receivingContainer);
        //Views
        RecyclerView favRecyclerView = view.findViewById(R.id.fav_recyclerView);
        RecyclerView.LayoutManager favManager = new LinearLayoutManager(getActivity());
        RecyclerView.Adapter favAdapter = new FavoritesAdapter(titlesReceived);
        //SetUp RecyclerView
        favRecyclerView.setHasFixedSize(true);
        favRecyclerView.setLayoutManager(favManager);
        favRecyclerView.setAdapter(favAdapter);
        //swipeTo Delete an Item
        ItemTouchHelper.SimpleCallback itemTouchHelperSimpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                Set<String> updatedContainer = sharedPreferences.getStringSet("labels", null);
                if (updatedContainer != null) {
                    String title = titlesReceived.get(viewHolder.getAdapterPosition());
                    ArrayList<String> updatedList = new ArrayList<>(titlesReceived);
                    updatedList.remove(title);
                    updatedContainer = new HashSet<>(updatedList);
                } else {
                    ArrayList<String> updatedList = new ArrayList<>(titlesReceived);
                    updatedContainer.addAll(updatedList);
                }
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putStringSet("labels", updatedContainer);
                editor.apply();
                titlesReceived.remove(viewHolder.getAdapterPosition());
                favAdapter.notifyDataSetChanged();
            }
        };
        new ItemTouchHelper(itemTouchHelperSimpleCallback).attachToRecyclerView(favRecyclerView);
        return view;
    }
}