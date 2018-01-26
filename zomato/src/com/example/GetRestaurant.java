package com.example;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class GetRestaurant {
    private static ZomatoCollection zomatoCollection;
    /***
     *Main method is used to pass information to filter restaurant and print returned restaurants.
     * @param args program variables
     * @throws UnirestException
     */
    public static void main(String[] args) throws UnirestException {
        //the exception of parseJson method will be caught in this place
        try {
            zomatoCollection = ParseJson.parseJson(685, 73);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        ParseJson parseJson = new ParseJson();
        ZomatoCollection[] zomatoCollections = parseJson.parseMoreJson(685, 73);
        int arrayNum = zomatoCollections.length;
        for (int j = 0; j < arrayNum; j++) {

            int shownNum = zomatoCollections[j].getResults_shown();
            for (int i = 0; i < shownNum; i++) {

                //Get restaurant information
                String restaurantName = zomatoCollections[j].getRestaurantsArray()[i].getRestaurant().getName();
                String address = zomatoCollections[j].getRestaurantsArray()[i].getRestaurant().getLocationInfo().getAddress();
                String cuisines = zomatoCollections[j].getRestaurantsArray()[i].getRestaurant().getCuisines();

                //Print the restaurant information
                System.out.println(restaurantName);
                System.out.println("  " + address);
                System.out.println("  " + cuisines + "\n");
            }
        }
    }
}
