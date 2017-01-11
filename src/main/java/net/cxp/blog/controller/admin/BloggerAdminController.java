package net.cxp.blog.controller.admin;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.cxp.blog.entity.Blogger;
import net.cxp.blog.service.BloggerService;
import net.cxp.blog.util.CryptographyUtil;
import net.cxp.blog.util.DateUtil;
import net.cxp.blog.util.ResponseUtil;
import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description 管理员博主Controller层，需要身份认证
 * @author cxp
 * 
 */
@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController {

	@Resource
	private BloggerService bloggerService;

	// 查询博主信息
	@RequestMapping("/findBlogger")
	public String findBlogger(HttpServletResponse response) throws IOException {

		Blogger blogger = bloggerService.getBloggerData();
		JSONObject jsonObject = JSONObject.fromObject(blogger);
		ResponseUtil.write(response, jsonObject);

		return null;
	}

	// 修改博主信息
	@RequestMapping("/save")
	public String save(@RequestParam("imageFile") MultipartFile imageFile,
			Blogger blogger, HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {

		if (!imageFile.isEmpty()) {// 如果用户有传过照片，就更新
			String filePath = request.getServletContext().getRealPath("/");// 获取服务器根路径
			String imageName = DateUtil.getCurrentDateStr() + "."
					+ imageFile.getOriginalFilename().split("\\.")[1];
			imageFile.transferTo(new File(filePath + "static/userImages/"
					+ imageName));
			blogger.setImagename(imageName);
		}
		int resultTotal = bloggerService.updateBlogger(blogger);
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}

	// 修改博主密码
	@RequestMapping("/modifyPassword")
	public String modifyPassword(@RequestParam("password") String password,
			HttpServletResponse response) throws IOException {

		Blogger blogger = new Blogger();
		blogger.setPassword(CryptographyUtil.md5(password, "javacoder"));
		int resultTotal = bloggerService.updateBlogger(blogger);
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {

			result.put("success", true);

		} else {

			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}

	//退出登录
	@RequestMapping("/logout")
	public String  logout(){
		
		SecurityUtils.getSubject().logout();
		
		return "redirect:/login.jsp";
	}
}
