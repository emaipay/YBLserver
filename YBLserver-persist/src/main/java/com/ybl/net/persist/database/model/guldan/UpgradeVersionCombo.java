package com.ybl.net.persist.database.model.guldan;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * 版本组合实体
 * @author 
 * @data 2017年4月11日
 */
@SuppressWarnings("serial")
@Setter
@Getter
public class UpgradeVersionCombo implements Serializable {

	//private static final long serialVersionUID = -5820820865586070905L;

	private int id;
	
	/**
	 * sys版本号Id
	 */
	private int sysVersionId;
	
	/**
	 * lua版本号Id
	 */
	private int luaVersionId;
	
	/**
	 * webapp版本号Id
	 */
	private int webVersionId;
	
	/**
	 * 机器类型
	 */
	private int vmTypeId;
	
	/**
	 * 稳定级别，0默认，1为较差，2为差，3为一般，4为好，5为非常好
	 */
	private int stablevel;
	
	/**
	 * 创建人
	 */
	private int createUser;
	
	private String username;
	
	private Timestamp createTime;
	
}
