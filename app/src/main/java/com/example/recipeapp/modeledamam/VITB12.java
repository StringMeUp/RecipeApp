package com.example.recipeapp.modeledamam;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class VITB12 implements Serializable {

	@SerializedName("unit")
	private String unit;

	@SerializedName("quantity")
	private double quantity;

	@SerializedName("label")
	private String label;

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	public void setQuantity(double quantity){
		this.quantity = quantity;
	}

	public double getQuantity(){
		return quantity;
	}

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	@Override
 	public String toString(){
		return 
			"VITB12{" + 
			"unit = '" + unit + '\'' + 
			",quantity = '" + quantity + '\'' + 
			",label = '" + label + '\'' + 
			"}";
		}
}