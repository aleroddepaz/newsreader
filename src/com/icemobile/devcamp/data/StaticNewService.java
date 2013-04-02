package com.icemobile.devcamp.data;

import java.util.ArrayList;
import java.util.List;

public class StaticNewService {

	private List<NewsItem> newsItems = new ArrayList<NewsItem>();

	public List<NewsItem> getNewsItems() {
		return newsItems;
	}
}
