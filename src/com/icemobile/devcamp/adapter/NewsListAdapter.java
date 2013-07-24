package com.icemobile.devcamp.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.icemobile.devcamp.R;
import com.icemobile.devcamp.data.NewsItem;

public class NewsListAdapter extends BaseAdapter {

	private List<NewsItem> newsItems = new ArrayList<NewsItem>();
	private final Context context;

	public NewsListAdapter(final Context context) {
		this.context = context;
	}

	public void setList(final List<NewsItem> newsItems) {
		this.newsItems = newsItems;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return newsItems == null ? 0 : newsItems.size();
	}

	@Override
	public Object getItem(final int location) {
		return newsItems == null ? null : newsItems.get(location);
	}

	@Override
	public long getItemId(final int location) {
		return location;
	}

	@Override
	public View getView(int location, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.new_list_row, null);
		}
		final ImageView thumbnail = (ImageView) convertView
				.findViewById(R.id.thumbnail);
		final TextView headline = (TextView) convertView
				.findViewById(R.id.headline);

		final NewsItem item = (NewsItem) getItem(location);

		thumbnail.setImageResource(context.getResources().getIdentifier(
				item.getImage(), "drawable", context.getPackageName()));
		headline.setText(item.getHeadline());

		return convertView;
	}

}
