package com.yangjie.springcloud.yangjieclouduser.config.security;

import com.yangjie.springcloud.yangjiecloudapi.dao.ResourceDao;
import com.yangjie.springcloud.yangjiecloudapi.dao.RoleResourceDao;
import com.yangjie.springcloud.yangjiecloudapi.entity.Resource;
import com.yangjie.springcloud.yangjiecloudapi.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * 系统启动时将资源和权限的对应信息关联起来
 * @author virtualspider
 *
 */
@Service
public class CustomInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

	@Autowired
	private ResourceDao resourceDao;
	
	@Autowired
	private RoleResourceDao roleResourceDao;
	
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	
	/**
	 * 在Web服务器启动时，提取系统中的所有权限。
	 * 先找出所有的资源url列表
	 * 然后遍历每个资源url，循环执行如下操作
	 * 		根据匹配关系找到对应的角色列表
	 * 		将匹配的角色列表封装，存入map
	 * 
	 */
	@PostConstruct//  被@PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行,init()方法之前执行。
	private void loadResourceDefine() {   //一定要加上@PostConstruct注解
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		
		List<Resource> resourceList = resourceDao.findAll();
		for(Resource resource : resourceList) {
			List<Role> roles = roleResourceDao.findRolesByResourceUrl(resource.getId());
			String url = resource.getUrl();
			Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
			for(Role role:roles) {
				ConfigAttribute ca = new SecurityConfig(role.getName());
				atts.add(ca);
			}
			resourceMap.put(url, atts);
		}
		System.out.println(resourceMap.toString());
	
	}
		
	/**
	 * 根据URL，找到相关的权限配置
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		System.out.println("nwuidhwuiehdfu");
		// object 是一个URL，被用户请求的url。
		FilterInvocation filterInvocation = (FilterInvocation) object;
		if (resourceMap == null) {
			loadResourceDefine();
		}
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			 RequestMatcher requestMatcher = new AntPathRequestMatcher(resURL);
			    if(requestMatcher.matches(filterInvocation.getHttpRequest())) {
				return resourceMap.get(resURL);
			}
		}
 
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return new ArrayList<ConfigAttribute>();
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
