package com.ybl.net.persist.database.model.guldan;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义机器分类实体
 * @author 
 * @data 2017年7月3日
 */
@SuppressWarnings("serial")
@Setter
@Getter
public class UpgradeVmClassify implements Serializable {

	//private static final long serialVersionUID = 4806492460517858704L;

	private int id;
	
	/**
	 * 分类名称
	 */
	private String vmClassifyName;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 数据状态
	 */
	private int dataStatus;
}
