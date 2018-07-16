package com.ybl.net.persist.database.model.guldan;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * 机器号实体类
 * @author 
 * @data 2017年7月24日
 */
@Setter
@Getter
public class VmNumber {

	private int id;
	
	/**
	 * 机器编号
	 */
	private String innerCode;
	
	/**
	 * 使用状态（0默认未使用，已1使用）
	 */
	private int useStatus;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
}
