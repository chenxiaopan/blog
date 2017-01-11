package net.cxp.blog.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.cxp.blog.entity.Blog;
import net.cxp.blog.entity.BlogType;
import net.cxp.blog.entity.Blogger;
import net.cxp.blog.entity.Link;
import net.cxp.blog.service.BlogService;
import net.cxp.blog.service.BlogTypeService;
import net.cxp.blog.service.BloggerService;
import net.cxp.blog.service.LinkService;
import net.cxp.blog.util.ResponseUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description 管理员系统controller层
 * @author cxp
 * @date 2017-1-09
 */
@Controller
@RequestMapping("/admin/system")
public class SystemAdminController {

	@Resource
	private BloggerService bloggerService;
	
	@Resource
	private LinkService linkService;
	
	@Resource
	private BlogTypeService blogTypeService;
	
	@Resource
	private BlogService blogService;
	
	//刷新系统缓存
	@RequestMapping("/refreshSystemCache")
	public String refreshSystemCache(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		ServletContext application=RequestContextUtils.getWebApplicationContext(request).getServletContext();
		
		//获取博主信息
		Blogger blogger=bloggerService.getBloggerData();
	    blogger.setPassword(null);
	    application.setAttribute("blogger", blogger);
	    
	    //获取友情链接信息
	    List<Link> linkList=linkService.getLinkData();
	    application.setAttribute("linkList", linkList);
	    
	    //获取博客类别信息
	    List<BlogType> blogTypeList=blogTypeService.getBlogTypeData();
	    application.setAttribute("blogTypeList", blogTypeList);
	    
	    //获取博客信息，按照时间分类的
	    List<Blog> blogTimeList=blogService.getBlogData();
	    application.setAttribute("blogList",blogTimeList);
	    
	    JSONObject result=new JSONObject();
	    result.put("success",true);
	    ResponseUtil.write(response, result);
	    
	    return null;
	}
	
}
