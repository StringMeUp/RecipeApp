package com.example.recipeapp.modeledamam;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Recipe implements Serializable {

	@SerializedName("image")
	private String image;

	@SerializedName("shareAs")
	private String shareAs;

	@SerializedName("cautions")
	private List<Object> cautions;

	@SerializedName("healthLabels")
	private List<String> healthLabels;

	@SerializedName("totalTime")
	private double totalTime;

	@SerializedName("label")
	private String label;

	@SerializedName("source")
	private String source;

	@SerializedName("calories")
	private double calories;

	@SerializedName("uri")
	private String uri;

	@SerializedName("url")
	private String url;

	@SerializedName("totalNutrients")
	private TotalNutrients totalNutrients;

	@SerializedName("dietLabels")
	private List<String> dietLabels;

	@SerializedName("yield")
	private double yield;

	@SerializedName("totalWeight")
	private double totalWeight;

	@SerializedName("digest")
	private List<DigestItem> digest;

	@SerializedName("ingredients")
	private List<IngredientsItem> ingredients;

	@SerializedName("totalDaily")
	private TotalDaily totalDaily;

	@SerializedName("ingredientLines")
	private List<String> ingredientLines;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setShareAs(String shareAs){
		this.shareAs = shareAs;
	}

	public String getShareAs(){
		return shareAs;
	}

	public void setCautions(List<Object> cautions){
		this.cautions = cautions;
	}

	public List<Object> getCautions(){
		return cautions;
	}

	public void setHealthLabels(List<String> healthLabels){
		this.healthLabels = healthLabels;
	}

	public List<String> getHealthLabels(){
		return healthLabels;
	}

	public void setTotalTime(double totalTime){
		this.totalTime = totalTime;
	}

	public double getTotalTime(){
		return totalTime;
	}

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setCalories(double calories){
		this.calories = calories;
	}

	public double getCalories(){
		return calories;
	}

	public void setUri(String uri){
		this.uri = uri;
	}

	public String getUri(){
		return uri;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setTotalNutrients(TotalNutrients totalNutrients){
		this.totalNutrients = totalNutrients;
	}

	public TotalNutrients getTotalNutrients(){
		return totalNutrients;
	}

	public void setDietLabels(List<String> dietLabels){
		this.dietLabels = dietLabels;
	}

	public List<String> getDietLabels(){
		return dietLabels;
	}

	public void setYield(double yield){
		this.yield = yield;
	}

	public double getYield(){
		return yield;
	}

	public void setTotalWeight(double totalWeight){
		this.totalWeight = totalWeight;
	}

	public double getTotalWeight(){
		return totalWeight;
	}

	public void setDigest(List<DigestItem> digest){
		this.digest = digest;
	}

	public List<DigestItem> getDigest(){
		return digest;
	}

	public void setIngredients(List<IngredientsItem> ingredients){
		this.ingredients = ingredients;
	}

	public List<IngredientsItem> getIngredients(){
		return ingredients;
	}

	public void setTotalDaily(TotalDaily totalDaily){
		this.totalDaily = totalDaily;
	}

	public TotalDaily getTotalDaily(){
		return totalDaily;
	}

	public void setIngredientLines(List<String> ingredientLines){
		this.ingredientLines = ingredientLines;
	}

	public List<String> getIngredientLines(){
		return ingredientLines;
	}

	@Override
 	public String toString(){
		return 
			"Recipe{" + 
			"image = '" + image + '\'' + 
			",shareAs = '" + shareAs + '\'' + 
			",cautions = '" + cautions + '\'' + 
			",healthLabels = '" + healthLabels + '\'' + 
			",totalTime = '" + totalTime + '\'' + 
			",label = '" + label + '\'' + 
			",source = '" + source + '\'' + 
			",calories = '" + calories + '\'' + 
			",uri = '" + uri + '\'' + 
			",url = '" + url + '\'' + 
			",totalNutrients = '" + totalNutrients + '\'' + 
			",dietLabels = '" + dietLabels + '\'' + 
			",yield = '" + yield + '\'' + 
			",totalWeight = '" + totalWeight + '\'' + 
			",digest = '" + digest + '\'' + 
			",ingredients = '" + ingredients + '\'' + 
			",totalDaily = '" + totalDaily + '\'' + 
			",ingredientLines = '" + ingredientLines + '\'' + 
			"}";
		}
}