package com.ybl.net.guldan.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
//import com.github.pagehelper.PageInfo;
//import com.ybl.net.persist.database.model.user.UpgradeUser;
import com.ybl.net.persist.database.model.user.UpgradeUser;

@FeignClient(name = "service-auth")
public interface UpgradeUserServiceClient {
	@RequestMapping(method = RequestMethod.POST, value = "/all", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	PageInfo<UpgradeUser> getALL();
	
	@RequestMapping(method = RequestMethod.POST, value = "/countPageByUserType", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	Integer countPageByUserType();
	
	@RequestMapping(method = RequestMethod.POST, value = "/getByUsername", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	UpgradeUser getByUsername();
}
