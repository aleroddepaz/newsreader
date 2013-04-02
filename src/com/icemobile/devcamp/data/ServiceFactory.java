package com.icemobile.devcamp.data;

public class ServiceFactory {

	private final static NewsService newsService = new StaticNewService();
	
	public static NewsService getNewsService() {
		return newsService;
	}
	
}
