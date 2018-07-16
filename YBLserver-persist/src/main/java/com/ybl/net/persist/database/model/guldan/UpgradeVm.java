package com.ybl.net.persist.database.model.guldan;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * 机器实体
 * @author 
 * @data 2017年3月30日
 */
@SuppressWarnings("serial")
@Setter
@Getter
public class UpgradeVm implements Serializable {

	//private static final long serialVersionUID = -4401962340050039484L;

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
	
	/**
	 * 机器类型ID
	 */
	private int vmTypeId;
	
	/**
	 * 删除标志，0默认有效，1无效
	 */
	private int deleteMark;
	
	private String creator;
	
	private Timestamp createTime;
	
	public String getCreateTimeStr() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getCreateTime());
	}

}
