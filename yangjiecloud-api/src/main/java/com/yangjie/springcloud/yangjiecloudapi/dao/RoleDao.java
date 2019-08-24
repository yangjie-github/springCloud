package com.yangjie.springcloud.yangjiecloudapi.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 角色表的中间类
 * @author virtualspider
 *
 */
public interface RoleDao {

	/**
	 * 查出所有的角色列表
	 * @return
	 */
	@Select("select * from role")
	public  List<String> findAll();

}
