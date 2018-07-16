package com.ybl.net.auth.service.impl;

import java.lang.reflect.Field;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ybl.net.auth.service.UpgradeUserService;
import com.ybl.net.commom.vo.PageVo;
import com.ybl.net.persist.database.base.AbstractService;
import com.ybl.net.persist.database.mapper.user.UpgradeUserMapper;
import com.ybl.net.persist.database.model.user.UpgradeUser;

import redis.clients.jedis.JedisCluster;

@Service
public class UpgradeUserServiceImpl extends AbstractService<UpgradeUser> implements UpgradeUserService {

	@Autowired
	private JedisCluster jedisCluster;
	
	@Resource
	private UpgradeUserMapper upgradeUserMapper;

	public int add(UpgradeUser upgradeUser) {
		return upgradeUserMapper.insertSelective(upgradeUser);
	}

	@Cacheable(value = "user_page", key = "#userType+#pageIndex")
	public PageVo<UpgradeUser> listPageByUserType(int userType, int pageIndex) {
		PageVo<UpgradeUser> pageVo = new PageVo<>(pageIndex);
		int count = upgradeUserMapper.countPageByUserType(userType);
		pageVo.setTotalRecort(count);
		List<UpgradeUser> list = upgradeUserMapper.listPageByUserType(userType, pageVo.getStartRecordIndex(),
				pageVo.getPageSize());
		pageVo.setEntrys(list);
		
		return pageVo;
	}

	@Cacheable(value = "user", key = "#username")
	public UpgradeUser getByUsername(String username) {
		return upgradeUserMapper.getByUsername(username);
	}

	@CacheEvict(value = "user", key="#username")
	public int delUserByUsername(String username) {
		return upgradeUserMapper.delUserByUsername(username);
	}

	public List<UpgradeUser> getUpgradeUserByPage(UpgradeUser user, int page, int size) {
		// user 是实体类名称
		Field fields[] = user.getClass().getDeclaredFields();
		String[] names = new String[fields.length];
		Object[] values = new Object[fields.length];

		try {
			Field.setAccessible(fields, true);
			for (int i = 0; i < names.length; i++) {
				// 参数名
				names[i] = fields[i].getName();
				// 参数值
				values[i] = fields[i].get(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//多条件查询
		return this.selectByEqFields(names, values, page, size);
	}

	public static void main(String[] args) {
		UpgradeUser user = new UpgradeUser();
		user.setDataStatus(1);
		user.setUsername("5435345");
		Field fields[] = user.getClass().getDeclaredFields();
		String[] name = new String[fields.length];
		Object[] value = new Object[fields.length];

		try {
			Field.setAccessible(fields, true);
			for (int i = 0; i < name.length; i++) {
				name[i] = fields[i].getName();
				System.out.println(name[i] + "-> ");
				value[i] = fields[i].get(user);
				System.out.println(value[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int countPageByUserType(int userType) {
		return upgradeUserMapper.countPageByUserType(userType);
	}

}
