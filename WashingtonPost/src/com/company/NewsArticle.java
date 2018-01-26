package com.company;

/*
*
{
"author":"Leonard Shapiro, Mark Berman, Katie Zezima, Leonard Shapiro, Mark Berman, Katie Zezima",
"title":"‘Once the storm starts, law enforcement cannot save you’: Fla. governor issues stern warning ahead of Irma",
"description":"Although the storm's track has shifted west, it still remains a deadly threat to all of southern Florida.",
"url":"https://www.washingtonpost.com/news/post-nation/wp/2017/09/08/hurricane-irma-churns-over-the-bahamas-on-collision-course-with-florida/",
"urlToImage":"https://img.washingtonpost.com/pbox.php?url=http://img.washingtonpost.com/news/post-nation/wp-content/uploads/sites/23/2017/09/irma2.jpg&w=1484&op=resize&opt=1&filter=antialias&t=20170517",
"publishedAt":"2017-09-09T15:00:00Z"
}
*
*
*
* */


public class NewsArticle {
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publicshedAt;


    //only necessary if you add a defualt constructors
    public NewsArticle(){
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublicshedAt() {
        return publicshedAt;
    }
}
