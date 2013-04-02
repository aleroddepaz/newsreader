package com.icemobile.devcamp.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StaticNewService implements NewsService {

	private List<NewsItem> newsItems = new ArrayList<NewsItem>();
	
	public StaticNewService() {
		for(int i=0; i < 10; i++) {
			newsItems.add(new NewsItem("Headline" + i, null));
		}
	}

	@Override
	public List<NewsItem> getNewsItems() {
		return Collections.unmodifiableList(newsItems);
	}
}
