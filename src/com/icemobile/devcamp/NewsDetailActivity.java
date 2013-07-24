package com.icemobile.devcamp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class NewsDetailActivity extends FragmentActivity implements
		LoaderCallbacks<NewsDetailResult> {

	private TextView headline;
	private TextView tagline;
	private TextView bodyText;
	private String newsId;
	private NewsItemDetail newsItem;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_news_detail);

		headline = (TextView) findViewById(R.id.headline);
		tagline = (TextView) findViewById(R.id.tagline);
		bodyText = (TextView) findViewById(R.id.bodyText);
		newsId = getIntent().getStringExtra("itemId");
		getSupportLoaderManager().initLoader(0, null, this);
	}

	@Override
	public Loader<NewsDetailResult> onCreateLoader(int id, Bundle bundle) {
		return new NewsDetailLoader(this, newsId);
	}

	@Override
	public void onLoadFinished(Loader<NewsDetailResult> loader,
			NewsDetailResult result) {
		if (result.getException() == null) {
			this.newsItem = result.getDetailItem();
			headline.setText(newsItem.getHeadline());
			tagline.setText(newsItem.getTagline());
			bodyText.setText(newsItem.getBodytext());
		} else {
			Toast.makeText(this, result.getException().getLocalizedMessage(),
					Toast.LENGTH_SHORT).show();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.share, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.share) {
			shareNewsItem(newsItem);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onLoaderReset(Loader<NewsDetailResult> arg0) {

	}

	private void shareNewsItem(NewsItemDetail item) {
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_SUBJECT, item.getHeadline());
		sendIntent.putExtra(Intent.EXTRA_TEXT, item.getBodytext());
		sendIntent.setType("text/plain");
		startActivity(sendIntent);
	}
}