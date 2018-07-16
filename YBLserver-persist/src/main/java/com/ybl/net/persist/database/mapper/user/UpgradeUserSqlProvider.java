package com.ybl.net.persist.database.mapper.user;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class UpgradeUserSqlProvider {
	
	public  String countPageByUserType(Map<String, Object> para) {	
		Integer userType = (Integer) para.get("userType");
		return new SQL(){{  
	           SELECT("count(id)");  
	           FROM("upgrade_user");  
	           if(userType>0){  
	              WHERE("user_type="+userType);  
	           }  
	       }}.toString();  
	}
	
	/*<select id="listPageByUserType" resultMap="baseResultMap">
	SELECT * FROM upgrade_user
	<if test="userType > 0">
		WHERE user_type = #{userType} 
	</if>
	LIMIT #{startIndex}, #{pageSize}
</select>*/

	
	public  String listPageByUserType(Map<String, Object> para) {	
		Integer userType = (Integer) para.get("userType");
		return new SQL(){{  
	           SELECT("*");  
	           FROM("upgrade_user");  
	           if(userType>0){  
	              WHERE("user_type="+userType);  
	           }  
	       }}.toString()+" LIMIT"+para.get("startIndex")+","+para.get("pageSize");  
	}
}
