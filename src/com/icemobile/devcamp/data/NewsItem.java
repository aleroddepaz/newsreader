package com.icemobile.devcamp.data;

public class NewsItem {

	public NewsItem(String headline, String image) {
		super();
		this.headline = headline;
		this.image = image;
	}

	private String headline;
	private String image;

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
