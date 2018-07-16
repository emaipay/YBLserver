package com.ybl.net.persist.database.model.guldan;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * 版本设计记录实体
 */
@SuppressWarnings("serial")
@Setter
@Getter
public class UpgradeRecord implements Serializable {
	
//	private static final long serialVersionUID = 6610111770026836083L;

	private int id;
	
	/**
	 * 机器标识
	 */
	private String innerCode;
	
	/**
	 * 包版本ID
	 */
	private int versionId;
	
	/**
	 * 版本组合ID
	 */
	private int versionComboId;

	/**
	 * 升级类型，1为UBOXSYS，2为WEBAPP，3为LUA
	 */
	private int upgradeType;
	
	/**
	 * 是否正在使用该版本组合
	 */
	private int usered;
	
	/**
	 * 更新状态码
	 */
	private int resultCode ;
	
	private Timestamp createTime;
	
	private Timestamp lastUpdateTime;

}
