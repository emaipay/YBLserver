package com.ybl.net.commom.enums;

/**
 * 远程控制协议消息类型枚举
 * @author huanghaiping
 * @data 2017年4月26日
 */
public enum RemoteMessageTypeEnum {

	CMD_LS("cmdls", "ls 命令"),
	CMD_PULL("cmdpull", "取文件"),
	CMD_PUSH("cmdpush", "拿文件"),
	CMD_PMLIST("cmdpmlist", "列出手机装的所有app的包名"),
	CMD_KILL("cmdkill", "杀死应用"),
	CMD_CAT("cmdcat", "查看文件内容"),
	CMD_SCREENCAP("cmdscreencap", "截取屏幕"),
	CMD_INSTALL("cmdinstall", "安装APK"),
	CMD_REBOOT("cmdreboot", "重启机器"),
	CMD_DELF("cmddelf", "删除文件"),
	CMD_UNINSTALL("cmduninstall", "删除应用"),
	THIRDAPK("thirdapk", "第三方应用安装"),
	COLLECTINFO("collectinfo", "上传信息收集");
	
	private String type;
	private String description;
	
	private RemoteMessageTypeEnum(String type, String description) {
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
