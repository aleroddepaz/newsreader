package com.icemobile.devcamp.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.icemobile.devcamp.data.DataException;
import com.icemobile.devcamp.data.NewsService;
import com.icemobile.devcamp.data.ServiceFactory;

public class NewsLoader extends AsyncTaskLoader<NewsResult> {

	private NewsResult result;

	public NewsLoader(Context context) {
		super(context);
	}

	@Override
	public NewsResult loadInBackground() {
		NewsService service = ServiceFactory.getNewsService();
		NewsResult result = new NewsResult();
		try {
			result.setItems(service.getNewsItems());
		} catch (DataException exception) {
			result.setException(exception);
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
	public void deliverResult(NewsResult result) {
		if (this.result == null) {
			this.result = result;
		}
		if (isStarted()) {
			super.deliverResult(result);
		}
	}

}