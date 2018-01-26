package com.example;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZomatoCollectionTest {
    private ZomatoCollection zomatoCollection;

    @Before
    public void setup() throws Exception {
        Gson gson = new Gson();
        String url = "https://developers.zomato.com/api/v2.1/search?entity_id=685&entity_type=city&cuisines=73";
        final HttpResponse<String> stringHttpResponse = Unirest.get(url).header("user-key",
                ZomatoAPI.API_KEY).asString();
        if (stringHttpResponse.getStatus() == 200) {
            String Json = stringHttpResponse.getBody();
            zomatoCollection = gson.fromJson(Json, ZomatoCollection.class);
        }
    }

    @Test   //this method test whether total restaurant number is parsed successfully
    public void getResults_found() throws Exception {
        int totalNum = 29;
        assertEquals(totalNum,zomatoCollection.getResults_found());
    }

    @Test   //this method test whether restaurant start number is from 0
    public void getResults_start() throws Exception {
        int startNum = 0;
        assertEquals(startNum,zomatoCollection.getResults_start());
    }

    @Test   //this method test how many restaurant can be shown in one time
    public void getResult_end() throws Exception {
        int maxShownNum = 20;
        assertEquals(maxShownNum,zomatoCollection.getResults_shown());
    }

    @Test   //This method test whether the restaurant is delivering now
    public void getRestaurantsdelivering() throws Exception {
        int arrayNum = 0;
        assertEquals(arrayNum,zomatoCollection.getRestaurantsArray()[0].getRestaurant().getIs_delivering_now());
    }
}