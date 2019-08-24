package com.yangjie.springcloud.yangjiecloudapi.dao;

import com.yangjie.springcloud.yangjiecloudapi.entity.Resource;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * resource资源表对应的dao类
 * @author virtualspider
 *
 */
public interface ResourceDao {
	@Select("select * from resource")
	List<Resource> findAll();
}
