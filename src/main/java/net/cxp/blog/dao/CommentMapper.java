package net.cxp.blog.dao;

import java.util.List;
import java.util.Map;


import net.cxp.blog.entity.Comment;


public interface CommentMapper {
	
	//获取评论信息
	 List<Comment> getCommentData(Map<String, Object> map);
	
	//添加评论
	 int addComment(Comment comment);
	 
	 //修改用户评论
	 int update(Comment comment);
	 
	 //根据博客id删除评论
	int deleteCommentByBlogId(int id);
	
	//获得评论数
	Long getTotal(Map<String, Object> map);
	
	//删除评论
	int deleteComment(int id);
	
    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}