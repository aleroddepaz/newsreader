package com.icemobile.devcamp.data;

import java.util.List;
import java.util.Set;

import android.content.Context;

public interface NewsService {

	List<NewsItem> getNewsItems() throws DataException;
	NewsItemDetail getNewsItemDetails(String id) throws DataException;
	Set<String> getFavourites(Context context) throws DataException;
	Boolean isFavourite(Context context, String id) throws DataException;
	void markFavourite(Context context, String id) throws DataException;
}