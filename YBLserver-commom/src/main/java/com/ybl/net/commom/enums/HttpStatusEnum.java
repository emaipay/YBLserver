package com.ybl.net.commom.enums;

public enum HttpStatusEnum {
	
	OK(200, "success"),
	NO_CONFIG_VERSION(206, "No config version"),
	UN_CHANGE(207, "Not change"),
	NOT_FOUND(208, "Not found");

	private int value;
	
	private String reasonPhrase;
	
	private HttpStatusEnum(int value, String reasonPhrase){
		this.value = value;
		this.reasonPhrase = reasonPhrase;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getReasonPhrase() {
		return reasonPhrase;
	}

	public void setReasonPhrase(String reasonPhrase) {
		this.reasonPhrase = reasonPhrase;
	}
}
