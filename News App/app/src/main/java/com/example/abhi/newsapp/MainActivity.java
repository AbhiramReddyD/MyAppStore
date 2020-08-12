package com.example.abhi.newsapp;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import butterknife.ButterKnife;
import butterknife.OnItemClick;


public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<News>> {

    public static final String LOG_TAG = MainActivity.class.getName();

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String THE_GUARDIAN_URL = "https://content.guardianapis.com/search?page-size=25&order-by=newest&api-key=test";
    private static final int NEWS_LOADER_ID = 1;
    private ListView mListView;
    private NewsListAdapter mAdapter;
    private ArrayList<News> newsArrayList;
    private TextView mNoText;
    private String mQuery;
    private View mInd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mInd = findViewById(R.id.load_indicator);

        if (savedInstanceState != null) {
            mQuery = savedInstanceState.getString("query");
        }

        newsArrayList = new ArrayList<>();
        mAdapter = new NewsListAdapter(this, newsArrayList);

        mListView = findViewById(R.id.listViewNewsFeeds);
        mListView.setAdapter(mAdapter);

        mNoText = findViewById(R.id.emptyView);
        mListView.setEmptyView(mNoText);

        if (QueryUtils.isInternetAccess(MainActivity.this)) {
            getLoaderManager().initLoader(NEWS_LOADER_ID, null, this);
        } else {
            mNoText.setText(R.string.noInternet);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem searchItem = menu.findItem(R.id.newsSearch);

        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.i(TAG, "onFocusChange");
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mQuery = query;
                Log.i(TAG, "onQueryTextSubmit | mQuery: " + mQuery);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String searchQuery) {
                Log.i(TAG, "onQueryTextChange | searchQuery: " + searchQuery);
                assert searchQuery != null;
                assert newsArrayList != null;
                if (QueryUtils.isInternetAccess(getBaseContext())) {
                    mAdapter.filter(searchQuery.trim(), newsArrayList);
                    mListView.invalidate();

                    String newFilter = !TextUtils.isEmpty(searchQuery) ? searchQuery : null;
                    Log.i(TAG, "newFilter: " + newFilter);
                    if (mQuery == null && newFilter == null) {
                        return true;
                    }
                    if (mQuery != null && mQuery.equals(newFilter)) {
                        return true;
                    }
                    mQuery = newFilter;
                    getLoaderManager().restartLoader(NEWS_LOADER_ID, null, MainActivity.this);
                } else {
                    Snackbar.make(searchView, R.string.barInternet, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    mNoText.setText(R.string.noInternet);
                }
                return true;
            }
        });

        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Log.i(TAG, "home");
            mListView.setEmptyView(mNoText);
            mNoText.setText(R.string.welcome);
            return true;
        } else if (id == R.id.newsSearch) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnItemClick(R.id.listViewNewsFeeds)
    public void onItemClick(AdapterView<?> parent, int position) {
        News currentArticle = mAdapter.getItem(position);
        Uri newsUri = Uri.parse(currentArticle.getUrl());
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);
        startActivity(websiteIntent);
    }

    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {
        Uri baseUri = Uri.parse(THE_GUARDIAN_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        mInd.setVisibility(View.VISIBLE);

        if (mQuery == null) {
            mQuery = "android";
        }
        Log.i(TAG, "onCreateLoader | mQuery: " + mQuery);
        uriBuilder.appendQueryParameter("q", mQuery);
        uriBuilder.appendQueryParameter("maxResults", "40");
        //
        Log.i(TAG, "onCreateLoader | uriBuilder.toString(): " + uriBuilder.toString());
        return new NewsListLoader(this, uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> dataNewsFeeds) {
        Log.i(TAG, "onLoadFinished");
        //
        mInd.setVisibility(View.GONE);
        //
        if (dataNewsFeeds != null && !dataNewsFeeds.isEmpty()) {
            mAdapter.addAll(dataNewsFeeds);
            newsArrayList.addAll(dataNewsFeeds);
        } else {
            mListView.setEmptyView(mNoText);
            mNoText.setText(getResources().getString(R.string.noNews));
        }
    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {
        Log.i(TAG, "onLoaderReset");
        mAdapter.clear();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState: " + mQuery);
        outState.putString("query", mQuery);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState: " + mQuery);
        mQuery = savedInstanceState.getString("query");
    }
}
