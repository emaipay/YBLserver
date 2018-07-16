package com.ybl.net.commom.vo;

import java.io.Serializable;

public class UpgradeVersionVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String innerCode;
	
	private String uboxSysCurrentVersion;

	public String getInnerCode() {
		return innerCode;
	}

	public void setInnerCode(String innerCode) {
		this.innerCode = innerCode;
	}

	public String getUboxSysCurrentVersion() {
		return uboxSysCurrentVersion;
	}

	public void setUboxSysCurrentVersion(String uboxSysCurrentVersion) {
		this.uboxSysCurrentVersion = uboxSysCurrentVersion;
	}
}
