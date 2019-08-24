package com.yangjie.springcloud.yangjiecloudapi.dao;

import com.yangjie.springcloud.yangjiecloudapi.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户角色中间表的dao类
 * @author Administrator
 *
 */
public interface UserRoleDao {

	/**
	 * 通过用户id获取角色信息
	 * @param userId
	 * @return
	 */
	@Select("SELECT r.id,r.name FROM user_role ur\r\n" + 
			"LEFT JOIN role r ON ur.`role_id`=r.`id`\r\n" + 
			"WHERE ur.id=#{userId}")
	public List<Role> getRolesByUserId(Long userId);
	
}
