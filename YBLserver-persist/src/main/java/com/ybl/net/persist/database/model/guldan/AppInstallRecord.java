package com.ybl.net.persist.database.model.guldan;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * APP安装记录实体
 * @author
 * @data 2017年7月4日
 */
@SuppressWarnings("serial")
@Setter
@Getter
public class AppInstallRecord implements Serializable {
	
	private int id;
	
	/**
	 * 安装应用的机器编号
	 */
	private String innerCode;
	
	
	/**
	 * 第三方应用ID
	 */
	private int appId;
	
	/**
	 * 安装结果（成功OR失败）
	 */
	private int status;
	
	/**
	 * 安装用户
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
