package com.example.recipeapp.mainandadapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.R;
import com.example.recipeapp.modeledamam.HitsItem;
import com.example.recipeapp.modeledamam.RecipeResultsTotal;
import com.example.recipeapp.network.JsonRecipeInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnItemClickListener {
    //Vars Api (Variables for Api)
    private String q = ""; //is taken from user input
    private final String app_id = "942b4a3c";
    private final String app_key = "a7e25d17bb3b13508a53b136aca89648";
    private final int from = 0;
    private final int to = 10;
    private String calories = "";

    //RecyclerView
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mManager;
    private MainAdapter mAdapter;

    //Views
    private Button getButton;
    private EditText searchEdiText;
    private Spinner mSpinner;
    private ArrayAdapter<String> arrayAdapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getButton = findViewById(R.id.button_get);
        searchEdiText = findViewById(R.id.search_txt);
        mSpinner = findViewById(R.id.spinner_view);
        progressBar = findViewById(R.id.progress_bar);
        mRecyclerView = findViewById(R.id.recycler_view);

        //Called methods
        setSpinner();
        displayResponse();
        initRecyclerView();
    }

    //Sets the spinner and onItemSelectedListener that lets users choose caloric value of the meal/recipe
    public void setSpinner() {
        arrayAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.calories));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        mSpinner.setAdapter(arrayAdapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 2) {
                    calories = "50-100";
                } else if (position == 3) {
                    calories = "100-200";
                } else if (position == 4) {
                    calories = "200-300";
                } else if (position == 5) {
                    calories = "300-400";
                } else if (position == 6) {
                    calories = "400-500";
                } else if (position == 7) {
                    calories = "500-600";
                } else if (position == 8) {
                    calories = "600-700";
                } else if (position == 9) {
                    calories = "700-800";
                } else if (position == 1) {
                    calories = "50-5000";
                    Toast.makeText(MainActivity.this, "The default caloric value is: 50-5000 Kcal", Toast.LENGTH_SHORT).show();
                } else {
                    calories = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Nothing Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void displayResponse() {
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q = searchEdiText.getText().toString();
                if (q.isEmpty() || calories.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a valid query or set caloric value to default.", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                Call<RecipeResultsTotal> resultsTotalCall = JsonRecipeInterface.jsonRecipeInterface.
                        getRecipe(q, app_id, app_key, from, to, calories);
                resultsTotalCall.enqueue(new Callback<RecipeResultsTotal>() {
                    @Override
                    public void onResponse(Call<RecipeResultsTotal> call, Response<RecipeResultsTotal> response) {
                        if (!response.isSuccessful() || response.code() != 200 || response.body().getHits().isEmpty()) {
                            Toast.makeText(MainActivity.this, "No results found: Please enter a valid search query!", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        } else {
                            List<HitsItem> hitsItem = response.body().getHits();
                            progressBar.setVisibility(View.GONE);
                            mAdapter = new MainAdapter(hitsItem, MainActivity.this, MainActivity.this);
                            mRecyclerView.setAdapter(mAdapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<RecipeResultsTotal> call, Throwable t) {
                        t.printStackTrace();
                        System.out.println("Unsuccessful call");
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "Please try again!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    //initiates recyclerView
    public void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mManager = new GridLayoutManager(MainActivity.this, 2);
        mRecyclerView.setLayoutManager(mManager);
    }

    //passes data to IngredientsFragment
    @Override
    public void onItemClicked(View view, int position, List<HitsItem> hitsItem) {
        Intent intent = new Intent(MainActivity.this, FragmentSupportActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("passOn", hitsItem.get(position));
        intent.putExtras(bundle);
        startActivity(intent);
    }
}