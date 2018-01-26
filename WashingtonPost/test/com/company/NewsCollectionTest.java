package com.company;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewsCollectionTest {
    private NewsCollection newsCollection;
    public static final String JSON_FOR_ARTICLE_COLLECTION = "{\n" +
            "\"status\": \"ok\",\n" +
            "\"source\": \"the-washington-post\",\n" +
            "\"sortBy\": \"top\",\n" +
            "\"articles\": [\n" +
            "{\n" +
            "\"author\": \"Leonard Shapiro, Mark Berman, Katie Zezima, Leonard Shapiro, Mark Berman, Katie Zezima\",\n" +
            "\"title\": \"‘Once the storm starts, law enforcement cannot save you’: Fla. governor issues stern warning ahead of Irma\",\n" +
            "\"description\": \"Although the storm's track has shifted west, it still remains a deadly threat to all of southern Florida.\",\n" +
            "\"url\": \"https://www.washingtonpost.com/news/post-nation/wp/2017/09/08/hurricane-irma-churns-over-the-bahamas-on-collision-course-with-florida/\",\n" +
            "\"urlToImage\": \"https://img.washingtonpost.com/pbox.php?url=http://img.washingtonpost.com/news/post-nation/wp-content/uploads/sites/23/2017/09/irma2.jpg&w=1484&op=resize&opt=1&filter=antialias&t=20170517\",\n" +
            "\"publishedAt\": \"2017-09-09T15:00:00Z\"\n" +
            "},\n" +
            "{\n" +
            "\"author\": \"Jason Samenow, Greg Porter, Jason Samenow, Greg Porter\",\n" +
            "\"title\": \"Dangerous Hurricane Irma bears down on Florida, its brunt targeting the Keys to Tampa\",\n" +
            "\"description\": \"If the storm reaches its full potential, it could be one of the worst in Florida's history.\",\n" +
            "\"url\": \"https://www.washingtonpost.com/news/capital-weather-gang/wp/2017/09/09/dangerous-hurricane-irma-bears-down-on-florida-its-brunt-targeting-the-keys-to-tampa/\",\n" +
            "\"urlToImage\": \"https://img.washingtonpost.com/pbox.php?url=http://img.washingtonpost.com/blogs/capital-weather-gang/files/2017/09/GOES14022017252whk4YQ.jpg&w=1484&op=resize&opt=1&filter=antialias&t=20170517\",\n" +
            "\"publishedAt\": \"2017-09-09T17:00:00Z\"\n" +
            "},\n" +
            "{\n" +
            "\"author\": null,\n" +
            "\"title\": \"Everything you need to know about Hurricane Irma\",\n" +
            "\"description\": \"Hurricane Irma is the strongest storm on record outside the Caribbean and Gulf of Mexico, and it's tracking toward the Southeast U.S.\",\n" +
            "\"url\": \"https://www.washingtonpost.com/graphics/2017/national/hurricane-irma-updates/\",\n" +
            "\"urlToImage\": \"https://www.washingtonpost.com/graphics/2017/national/hurricane-irma-updates/img/IRMASat842amSaturday.jpg\",\n" +
            "\"publishedAt\": \"2017-09-06T17:00:00Z\"\n" +
            "},\n" +
            "{\n" +
            "\"author\": \"Brady Dennis, Darryl Fears, Brady Dennis, Darryl Fears\",\n" +
            "\"title\": \"Florida governor has ignored climate change risks, critics say\",\n" +
            "\"description\": \"In the absence of state leadership, local governments have tried to plan for rising seas and other problems.\",\n" +
            "\"url\": \"https://www.washingtonpost.com/national/health-science/florida-governor-has-ignored-climate-change-risks-critics-say/2017/09/08/04a8c60a-94a0-11e7-aace-04b862b2b3f3_story.html\",\n" +
            "\"urlToImage\": \"https://img.washingtonpost.com/rf/image_1484w/2010-2019/WashingtonPost/2017/09/08/Health-Environment-Science/Images/844170196.jpg?t=20170517\",\n" +
            "\"publishedAt\": \"2017-09-08T11:16:00Z\"\n" +
            "},\n" +
            "{\n" +
            "\"author\": \"Anthony Faiola, Lindsey Bever, Andrew deGrandpre, Kristine Phillips, Anthony Faiola, Lindsey Bever, Andrew deGrandpre, Kristine Phillips\",\n" +
            "\"title\": \"Jose, still a dangerous Category 4 hurricane, threatens second blow to Irma-ravaged islands\",\n" +
            "\"description\": \"In Irma’s trail, emotional pleas about isolated, hard-hit islands, including some where food and water were running low.\",\n" +
            "\"url\": \"https://www.washingtonpost.com/news/worldviews/wp/2017/09/08/hurricane-jose-threatens-a-second-blow-to-caribbean-islands-devastated-by-irma/\",\n" +
            "\"urlToImage\": \"https://img.washingtonpost.com/rf/image_1484w/2010-2019/Wires/Images/2017-09-08/Getty/AFP_S807F.jpg?t=20170517\",\n" +
            "\"publishedAt\": \"2017-09-09T16:38:00Z\"\n" +
            "},\n" +
            "{\n" +
            "\"author\": \"WashPostPR, WashPostPR\",\n" +
            "\"title\": \"The Washington Post lifts paywall for Hurricane Irma coverage\",\n" +
            "\"description\": \"Unlimited digital access to weather coverage and important safety information temporarily available.\",\n" +
            "\"url\": \"https://www.washingtonpost.com/pr/wp/2017/09/08/the-washington-post-lifts-paywall-for-hurricane-irma-coverage/\",\n" +
            "\"urlToImage\": \"https://img.washingtonpost.com/pbox.php?url=http://img.washingtonpost.com/pr/wp-content/uploads/2016/01/POSTFRONT011451935333.jpg&w=1484&op=resize&opt=1&filter=antialias&t=20170517\",\n" +
            "\"publishedAt\": \"2017-09-08T07:14:00Z\"\n" +
            "},\n" +
            "{\n" +
            "\"author\": \"Marc Fisher, Perry Stein, Marc Fisher, Perry Stein\",\n" +
            "\"title\": \"As Irma approaches, fear is in the water, spreading with new and viral efficiency\",\n" +
            "\"description\": \"If the only thing we have to fear is fear itself, maybe we should all be afraid. Hurricane Irma approaches the U.S. as a long list of anxieties grow.\",\n" +
            "\"url\": \"https://www.washingtonpost.com/national/as-irma-approaches-fear-is-in-the-water-spreading-with-new-and-viral-efficiency/2017/09/09/797e7d3c-94c1-11e7-aace-04b862b2b3f3_story.html\",\n" +
            "\"urlToImage\": \"https://img.washingtonpost.com/rf/image_1484w/2010-2019/WashingtonPost/2017/09/09/National-Politics/Images/2017-09-09T133141Z_1771395004_RC1E013E7BE0_RTRMADP_3_STORM-IRMA-3968.jpg?t=20170517\",\n" +
            "\"publishedAt\": \"2017-09-09T15:59:00Z\"\n" +
            "},\n" +
            "{\n" +
            "\"author\": \"Joel Achenbach, Joel Achenbach\",\n" +
            "\"title\": \"There’s no place to hide from Irma in South Florida, and these folks aren’t trying\",\n" +
            "\"description\": \"Some defiant souls plan to stand their ground and ride out the massive hurricane at home, even as neighbors flee to the north.\",\n" +
            "\"url\": \"https://www.washingtonpost.com/national/theres-no-place-to-hide-from-irma-in-south-florida-and-these-folks-arent-trying/2017/09/08/5ec042e6-94bc-11e7-8754-d478688d23b4_story.html\",\n" +
            "\"urlToImage\": \"https://img.washingtonpost.com/rf/image_1484w/2010-2019/WashingtonPost/2017/09/08/Others/Images/2017-09-08/Irma003.JPG?t=20170517\",\n" +
            "\"publishedAt\": \"2017-09-08T12:32:00Z\"\n" +
            "},\n" +
            "{\n" +
            "\"author\": null,\n" +
            "\"title\": \"Live look from Hollywood Beach, Fla. as Hurricane Irma approaches\",\n" +
            "\"description\": \"After slamming into Cuba's northern coast, Hurricane Irma is churning toward South Florida.\",\n" +
            "\"url\": \"http://www.washingtonpost.com/posttv/c/live/Live+look+from+Hollywood+Beach%2C+Fla.+as+Hurricane+Irma+approaches/59b3dea8e4b092307d257a5d\",\n" +
            "\"urlToImage\": \"http://s3.amazonaws.com/posttv-thumbnails-prod/09-09-2017/t_1504960155310_name_843841768.jpg\",\n" +
            "\"publishedAt\": null\n" +
            "},\n" +
            "{\n" +
            "\"author\": null,\n" +
            "\"title\": \"Analysis | How big is Hurricane Irma\",\n" +
            "\"description\": \"At about 400 miles wide, Irma is significantly larger and, at least for now, a bit more powerful than Hurricane Andrew, which devastated parts of South Florida in 1992.\",\n" +
            "\"url\": \"https://www.washingtonpost.com/graphics/2017/national/how-big-is-hurricane-irma/\",\n" +
            "\"urlToImage\": \"https://www.washingtonpost.com/r/2010-2019/WashingtonPost/2017/09/06/National-Enterprise/Graphics/2300-promo-irma-big.jpg\",\n" +
            "\"publishedAt\": \"2017-09-07T02:45:00Z\"\n" +
            "}\n" +
            "]\n" +
            "}";

    @Before
    public void setUp() throws Exception {
         Gson gson = new Gson();
        //newsCollection = gson.fromJson(JSON_FOR_ARTICLE_COLLECTION,NewsCollection.class);

        //don't forget this newsCollection
        //use option + return can auto repair
        String url = "https://newsapi.org/v1/articles?source=the-washington-post&sortBy=top&apiKey=" +
                NewsAPI.API_KEY;

        final HttpResponse<String> stringHttpResponse = Unirest.get(url).asString();

        if(stringHttpResponse.getStatus() == 200){
            String Json = stringHttpResponse.getBody();
            newsCollection = gson.fromJson(Json,NewsCollection.class);
        }else {
            newsCollection = gson.fromJson(JSON_FOR_ARTICLE_COLLECTION,NewsCollection.class);
        }


    }

    @Test
    public void getStatus() throws Exception {
    }

    @Test
    public void getSource() throws Exception {
    }

    @Test
    public void getTop() throws Exception {
    }

    @Test
    public void getArticles() throws Exception {
     assertEquals("Karoun Demirjian, Karoun Demirjian", newsCollection.getArticles()[0].getAuthor() );
    }

}