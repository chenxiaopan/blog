package net.cxp.blog.controller.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.cxp.blog.entity.Comment;
import net.cxp.blog.service.CommentService;
import net.cxp.blog.util.DateJsonValueProcessor;
import net.cxp.blog.util.PageBean;
import net.cxp.blog.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description 管理员评论Controller层
 * @author cxp
 * @date 2017-1-10
 * 
 */
@Controller
@RequestMapping("/admin/comment")
public class CommentAdminController {

	@Resource
	private CommentService commentService;

	// 后台分页查询评论信息
	@RequestMapping("/listComment")
	public String listComment(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "state", required = false) String state,
			HttpServletResponse response) throws IOException {

		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("page", page);
		map.put("pageSize", pageBean.getPageSize());
		List<Comment> commentList = commentService.getCommentData(map);
		Long total = commentService.getTotal(map);

		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));

		JSONArray jsonArray = JSONArray.fromObject(commentList, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);

		ResponseUtil.write(response, result);

		return null;
	}

	// 评论审核
	@RequestMapping("/review")
	public String review(
			@RequestParam(value = "ids", required = false) String ids,
			@RequestParam(value = "state", required = false) Integer state,
			HttpServletResponse response) throws IOException {

		String[] idsStr = ids.split(",");
		JSONObject result = new JSONObject();
		for (int i = 0; i < idsStr.length; i++) {
			Comment comment = new Comment();
			// 设置commen的id
			comment.setId(Long.parseLong(idsStr[i]));
			comment.setState((long) state);
			// 更新评论状态
			commentService.update(comment);
		}

		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

	// 删除评论信息
	@RequestMapping("/deleteComment")
	public String deleteComment(
			@RequestParam(value = "ids", required = false) String ids,
			HttpServletResponse response) throws IOException {

		String[] idsStr = ids.split(",");
		for (int i = 0; i < idsStr.length; i++) {
			commentService.deleteComment(Integer.parseInt(idsStr[i]));
		}

		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

}
