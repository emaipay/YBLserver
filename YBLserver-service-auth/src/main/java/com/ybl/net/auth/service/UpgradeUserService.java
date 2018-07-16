package com.ybl.net.auth.service;

import java.util.List;

import com.ybl.net.commom.vo.PageVo;
import com.ybl.net.persist.database.model.user.UpgradeUser;

public interface UpgradeUserService{
	
	int add(UpgradeUser upgradeUser);
	
	PageVo<UpgradeUser> listPageByUserType(int userType, int pageIndex);
	
	UpgradeUser getByUsername(String username);
	
	int delUserByUsername(String username);
	
	public List<UpgradeUser> getUpgradeUserByPage(UpgradeUser user, int page, int size);
	
	int countPageByUserType(int userType);

}
