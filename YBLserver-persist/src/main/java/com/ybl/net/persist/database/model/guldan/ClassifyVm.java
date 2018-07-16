package com.ybl.net.persist.database.model.guldan;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义分类机器实体
 * @author 
 * @data 2017年7月4日
 */
@SuppressWarnings("serial")
@Setter
@Getter
public class ClassifyVm implements Serializable {

//	private static final long serialVersionUID = -1807319821534038835L;

	private int id;
	
	private String innerCode;
	
	/**
	 * 所属自定义机器分类ID
	 */
	private int vmClassifyId;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 数据状态
	 */
	private int dataStatus;
}
