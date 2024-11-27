package com.example.requestapipokemon.response;

import java.util.List;

import com.example.requestapipokemon.models.Pokemon;
import com.google.gson.annotations.SerializedName;

public class Estructura {

    @SerializedName("count")
    private Integer mCount;
    @SerializedName("next")
    private String mNext;
    @SerializedName("previous")
    private String mPrevious;
    @SerializedName("results")
    private List<Pokemon> mResults;

    public Integer getCount() {
        return mCount;
    }

    public void setCount(Integer count) {
        mCount = count;
    }

    public String getNext() {
        return mNext;
    }

    public void setNext(String next) {
        mNext = next;
    }

    public String getPrevious() {
        return mPrevious;
    }

    public void setPrevious(String previous) {
        mPrevious = previous;
    }

    public List<Pokemon> getResults() {
        return mResults;
    }

    public void setResults(List<Pokemon> results) {
        mResults = results;
    }

}