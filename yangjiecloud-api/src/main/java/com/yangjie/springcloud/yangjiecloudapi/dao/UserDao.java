package com.yangjie.springcloud.yangjiecloudapi.dao;

import com.yangjie.springcloud.yangjiecloudapi.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * 用户表相关的dao类
 * @author virtualspider
 *
 */
public interface UserDao {

	@Select("select * from user where username=#{username}")
	public User findUserByUsername(String username);
	
}
