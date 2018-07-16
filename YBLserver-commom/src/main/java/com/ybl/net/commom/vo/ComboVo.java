package com.ybl.net.commom.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.ybl.net.commom.enums.StabLevelEnum;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class ComboVo implements Serializable {

	//private static final long serialVersionUID = 1L;

	private int cmId;
	
	private String sysVersion;
	
	private String luaVersion;
	
	private String webVersion;
	
	private int stablevel;
	
	private int createUser;
	
	private String username;
	
	private Timestamp createTime;

	public String getCreateTimeStr() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getCreateTime());
	}
	
	public String getStablevelName(){
		return StabLevelEnum.getByIndex(stablevel).getDescription();
	}
}
