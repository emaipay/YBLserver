package com.ybl.net.persist.database.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.ybl.net.persist.database.BaseMapper;
import com.ybl.net.persist.database.model.user.UpgradeUser;

@Mapper
public interface UpgradeUserMapper extends BaseMapper<UpgradeUser>{

	// @Options(useGeneratedKeys=true, keyProperty="staff_id", keyColumn="staff_id")
	//public int add(UpgradeUser upgradeUser);
	
	@Delete("DELETE FROM upgrade_user WHERE username = #{username}")
	public int delUserByUsername(@Param("username") String username);
	
	@Select("SELECT * FROM upgrade_user uu WHERE uu.username = #{username}")
	public UpgradeUser getByUsername(String username);
	
	@SelectProvider(type=UpgradeUserSqlProvider.class,method="listPageByUserType")  
	public List<UpgradeUser> listPageByUserType(@Param("userType") int userType, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);
	
	@SelectProvider(type=UpgradeUserSqlProvider.class,method="countPageByUserType")  
	public int countPageByUserType(@Param("userType")int userType);
}
