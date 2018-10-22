package com.photonInfotech.citiBankPOC.exception;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;

import com.photonInfotech.citiBankPOC.model.Account;

public class Response<T> extends Resources {
	private Date timeStamp;
	private boolean status;
	private HttpStatus httpStatus;
	private List<String> message;
	private Resource<Account> result;

	public Response(String message, boolean status, Date timeStamp, HttpStatus httpStatus) {
		this(Collections.singletonList(message), status, timeStamp, httpStatus);
	}

	public Response(boolean status, Date timeStamp, HttpStatus httpStatus, String... message) {
		this(Arrays.asList(message), status, timeStamp, httpStatus);
	}

	public Response(String message, boolean status, Date timeStamp, HttpStatus httpStatus, Resource<Account> result) {
		this(Collections.singletonList(message), status, timeStamp, httpStatus, result);
	}

	public Response() {

	}

	public Response(List<String> message, boolean status, Date timeStamp, HttpStatus httpStatus) {
		this.message = message;
		this.status = status;
		this.timeStamp = timeStamp;
		this.httpStatus = httpStatus;
	}

	public Response(List<String> message, boolean status, Date timeStamp, HttpStatus httpStatus,
			Resource<Account> result) {
		this.message = message;
		this.status = status;
		this.timeStamp = timeStamp;
		this.httpStatus = httpStatus;
		this.result = result;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Resource<Account> getResult() {
		return result;
	}

	public void setResult(Resource<Account> result) {
		this.result = result;
	}
}