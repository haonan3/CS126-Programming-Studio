package com.example;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class ParseSiebelJson {
    public static Layout layout;
    public static String url;
    public ParseSiebelJson(String URL){
        url = URL;
    }
    public Layout parseJson() {
        Gson gson = new Gson();
        HttpResponse<String> stringHttpResponse = null;
        try {
            stringHttpResponse = Unirest.get(url).asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        if (stringHttpResponse.getStatus() == 200) {
            String Json = stringHttpResponse.getBody();
            layout = gson.fromJson(Json, Layout.class);
        }else{
            System.out.println("bad url");
        }
        return layout;
    }
}
