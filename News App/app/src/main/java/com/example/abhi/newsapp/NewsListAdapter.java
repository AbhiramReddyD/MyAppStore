package com.example.abhi.newsapp;

import android.content.Context;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NewsListAdapter extends ArrayAdapter<News> {

    private List<News> mNewsFeeds;
    private ArrayList<News> aux_NewsFeeds;

    NewsListAdapter(Context context, List<News> newsfeeds) {
        super(context, 0, newsfeeds);
        mNewsFeeds = newsfeeds;
        aux_NewsFeeds = new ArrayList<>();
        aux_NewsFeeds.addAll(mNewsFeeds);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.newslist_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView titleText =  listItemView.findViewById(R.id.article_title_text_view);
        assert currentNews != null;
        titleText.setText(currentNews.getArticle());

        TextView subtitleText = listItemView.findViewById(R.id.section_name_text_view);
        subtitleText.setText(currentNews.getSection());

        TextView dateText = listItemView.findViewById(R.id.date_published_text_view);
        dateText.setText(currentNews.getDate());

        return listItemView;
    }

    @Override
    public int getCount() {
        if (mNewsFeeds != null) {
            return mNewsFeeds.size();
        } else {
            return 0;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    void filter(String charText, List<News> newsfeeds) {
        charText = charText.toLowerCase(Locale.getDefault());
        newsfeeds.clear();
        if (charText.length() == 0) {
            newsfeeds.addAll(aux_NewsFeeds);
        } else {
            for (News news : aux_NewsFeeds) {
                if (charText.length() != 0 &&
                        news.getArticle().toLowerCase(Locale.getDefault()).contains(charText)) {
                    newsfeeds.add(news);
                } else if (charText.length() != 0 &&
                        news.getSection().toLowerCase(Locale.getDefault()).contains(charText)) {
                    newsfeeds.add(news);
                }
            }
        }
        notifyDataSetChanged();
    }
}