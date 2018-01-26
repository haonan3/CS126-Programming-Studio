package com.example;

/***
 * This class is the third level of zomato restaurant information container.
 * All of variables in this method will correspond to one items in zomato.
 * R, LocationInfo and UserRating are three classes which contain more detail information of one restaurant.
 */
public class RestaurantInfo {
    private R R;
    private String apikey;
    private String id;
    private String name;
    private String url;
    private LocationInfo location;
    private int switch_to_order_menu;
    private String cuisines;
    private int average_cost_for_two;
    private int price_range;
    private String currency;
    private int [] offers;
    private String thumb;
    private UserRating user_rating;
    private String photos_url;
    private String menu_url;
    private String featured_image;
    private int has_online_delivery;
    private int is_delivering_now;
    private String deeplink;
    private int has_table_booking;
    private String events_url;
    private int[] establishment_types;


    public R getR() {
        return R;
    }

    public String getApikey() {
        return apikey;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public LocationInfo getLocationInfo() {
        return location;
    }

    public int getSwitch_to_order_menu() {
        return switch_to_order_menu;
    }

    public String getCuisines() {
        return cuisines;
    }

    public int getVerage_cost_for_two() {
        return average_cost_for_two;
    }

    public int getPrice_range() {
        return price_range;
    }

    public String getCurrency() {
        return currency;
    }

    public int[] getOffers() {
        return offers;
    }

    public String getThumb() {
        return thumb;
    }

    public UserRating getUser_rating() {
        return user_rating;
    }

    public String getPhotos_url() {
        return photos_url;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public String getFeatured_image() {
        return featured_image;
    }

    public int getHas_online_delivery() {
        return has_online_delivery;
    }

    public int getIs_delivering_now() {
        return is_delivering_now;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public int getHas_table_booking() {
        return has_table_booking;
    }

    public String getEvents_url() {
        return events_url;
    }

    public int[] getEstablishment_types() {
        return establishment_types;
    }
}
