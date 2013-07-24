package com.icemobile.devcamp.loader;

import com.icemobile.devcamp.data.DataException;
import com.icemobile.devcamp.data.NewsItemDetail;

public class NewsDetailResult {

	private DataException exception;
	private NewsItemDetail detailItem;

	public DataException getException() {
		return exception;
	}

	public void setException(DataException exception) {
		this.exception = exception;
	}

	public NewsItemDetail getDetailItem() {
		return detailItem;
	}

	public void setDetailItem(NewsItemDetail detailItem) {
		this.detailItem = detailItem;
	}

}