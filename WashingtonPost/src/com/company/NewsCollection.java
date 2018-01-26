package com.company;

    /*
    "status": "ok",
    "source": "the-washington-post",
    "sortBy": "top",
    "articles": [{
     */


public class NewsCollection {


        public String status;
        public String source;
        public String top;
        public NewsArticle[] articles;

// in one empty line control + return to reacte getter automatically
    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getTop() {
        return top;
    }

    public NewsArticle[] getArticles() {
        return articles;
    }
}


