package com.ybl.net.persist.database.model.guldan;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * 第三方应用APP实体
 * @author Fred Cheng
 * @data 2017年7月4日
 */
@SuppressWarnings("serial")
@Setter
@Getter
public class ThirdPartyApp implements Serializable {

	//private static final long serialVersionUID = -5168462548663516516L;

	private int id;
	
	/**
	 * APP名称
	 */
	private String appName;
	
	/**
	 * 版本号
	 */
	private String versionNumber;
	
	/**
	 * 创建人用户名
	 */
	private String username;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 数据状态
	 */
	private int dataStatus;
}
