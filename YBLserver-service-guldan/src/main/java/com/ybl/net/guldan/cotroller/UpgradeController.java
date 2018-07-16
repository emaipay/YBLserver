package com.ybl.net.guldan.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ybl.net.guldan.client.UpgradeUserServiceClient;
import com.ybl.net.persist.database.model.user.UpgradeUser;

@RestController
//@RequestMapping("/api")
public class UpgradeController {
	
	@Autowired
	private UpgradeUserServiceClient upgradeUserServiceClient;
   
    @RequestMapping(value = "/test")
    public UpgradeUser test(){
    	return upgradeUserServiceClient.getByUsername();
    }
  
}
