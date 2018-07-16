package com.ybl.net.commom.enums;

/**
 * 用户类型枚举
 * @author huanghaiping
 * @data 2017年5月18日
 */
public enum UserTypeEnum {

	ADMIN(1, "admin"),
	DEVELOP(2, "开发商"),
	OPERAT(3, "operat");
	
	private int type;
	private String description;
	
	private UserTypeEnum(int type, String description) {
		this.type = type;
		this.description = description;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
