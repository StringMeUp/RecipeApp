package com.example.recipeapp.network;

import com.example.recipeapp.modelEdamam.RecipeResultsTotal;
import com.example.recipeapp.modelSpoonacular.RandomCuisineItems;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonRecipeInterface {
    //Source: EDAMAM Api Call BASE/Parameters
    //https://api.edamam.com/search?q=pasta&app_id=942b4a3c&app_key=a7e25d17bb3b13508a53b136aca89648&from=0&to=10
    //&calories=591-722 (excluded parameter)
    //Source: SPOONACULAR
    //https://api.spoonacular.com/recipes/search?cuisine=irish&apiKey=22982be7fa42470191c17aeba5531735
    String BASE_URL = "https://api.edamam.com/";

    @GET("search")
    Call<RecipeResultsTotal> getRecipe(@Query("q") String q, @Query("app_id") String app_id,
                                       @Query("app_key") String app_key, @Query("from") int from, @Query("to") int to,
                                       @Query("calories") String calories);

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build();

    JsonRecipeInterface jsonRecipeInterface = retrofit.create(JsonRecipeInterface.class);

    String BASE_URLS = "https://api.spoonacular.com/recipes/";

    @GET("search")
    Call<RandomCuisineItems> getCuisine(@Query("cuisine") String cuisine,
                                        @Query("apiKey") String apiKey);

    Retrofit retrofitS = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URLS)
            .build();

    JsonRecipeInterface jsonRecipeInterfaceS = retrofitS.create(JsonRecipeInterface.class);
}