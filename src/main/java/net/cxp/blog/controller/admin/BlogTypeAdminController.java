package net.cxp.blog.controller.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.cxp.blog.entity.BlogType;
import net.cxp.blog.service.BlogService;
import net.cxp.blog.service.BlogTypeService;
import net.cxp.blog.util.PageBean;
import net.cxp.blog.util.ResponseUtil;
import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description 管理员博客类别Controller层
 * @author cxp
 * 
 */
@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeAdminController {

	@Resource
	private BlogTypeService blogTypeService;

	@Resource
	private BlogService blogService;

	// 分页查询博客类型
	@RequestMapping("/listBlogType")
	public String listBlogType(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			HttpServletResponse response) throws IOException {

		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
        
		map.put("start", pageBean.getStart());
		map.put("page", page);
		map.put("pageSize", pageBean.getPageSize());
		List<BlogType> blogTypeList = blogTypeService.listBlogType(map);
		//获取总记录数
		Long total=blogTypeService.getTotal(map);
         
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(blogTypeList);
		result.put("rows", jsonArray);
		result.put("total", total);
		
		ResponseUtil.write(response, result);
		
		return null;
	}

	// 添加和更新博客类别
	@RequestMapping("/save")
	public String save(BlogType blogType, HttpServletResponse response)
			throws IOException {

		int resultTotal = 0;// 接收返回结果记录数
		if (blogType.getId() == null) {// 说明是第一次插入

			resultTotal = blogTypeService.addBlogType(blogType);
		} else {// 有id表示修改
			resultTotal = blogTypeService.updateBlogType(blogType);
		}

		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);

		}

		ResponseUtil.write(response, result);
		return null;
	}

	// 博客类别信息删除
	@RequestMapping("/delete")
	public String deleteBlogType(
			@RequestParam(value = "ids", required = false) String ids,
			HttpServletResponse response) throws IOException {

		String[] idsStr = ids.split(",");
		JSONObject result = new JSONObject();
		for (int i = 0; i < idsStr.length; i++) {
			int id = Integer.parseInt(idsStr[i]);
			if (blogService.getBlogNumByTypeId(id) > 0) {// 说明该类别下有博客
				result.put("exist", "该类别下有博客，不能删除！");
			} else {
				blogTypeService.deleteBlogType(id);

			}
		}

		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

}
