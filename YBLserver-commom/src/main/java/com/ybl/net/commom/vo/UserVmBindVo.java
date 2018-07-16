package com.ybl.net.commom.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class UserVmBindVo implements Serializable {

	//private static final long serialVersionUID = 1L;

	private int userId;
	
	private int vmId;
	
	private int vmType;
	
	private String sysVersion;
	
	private String luaVersion;
	
	private String webVersion;
	
	private String typeName;
	
	private String innerCode;
	
	private String mac;
	
	private String creator;
	
	private Timestamp createTime;

	public String getCreateTimeStr() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getCreateTime());
	}
}
