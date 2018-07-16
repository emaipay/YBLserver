package com.ybl.net.commom.enums;

/**
 * 升级消息类型
 * @author huanghaiping
 * @data 2017年3月29日
 */
public enum UpgradeTypeEnum {
	
	UBOXSYS(1, "UBOXSYS"),
	LUA(2, "LUA"),
	WEBAPP(3, "WEBAPP");
	
	private int index;
	private String description;
	
	private UpgradeTypeEnum(int index, String description) {
		this.index = index;
		this.description = description;
	}
	
	public static UpgradeTypeEnum getByIndex(int index){
		UpgradeTypeEnum[] enums =  UpgradeTypeEnum.values();
		for(UpgradeTypeEnum e:enums) {
			if(e.getIndex() == index)
				return e;
		}
		return null;
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
}
