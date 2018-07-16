package com.ybl.net.persist.database.model.guldan;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户机器绑定实体类
 * @author 
 * @data 2017年5月18日
 */
@SuppressWarnings("serial")
@Setter
@Getter
public class UpgradeUserVmBind implements Serializable {
	//private static final long serialVersionUID = -1098225237041966771L;

	private int userId;
	
	private int vmId;
	
	private String innerCode;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 数据状态
	 */
	private int dataStatus;
}
