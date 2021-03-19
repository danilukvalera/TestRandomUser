package com.daniluk.testrandomuser.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListUsersData {
    public ListUsersData(List<UserData> results) {
        this.results = results;
    }

    @SerializedName("results")
    @Expose
    private List<UserData> results = null;
    public List<UserData> getResults() {
        return results;
    }

    public void setResults(List<UserData> results) {
        this.results = results;
    }
}
