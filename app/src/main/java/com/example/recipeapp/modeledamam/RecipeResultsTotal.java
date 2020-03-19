package com.example.recipeapp.modeledamam;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class RecipeResultsTotal implements Serializable {

	@SerializedName("hits")
	private List<HitsItem> hits;

	@SerializedName("q")
	private String Q;

	@SerializedName("more")
	private boolean more;

	@SerializedName("count")
	private int count;

	@SerializedName("from")
	private int from;

	@SerializedName("to")
	private int to;

	public void setHits(List<HitsItem> hits){
		this.hits = hits;
	}

	public List<HitsItem> getHits(){
		return hits;
	}

	public void setQ(String Q){
		this.Q = Q;
	}

	public String getQ(){
		return Q;
	}

	public void setMore(boolean more){
		this.more = more;
	}

	public boolean isMore(){
		return more;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setFrom(int from){
		this.from = from;
	}

	public int getFrom(){
		return from;
	}

	public void setTo(int to){
		this.to = to;
	}

	public int getTo(){
		return to;
	}

	@Override
 	public String toString(){
		return 
			"RecipeResultsTotal{" + 
			"hits = '" + hits + '\'' + 
			",q = '" + Q + '\'' + 
			",more = '" + more + '\'' + 
			",count = '" + count + '\'' + 
			",from = '" + from + '\'' + 
			",to = '" + to + '\'' + 
			"}";
		}
}