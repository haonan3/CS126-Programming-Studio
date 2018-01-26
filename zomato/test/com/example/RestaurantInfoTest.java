package com.example;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantInfoTest {
    private RestaurantInfo restaurantInfo;
    private String ONE_ZOMATO_RESTAURANT = "{\n" +
            "        \"R\": {\n" +
            "          \"res_id\": 17317281\n" +
            "        },\n" +
            "        \"apikey\": \"7e979f79627ab65f71edda399f137eb1\",\n" +
            "        \"id\": \"17317281\",\n" +
            "        \"name\": \"Dos Reales\",\n" +
            "        \"url\": \"https://www.zomato.com/champaign-il/dos-reales-champaign?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\n" +
            "        \"location\": {\n" +
            "          \"address\": \"1407 N Prospect Ave, Champaign 61820\",\n" +
            "          \"locality\": \"Champaign\",\n" +
            "          \"city\": \"Champaign\",\n" +
            "          \"city_id\": 685,\n" +
            "          \"latitude\": \"40.1298000000\",\n" +
            "          \"longitude\": \"-88.2582000000\",\n" +
            "          \"zipcode\": \"61820\",\n" +
            "          \"country_id\": 216,\n" +
            "          \"locality_verbose\": \"Champaign, Champaign\"\n" +
            "        },\n" +
            "        \"switch_to_order_menu\": 0,\n" +
            "        \"cuisines\": \"Mexican\",\n" +
            "        \"average_cost_for_two\": 10,\n" +
            "        \"price_range\": 1,\n" +
            "        \"currency\": \"$\",\n" +
            "        \"offers\": [],\n" +
            "        \"thumb\": \"\",\n" +
            "        \"user_rating\": {\n" +
            "          \"aggregate_rating\": \"4.2\",\n" +
            "          \"rating_text\": \"Very Good\",\n" +
            "          \"rating_color\": \"5BA829\",\n" +
            "          \"votes\": \"381\"\n" +
            "        },\n" +
            "        \"photos_url\": \"https://www.zomato.com/champaign-il/dos-reales-champaign/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop\",\n" +
            "        \"menu_url\": \"https://www.zomato.com/champaign-il/dos-reales-champaign/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop\",\n" +
            "        \"featured_image\": \"\",\n" +
            "        \"has_online_delivery\": 0,\n" +
            "        \"is_delivering_now\": 0,\n" +
            "        \"deeplink\": \"zomato://restaurant/17317281\",\n" +
            "        \"has_table_booking\": 0,\n" +
            "        \"events_url\": \"https://www.zomato.com/champaign-il/dos-reales-champaign/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1\",\n" +
            "        \"establishment_types\": []\n" +
            "      }";
    @Before
    public void setup() throws Exception {
        Gson gson = new Gson();
         restaurantInfo= gson.fromJson(ONE_ZOMATO_RESTAURANT, RestaurantInfo.class);
        }

    @Test   //check whether the resID can be parsed
    public void getResID() throws Exception {
        int resID = 17317281;
        assertEquals(resID,restaurantInfo.getR().getRes_id());
    }

    @Test   //check the restaurant ID
    public void getId() throws Exception {
        String restaurantID = "17317281";
        assertEquals(restaurantID,restaurantInfo.getId());
    }

    @Test   //check whether the object LovationInfo can be parsed
    public void getLocationInfo() throws Exception {
        int cityID = 685;
        assertEquals(cityID,restaurantInfo.getLocationInfo().getCity_id());
    }

    @Test   //this method is used to check cuisines
    public void getCuisines() throws Exception {
        String cuisines = "Mexican";
        assertEquals(cuisines,restaurantInfo.getCuisines());
    }

    @Test
    public void getVerage_cost_for_two() throws Exception {
        int costOfTwo = 10;
        assertEquals(costOfTwo,restaurantInfo.getVerage_cost_for_two());
    }

    @Test
    public void getPrice_range() throws Exception {
        int priceRange = 1;
        assertEquals(priceRange,restaurantInfo.getPrice_range());
    }

    @Test
    public void getCurrency() throws Exception {
        String currency = "$";
        assertEquals(currency,restaurantInfo.getCurrency());
    }

    @Test   //check whether the offers can be parsed
    public void getOffers() throws Exception {
        int offersArrayLen = 0;
        assertEquals(offersArrayLen,restaurantInfo.getOffers().length);
    }

    @Test
    public void getThumb() throws Exception {
        String thumb = "";
        assertEquals(thumb,restaurantInfo.getThumb());
    }

    @Test
    public void getUserAggregateRating() throws Exception {
        String userAggregateRating = "4.2";
        assertEquals(userAggregateRating,restaurantInfo.getUser_rating().getAggregate_rating());
    }

    @Test
    public void getPhotos_url() throws Exception {
        String photosUrl = "https://www.zomato.com/champaign-il/dos-reales-champaign/photos?utm_source=api_basic" +
                "_user&utm_medium=api&utm_campaign=v2.1#tabtop";
        assertEquals(photosUrl,restaurantInfo.getPhotos_url());
    }

    @Test
    public void getMenu_url() throws Exception {
        String menuUrl = "https://www.zomato.com/champaign-il/dos-reales-champaign/menu?utm_source=api_basic_" +
                "user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop";
        assertEquals(menuUrl,restaurantInfo.getMenu_url());
    }

    @Test
    public void getFeatured_image() throws Exception {
        String image = "";
        assertEquals(image,restaurantInfo.getFeatured_image());
    }
}