package com.icemobile.devcamp.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.icemobile.devcamp.data.DataException;
import com.icemobile.devcamp.data.NewsService;
import com.icemobile.devcamp.data.ServiceFactory;

public class NewsDetailLoader extends AsyncTaskLoader<NewsDetailResult> {

	private String itemId;
	private NewsDetailResult result;

	public NewsDetailLoader(Context context, String itemId) {
		super(context);
		this.itemId = itemId;
	}

	@Override
	public NewsDetailResult loadInBackground() {
		NewsService service = ServiceFactory.getNewsService();
		NewsDetailResult result = new NewsDetailResult();
		try {
			result.setDetailItem(service.getNewsItemDetails(itemId));
		} catch (DataException e) {
			result.setException(e);
		}
		return result;
	}

	@Override
	protected void onStartLoading() {
		if (this.result != null) {
			deliverResult(this.result);
		}

		if (takeContentChanged() || this.result == null) {
			forceLoad();
		}

	}

	@Override
	public void deliverResult(NewsDetailResult result) {
		if (this.result == null) {
			this.result = result;
		}
		if (isStarted()) {
			super.deliverResult(result);
		}
	}

}