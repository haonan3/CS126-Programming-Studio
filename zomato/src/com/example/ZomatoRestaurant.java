package com.example;

import com.google.gson.Gson;

/***
 * This class is the second level of zomato restaurant information container.
 * The only method of this class is used to return all information of one restaurant.
 */
public class ZomatoRestaurant {
    private RestaurantInfo restaurant;

    public RestaurantInfo getRestaurant() {
        return restaurant;
    }
}
