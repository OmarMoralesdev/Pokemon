
package com.example.requestapipokemon.models;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Pokemon implements Serializable {

    @SerializedName("name")
    private String mName;
    @SerializedName("url")
    private String mUrl;

    public Pokemon(String name, String url) {
        mName = name;
        mUrl = url;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getId() {
        String[] urlParts = mUrl.split("/");
        String id = urlParts[urlParts.length - 1];
        String url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + id +".png";
        return url;
    }

    public Integer getId2() {
        String[] urlParts = mUrl.split("/");
        String idStr = urlParts[urlParts.length - 1];
        Integer id = Integer.parseInt(idStr);
        return id;
    }
}
