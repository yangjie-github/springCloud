package com.yangjie.springcloud.yangjieclouduser.controller;

import com.yangjie.springcloud.yangjiecloudapi.dao.UserDao;
import com.yangjie.springcloud.yangjiecloudapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 这个是一个用于测试的controller
 * 测试在不对其他业务代码进行任何修改的情况下，能否通过在数据库中的配置，实现对不同的链接进行不同的权限的操控的功能
 * @author virtualspider
 *
 */
@Controller
@ResponseBody
public class SecurityController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/")
	public String home() {
		return "这个页面每个人都可以访问user服务1";
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "这个页面登陆后可以访问";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "这个页面只有admin角色才能访问";
	}

	@RequestMapping("/getUser/{name}")
	public User getUser(@PathVariable String name) {
		User userByUsername = userDao.findUserByUsername(name);
		return userByUsername;
	}
}
