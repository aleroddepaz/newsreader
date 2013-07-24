package com.icemobile.devcamp.data;

public class DataException extends RuntimeException {

	private static final long serialVersionUID = 513339257350180321L;
	private final String message;

	public DataException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}