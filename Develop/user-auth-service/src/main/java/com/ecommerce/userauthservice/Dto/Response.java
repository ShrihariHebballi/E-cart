package com.ecommerce.userauthservice.Dto;

public class Response {

	private String status;
	private String msg;

	public Response() {
		super();
	}

	public Response(String status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
