package com.example.recipeapp.modelEdamam;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class HitsItem implements Serializable {

	@SerializedName("bookmarked")
	private boolean bookmarked;

	@SerializedName("bought")
	private boolean bought;

	@SerializedName("recipe")
	private Recipe recipe;

	public void setBookmarked(boolean bookmarked){
		this.bookmarked = bookmarked;
	}

	public boolean isBookmarked(){
		return bookmarked;
	}

	public void setBought(boolean bought){
		this.bought = bought;
	}

	public boolean isBought(){
		return bought;
	}

	public void setRecipe(Recipe recipe){
		this.recipe = recipe;
	}

	public Recipe getRecipe(){
		return recipe;
	}

	@Override
 	public String toString(){
		return 
			"HitsItem{" + 
			"bookmarked = '" + bookmarked + '\'' + 
			",bought = '" + bought + '\'' + 
			",recipe = '" + recipe + '\'' + 
			"}";
		}
}