package com.ybl.net.commom.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpgradeVmVo implements Serializable {

	private static final long serialVersionUID = -238267223811233661L;
	
	private int id;
	
	/**
	 * 机器标识
	 */
	private String innerCode;
	
	/**
	 * 机器mac
	 */
	private String mac;
	
	/**
	 * sys版本
	 */
	private String sysVersion;

	/**
	 * lua版本
	 */
	private String luaVersion;
	
	/**
	 * webapp版本
	 */
	private String webVersion;
	
	/**
	 * 版本组合ID
	 */
	private int versionComboId;
	
	private String creator;
	
	private Timestamp createTime;
	
	/**
	 * 机器类型ID
	 */
	private int vmTypeId;
	
	private String typeName;
	
	private String typeNumber;
	
	public String getCreateTimeStr() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getCreateTime());
	}

}
