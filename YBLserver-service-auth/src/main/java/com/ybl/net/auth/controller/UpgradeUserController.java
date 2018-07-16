package com.ybl.net.auth.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ybl.net.auth.service.impl.UpgradeUserServiceImpl;
import com.ybl.net.persist.database.model.user.UpgradeUser;

@RestController
//@RequestMapping("/api")
public class UpgradeUserController {
    @Resource
    private UpgradeUserServiceImpl upgradeUserService;

    @RequestMapping(value = "/all")
    public PageInfo<UpgradeUser> getALL(){
    	UpgradeUser user = new UpgradeUser();
        List<UpgradeUser> dicTypeList = upgradeUserService.getUpgradeUserByPage(user, 1, 2);
        return new PageInfo<UpgradeUser>(dicTypeList);
    }
    
    @RequestMapping(value = "/countPageByUserType")
    public Integer countPageByUserType(){
        int count = upgradeUserService.countPageByUserType(1);
        return count;
    }
    
    @RequestMapping(value = "/getByUsername")
    public UpgradeUser getByUsername(){
    	UpgradeUser user = upgradeUserService.getByUsername("zhangshi1");
        return user;
    }
}
