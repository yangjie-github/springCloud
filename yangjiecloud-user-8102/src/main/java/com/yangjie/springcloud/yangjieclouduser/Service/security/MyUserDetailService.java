package com.yangjie.springcloud.yangjieclouduser.Service.security;

import com.yangjie.springcloud.yangjiecloudapi.dao.UserDao;
import com.yangjie.springcloud.yangjiecloudapi.dao.UserRoleDao;
import com.yangjie.springcloud.yangjiecloudapi.entity.Role;
import com.yangjie.springcloud.yangjiecloudapi.entity.User;
import com.yangjie.springcloud.yangjieclouduser.entity.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 配置springsecurity数据库管理的类
 * @author Administrator
 *
 */
@Component
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleDao userRoleDao;

	@Override
	public UserDetails loadUserByUsername(String username) {
			User user = userDao.findUserByUsername(username);
			// SecurityUser实现UserDetails并将SUser的Email映射为username
			if(user == null) {
				throw new AuthenticationServiceException("USER_NAME_NOT_EXIST");
			}
			Long userId = user.getId();
			List<Role> roles = userRoleDao.getRolesByUserId(userId);
			return new MyUserDetails(user,roles);
	}

}
