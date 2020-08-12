package com.example.abhi.newsapp;

class News {

    private String mArticle;
    private String mSection;
    private String mDate;
    private String mUrl;

    News(String webTitle, String sectionName, String webPublicationDate, String webUrl) {
        mArticle = webTitle;
        mSection = sectionName;
        mDate = webPublicationDate;
        mUrl = webUrl;
    }

    String getArticle() {
        return mArticle;
    }

    String getSection() {
        return mSection;
    }

    String getDate() {
        return mDate;
    }

    String getUrl() {
        return mUrl;
    }
}