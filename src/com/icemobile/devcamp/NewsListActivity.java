package com.icemobile.devcamp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.icemobile.devcamp.adapter.NewsListAdapter;
import com.icemobile.devcamp.data.NewsItem;
import com.icemobile.devcamp.loader.NewsLoader;
import com.icemobile.devcamp.loader.NewsResult;

public class NewsListActivity extends FragmentActivity implements LoaderCallbacks<NewsResult>, OnItemClickListener {
	private NewsListAdapter adapter;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news_list);
		adapter = new NewsListAdapter(this);
		ListView listView = (ListView)findViewById(R.id.list);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		getSupportLoaderManager().initLoader(0, null, this);
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View clickedView, int position, long id) {
		final NewsItem newsItem = (NewsItem) adapter.getItem(position);
		String toastMessage = newsItem.getHeadline() + " selected";
		Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();

		final Intent intent = new Intent(this, NewsDetailActivity.class);
		intent.putExtra("itemId", newsItem.getId());
		startActivity(intent);
	}

	@Override
	public Loader<NewsResult> onCreateLoader(int id, Bundle args) {
		return new NewsLoader(getApplicationContext());
	}

	@Override
	public void onLoadFinished(Loader<NewsResult> loader, NewsResult result) {
		if(result.getException() == null) {
			adapter.setList(result.getItems());
		} else {
			Toast.makeText(this, result.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onLoaderReset(Loader<NewsResult> loader) {

	}
}
