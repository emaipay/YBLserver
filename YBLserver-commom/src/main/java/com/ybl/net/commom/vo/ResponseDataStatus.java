package com.ybl.net.commom.vo;

import java.io.Serializable;

public class ResponseDataStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 返回代码
	 */
	private int code;
	
	/**
	 * 返回信息
	 */
	private String msg;
	
	/**
	 * 返回数据
	 */
	private String data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
