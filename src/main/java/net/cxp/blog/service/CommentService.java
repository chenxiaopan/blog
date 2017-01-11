package net.cxp.blog.service;

import java.util.List;
import java.util.Map;


import net.cxp.blog.entity.Comment;

public interface CommentService {

	
	List<Comment> getCommentData(Map<String, Object> map);

	//添加评论
	int addComment(Comment comment);

	//修改用户评论
	int update(Comment comment);

	//根据博客id删除评论,删除博客是连带删除
	int deleteCommentByBlogId(int id);
    
	//获得评论数
	Long getTotal(Map<String, Object> map);
    
	//删除评论
	int deleteComment(int id);

}
