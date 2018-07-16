package com.ybl.net.commom.enums;

/**
 * 稳定级别枚举
 * @author huanghaiping
 * @data 2017年5月18日
 */
public enum StabLevelEnum {

	DEFAULT(0, "默认"),
	NOT_STABLE(1, "不稳定"),
	STABLE(2, "稳定");
	
	private int index;
	private String description;
	
	private StabLevelEnum(int type, String description) {
		this.index = type;
		this.description = description;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static StabLevelEnum getByIndex(int index){
		StabLevelEnum[] enums =  StabLevelEnum.values();
		for(StabLevelEnum e:enums) {
			if(e.getIndex() == index)
				return e;
		}
		return null;
	}
}
