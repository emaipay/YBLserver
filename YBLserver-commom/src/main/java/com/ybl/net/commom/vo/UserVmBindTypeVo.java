package com.ybl.net.commom.vo;

import java.io.Serializable;

public class UserVmBindTypeVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 绑定类型ID
	 */
	private int id;
	
	/**
	 * 类型名称
	 */
	private String typeName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
