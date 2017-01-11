package net.cxp.blog.realm;

import javax.annotation.Resource;

import net.cxp.blog.entity.Blogger;
import net.cxp.blog.service.BloggerService;
import net.cxp.blog.util.CryptographyUtil;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


public class MyRealm extends AuthorizingRealm {

	@Resource
	private BloggerService bloggerService;

	/**
	 * 为当前登录的用户授予角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// 这个个人博客项目是没有这一项的，因为就一个用户
		return null;

	}

	/**
	 * 认证回调函数，登录时使用
	 * 对前登录的用户进行身份验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {

		String username = (String) token.getPrincipal();// 获取用户名
		Blogger blogger = bloggerService.getByUsername(username);// 根据用户名从数据库中查询出博信息
         
		if (blogger != null) {
			System.out.println(blogger.getUsername()+" "+blogger.getPassword());
			SecurityUtils.getSubject().getSession()
					.setAttribute("currentUser", blogger);// 把当前用户存到session中
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
					blogger.getUsername(),CryptographyUtil.md5(blogger.getPassword(), "javacoder") , "MyRealm");
			return authenticationInfo;
		} else {

			return null;
		}
	}
}
