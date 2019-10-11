package org.apz.curso.servlet.api.bean;

import java.io.Serializable;

public class ApiResponse implements Serializable {
	
	private static final long serialVersionUID = -1583082647944747361L;
	
	public boolean success;
	public String message;
	public String error;
	
	public ApiResponse() {
		super();
	}
	public ApiResponse(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	
	public ApiResponse(boolean success, String message, String error) {
		super();
		this.success = success;
		this.message = message;
		this.error = error;
	}
	public boolean isSucces() {
		return success;
	}
	public void setSucces(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
	
	
}
