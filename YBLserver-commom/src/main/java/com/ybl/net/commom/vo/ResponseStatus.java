package com.ybl.net.commom.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResponseStatus implements Serializable {
	//private static final long serialVersionUID = 1L;

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
	private Object data;

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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		StringBuffer d = new StringBuffer("");
		if(data != null &&  !("".equals(data))){
			
			d.append(",'data':" + this.data);
		}
		return "{'code':" + this.code + ",'msg':" + this.msg + d.toString() + "}";
	}
}
