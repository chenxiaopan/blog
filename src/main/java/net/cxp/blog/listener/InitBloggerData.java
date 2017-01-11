package net.cxp.blog.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.cxp.blog.entity.Blog;
import net.cxp.blog.entity.BlogType;
import net.cxp.blog.entity.Blogger;
import net.cxp.blog.entity.Link;
import net.cxp.blog.service.BlogService;
import net.cxp.blog.service.BlogTypeService;
import net.cxp.blog.service.BloggerService;
import net.cxp.blog.service.LinkService;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class InitBloggerData implements ServletContextListener,
		ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		InitBloggerData.applicationContext = applicationContext;
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println(applicationContext);
		// 先获取servlet上下文
		ServletContext application = servletContextEvent.getServletContext();

		// 根据spring上下文获取bloggerService这个bean
		BloggerService bloggerService = (BloggerService) applicationContext
				.getBean("bloggerService");
		// 获取博主信息
		Blogger blogger = bloggerService.getBloggerData();
		// 由于密码也获取到了，比较敏感，而且也不需要，所以把密码清空掉
		blogger.setPassword(null);
		// 将博主信息存入application域
		application.setAttribute("blogger", blogger);

		// 同上，获取友情链接信息
		LinkService linkService = (LinkService) applicationContext
				.getBean("linkService");
		List<Link> linkList = linkService.getLinkData();
		application.setAttribute("linkList", linkList);

		// 同上，获取博客类别信息
		BlogTypeService blogTypeService = (BlogTypeService) applicationContext
				.getBean("blogTypeService");
		List<BlogType> blogTypeList = blogTypeService.getBlogTypeData();
		application.setAttribute("blogTypeList", blogTypeList);

		// 同上，获取博客信息,按照时间分类的
		BlogService blogService = (BlogService) applicationContext
				.getBean("blogService");
		List<Blog> blogTimeList = blogService.getBlogData();
		application.setAttribute("blogTimeList", blogTimeList);
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub

	}
}
