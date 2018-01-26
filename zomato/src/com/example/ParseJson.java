package com.example;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/***
 * This class is used to parse Json from zomato.
 * The restaurant number information got from parseJson will be used to generate fitted array to contain
 * all restaurants information.
 */
public class ParseJson {
    private static ZomatoCollection zomatoCollection;

    /***
     * This function is used to get restaurants number information from zomato.
     * The required restaurants number and the shown restaurants number will be used to generate array.
     * The array will contain all information of restaurants satisfied requirement.
     * @param city
     * @param cuisines
     * @return restaurant information from zomato website
     * @throws UnirestException
     */
    public static ZomatoCollection parseJson(int city, int cuisines) throws UnirestException {
        Gson gson = new Gson();
        String url = "https://developers.zomato.com/api/v2.1/search?entity_id=" + String.valueOf(city) +
                "&entity_type=city&cuisines=" + String.valueOf(cuisines);
        final HttpResponse<String> stringHttpResponse = Unirest.get(url).header("user-key",
                ZomatoAPI.API_KEY).asString();
        if (stringHttpResponse.getStatus() == 200) {
            String Json = stringHttpResponse.getBody();
            zomatoCollection = gson.fromJson(Json, ZomatoCollection.class);
        }
        return zomatoCollection;
    }

    /***
     * This function can return restaurants information in a array. Each one can have 20 restaurants information.
     * If the number of restaurants satisfied requirement is less than 20. The array will only have one element.
     * @param city  City ID
     * @param cuisines Cuisine ID
     * @return restaurants information on zomato website
     * @throws UnirestException
     */
    public ZomatoCollection[] parseMoreJson(int city, int cuisines) throws UnirestException {
        int totalNum = zomatoCollection.getResults_found();
        int arrayNum = 0;
        for(; totalNum > 0; arrayNum++){
            totalNum -= 20;
        }
        ZomatoCollection[] zomatoArray = new ZomatoCollection[arrayNum];
        for(int i = 0; i<arrayNum; i++){
            Gson gson = new Gson();
            String url = "https://developers.zomato.com/api/v2.1/search?entity_id=" + String.valueOf(city) +
                    "&entity_type=city&start=" + String.valueOf(20*i) + "&cuisines=" + String.valueOf(cuisines);

            final HttpResponse<String> stringHttpResponse = Unirest.get(url).header("user-key",
                    ZomatoAPI.API_KEY).asString();
            if (stringHttpResponse.getStatus() == 200) {
                String Json = stringHttpResponse.getBody();
                zomatoArray[i] = gson.fromJson(Json, ZomatoCollection.class);
            }
        }
        return zomatoArray;
    }
}
