package com.example.android3lesson2.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PixabayResponce {
    @SerializedName("total")
    public int total;
    @SerializedName("totalHits")
    public int totalHits;
    @SerializedName("hits")
    public List<Hits> hits = null;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public List<Hits> getHits() {
        return hits;
    }

    public void setHits(List<Hits> hits) {
        this.hits = hits;
    }
}

