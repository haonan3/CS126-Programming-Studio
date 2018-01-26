package com.example;

import java.util.ArrayList;
import java.util.List;

/***
 * This class is the first level of zomato restaurant information containrr.
 * ZomatoRestaurant is another class which contain more detail information of restaurants.
 */
public class ZomatoCollection {
    private int results_found;
    private int results_start;
    private int results_shown;
    private ZomatoRestaurant[] restaurants;

    public int getResults_found() {
        return results_found;
    }

    public int getResults_start() {
        return results_start;
    }

    public int getResults_shown() {
        return results_shown;
    }

    public ZomatoRestaurant[] getRestaurantsArray() {
        return restaurants;
    }
}
