package com.icemobile.devcamp.loader;

import java.util.List;

import com.icemobile.devcamp.data.DataException;
import com.icemobile.devcamp.data.NewsItem;

public class NewsResult {

	private DataException exception;
	private List<NewsItem> items;

	public DataException getException() {
		return exception;
	}

	public void setException(DataException exception) {
		this.exception = exception;
	}

	public List<NewsItem> getItems() {
		return items;
	}

	public void setItems(List<NewsItem> items) {
		this.items = items;
	}

}