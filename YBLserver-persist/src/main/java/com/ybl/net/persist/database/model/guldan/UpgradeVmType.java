package com.ybl.net.persist.database.model.guldan;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * 机器类型
 * @author 
 * @data 2017年5月18日
 */
@SuppressWarnings("serial")
@Setter
@Getter
public class UpgradeVmType implements Serializable {
	
	//private static final long serialVersionUID = -3582856927410791712L;

	private int id;
	
	/**
	 * 类型名称
	 */
	private String typeName;
	
	/**
	 * 类型编号
	 */
	private String typeNumber;
	
	/**
	 * 创建人ID（用户表ID）
	 */
	private int userId;
	
	/**
	 * 创建人用户名
	 */
	private String username;
	
	/**
	 * 机型照片
	 */
	private String imgUrl;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 数据状态
	 */
	private int dataStatus;
	
	public String getCreateTimeStr() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getCreateTime());
	}

}
