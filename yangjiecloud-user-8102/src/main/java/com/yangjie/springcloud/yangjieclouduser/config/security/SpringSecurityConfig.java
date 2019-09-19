package com.yangjie.springcloud.yangjieclouduser.config.security;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * springsecurity的自定义配置类
 * @author Administrator
 *
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	@Autowired
//	private MyUserDetailService myUserDetailService;
	
	@Autowired
    private MyAuthenticationProvider provider;//自定义验证
	@Autowired
	private MyAuthenticationFailureHandler myAuthenticationFailureHandler;
	@Autowired
	private ValidateCodeFilter validateCodeFilter;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring().antMatchers("/js/**","/css/**","/images/**","/getUser/**");//对于这些静态文件，忽略拦截
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//之前添加验证码校验
		http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class);
		http
			.authorizeRequests()//访问首页不需要权限，其他页面需要权限
				.antMatchers("/", "/code/image").permitAll().anyRequest().authenticated().and()
			.logout()//退出不需要权限
				.permitAll().and()
			.formLogin()//支持表单登陆
				.and()
			.csrf()//关闭默认的csrf认证
				.disable();
		http.addFilterAt(userAuthenticationFilterBean(), UsernamePasswordAuthenticationFilter.class);
	}

	private UserAuthenticationFilter userAuthenticationFilterBean() throws Exception {
		UserAuthenticationFilter userAuthenticationFilter = new UserAuthenticationFilter();
		userAuthenticationFilter.setAuthenticationManager(super.authenticationManager());
		//认证失败handler
		userAuthenticationFilter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);
		//添加请求成功的handler
//		userAuthenticationFilter.setAuthenticationSuccessHandler(loginSuccessHandler);
		return userAuthenticationFilter;
	}
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.inMemoryAuthentication()//设置一个内存中的用户密码，早期的版本不需要设置密码登陆，springsecurity5之后需要
//				.passwordEncoder(passwordEncoder).withUser("admin")
//				.password(passwordEncoder.encode("123456")).roles("ADMIN")
//				.and()
//				.passwordEncoder(passwordEncoder).withUser("zhangsan")
//				.password(passwordEncoder.encode("123456")).roles("USER");
		auth.authenticationProvider(provider);

		//指定密码加密所使用的加密器为passwordEncoder()
		//需要将密码加密后写入数据库 
//		auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder);
		//不删除凭据，以便记住用户
		auth.eraseCredentials(false);
	}
	
	/**
	 * 手动在拦截器中配置注册一个单例的bean对象，避免每次都重新生成
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
}
