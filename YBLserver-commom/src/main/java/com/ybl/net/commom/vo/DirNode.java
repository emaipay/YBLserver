package com.ybl.net.commom.vo;

/**
 * 远程售货机目录节点
 * @author 
 * @data 2017年7月3日
 */
public class DirNode {
	
	/**
	 * 节点名称（目录名称）
	 */
	public String name;
	
	/**
	 * 是否为父节点
	 */
	public String isParent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
}
