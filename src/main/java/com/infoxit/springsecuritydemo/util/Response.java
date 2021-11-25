package com.infoxit.springsecuritydemo.util;


public class Response {

	
	private String message;
	
	private Object data;
	
	private boolean status;
	
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(String message, Object data, boolean status) {
		super();
		this.message = message;
		this.data = data;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
