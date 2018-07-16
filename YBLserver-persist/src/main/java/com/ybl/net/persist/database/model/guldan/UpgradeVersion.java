package com.ybl.net.persist.database.model.guldan;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.ybl.net.commom.enums.UpgradeTypeEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * 升级版本实体
 */
@SuppressWarnings("serial")
@Setter
@Getter
public class UpgradeVersion implements Serializable {
	//private static final long serialVersionUID = 4283720588850472726L;

	private int id;
	
	private String versionNumber;
	
	/**
	 * 消息类型，1为sys，2为webapp，3为lua
	 */
	private int packageType;
	
	/**
	 * 包存放地址
	 */
	private String url;
	
	/**
	 * 公钥
	 */
	private String publicKey;
	
	/**
	 * 私钥
	 */
	private String privateKey;
	
	/**
	 * 包md5值
	 */
	private String md5val;
	
	/**
	 * 包sha256值
	 */
	private String sha256val;
	
	private int vmTypeId;
	
	private String creator;
	
	private Timestamp createTime;
	
	/**
	 * 描述
	 */
	private String description;

	public String getPackageTypeName() {
		UpgradeTypeEnum e = UpgradeTypeEnum.getByIndex(packageType);
		if(e != null) {
			return e.getDescription();
		}
		return null;
	}
	
	public String getCreateTimeStr() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getCreateTime());
	}
}
