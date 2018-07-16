package com.ybl.net.commom.enums;

/**
 * 升级协议消息类型枚举
 * @author huanghaiping
 * @data 2017年4月26日
 */
public enum UpgradeMessageTypeEnum {

	UBOXSYSSTART("yblsysstart", "uboxsys启动检查"),//yblsysstart
	UBOXSCRIPT("yblscript", "检测LUA,WEBAPP 版本"),//yblscript
	UBOXLUA("ybllua", "LUA脚本更新成功"),
	UBOXWEB("yblweb", "WEB脚本更新成功");
	
	private String type;
	private String description;
	
	private UpgradeMessageTypeEnum(String type, String description) {
		this.type = type;
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
