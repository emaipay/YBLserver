package com.ybl.net.persist.database.model.user;

import java.io.Serializable;
import java.sql.Timestamp;

import com.ybl.net.persist.database.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * guldan注册用户（管理员、开发商和运营人员）
 * 用户的基本信息保存在TPA系统，此系统只保留一些必要的信息
 * @data 2018年4月26日
 */
@SuppressWarnings("serial")
@Setter
@Getter
public class UpgradeUser extends BaseEntity   implements Serializable  {
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 用户类型（管理员、开发商、运营人员，见UserTypeEnum）
	 */
	private Integer userType;
	
	// SELECT Id,username,user_type,merchant_key,create_time,data_status  FROM upgrade_user LIMIT ?
	
	/**
	 * 商户密钥（开发商才有）
	 */
	private String merchantKey;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 数据状态
	 */
	private int dataStatus;
	
}
