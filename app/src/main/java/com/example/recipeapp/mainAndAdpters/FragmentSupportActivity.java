package com.example.recipeapp.mainAndAdpters;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.recipeapp.R;
import com.example.recipeapp.fragments.ExploreFragment;
import com.example.recipeapp.fragments.FavoritesFragment;
import com.example.recipeapp.fragments.IngredientsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentSupportActivity extends AppCompatActivity {
    //views
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new IngredientsFragment()).commit();
        // methods called
        getNavigationDrawer();
    }

    //sets on click listener for each fragment
    public void getNavigationDrawer() {
        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectFragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_ingredients:
                        selectFragment = new IngredientsFragment();
                        break;
                    case R.id.nav_favorites:
                        selectFragment = new FavoritesFragment();
                        break;
                    case R.id.nav_explore:
                        selectFragment = new ExploreFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectFragment).commit();
                return true;
            }
        });
    }
}