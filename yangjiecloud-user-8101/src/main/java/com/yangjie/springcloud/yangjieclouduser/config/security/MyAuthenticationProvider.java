package com.yangjie.springcloud.yangjieclouduser.config.security;

import com.yangjie.springcloud.yangjieclouduser.Service.security.MyUserDetailService;
import com.yangjie.springcloud.yangjieclouduser.entity.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 自定义用户名和密码验证
 * @author Administrator
 *
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private MyUserDetailService myUserDetailService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		MyUserDetails user = (MyUserDetails) myUserDetailService.loadUserByUsername(username);
		if(user == null) {
			throw new AuthenticationServiceException("USER_NAME_NOT_EXIST");
		}
		
		//加密过程在这里体现
		if(!password.equals(user.getPassword())) {
			throw new AuthenticationServiceException("PASSWORD_ERROR");
		}
		
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
