package com.example.abhi.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import java.util.List;

public class NewsListLoader extends AsyncTaskLoader<List<News>> {

    private static final String LOG_TAG = NewsListLoader.class.getName();

    private String mURL;

    NewsListLoader(Context context, String url) {
        super(context);
        this.mURL = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (mURL == null) {
            return null;
        }
        return QueryUtils.fetchArticleData(mURL);
    }
}