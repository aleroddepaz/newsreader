package com.icemobile.devcamp.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import android.content.Context;

public class StaticNewService implements NewsService {

	private List<NewsItem> newsItems = new ArrayList<NewsItem>();
	
	public StaticNewService() {
		for(int i=0; i < 10; i++) {
			newsItems.add(new NewsItem("Headline" + i, null));
		}
	}

	@Override
	public List<NewsItem> getNewsItems() throws DataException {
		return Collections.unmodifiableList(newsItems);
	}

	@Override
	public NewsItemDetail getNewsItemDetails(String id) throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getFavourites(Context context) throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isFavourite(Context context, String id) throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void markFavourite(Context context, String id) throws DataException {
		// TODO Auto-generated method stub
		
	}
}
