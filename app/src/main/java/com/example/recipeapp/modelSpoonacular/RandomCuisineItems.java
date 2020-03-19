package com.example.recipeapp.modelSpoonacular;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class RandomCuisineItems implements Serializable {

    @SerializedName("number")
    private int number;

    @SerializedName("totalResults")
    private int totalResults;

    @SerializedName("expires")
    private long expires;

    @SerializedName("offset")
    private int offset;

    @SerializedName("processingTimeMs")
    private int processingTimeMs;

    @SerializedName("baseUri")
    private String baseUri;

    @SerializedName("isStale")
    private boolean isStale;

    @SerializedName("results")
    private List<ResultsItem> results;

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    public long getExpires() {
        return expires;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }

    public void setProcessingTimeMs(int processingTimeMs) {
        this.processingTimeMs = processingTimeMs;
    }

    public int getProcessingTimeMs() {
        return processingTimeMs;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    public String getBaseUri() {
        return baseUri;
    }

    public void setIsStale(boolean isStale) {
        this.isStale = isStale;
    }

    public boolean isIsStale() {
        return isStale;
    }

    public void setResults(List<ResultsItem> results) {
        this.results = results;
    }

    public List<ResultsItem> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return
                "RandomCuisineItems{" +
                        "number = '" + number + '\'' +
                        ",totalResults = '" + totalResults + '\'' +
                        ",expires = '" + expires + '\'' +
                        ",offset = '" + offset + '\'' +
                        ",processingTimeMs = '" + processingTimeMs + '\'' +
                        ",baseUri = '" + baseUri + '\'' +
                        ",isStale = '" + isStale + '\'' +
                        ",results = '" + results + '\'' +
                        "}";
    }
}