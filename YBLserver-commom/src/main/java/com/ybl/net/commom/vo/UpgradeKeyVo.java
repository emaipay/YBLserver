package com.ybl.net.commom.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UpgradeKeyVo implements Serializable {

	//private static final long serialVersionUID = 1L;

	private String publicKey;
	
	private String privateKey;
	
	private String uboxSysCurrentVersion;

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getUboxSysCurrentVersion() {
		return uboxSysCurrentVersion;
	}

	public void setUboxSysCurrentVersion(String uboxSysCurrentVersion) {
		this.uboxSysCurrentVersion = uboxSysCurrentVersion;
	}
}
