package com.example.taskroadcast;

import com.google.gson.annotations.SerializedName;

public class entries {


    private String API;
    private String Description;
    private String Auth;

    @SerializedName("HTTPS")
    private String http;

    private String Cors;
    private String Link;
    private String Category;


    public entries(String API, String description, String auth, String https, String cors, String link, String category) {
        this.API = API;
        Description = description;
        Auth = auth;
        http = https;
        Cors = cors;
        Link = link;
        Category = category;
    }


    public String getAPI() {
        return API;
    }

    public void setAPI(String API) {
        this.API = API;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAuth() {
        return Auth;
    }

    public void setAuth(String auth) {
        Auth = auth;
    }


    public String getHttp() {
        return http;
    }

    public void setHttp(String http) {
        this.http = http;
    }

    public String getCors() {
        return Cors;
    }

    public void setCors(String cors) {
        Cors = cors;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
