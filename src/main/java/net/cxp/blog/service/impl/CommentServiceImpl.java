package net.cxp.blog.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import net.cxp.blog.dao.BlogMapper;
import net.cxp.blog.dao.CommentMapper;
import net.cxp.blog.entity.Comment;
import net.cxp.blog.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Resource
	private CommentMapper commentMapper;
	
	@Override
	public List<Comment> getCommentData(Map<String, Object> map) {
		return commentMapper.getCommentData(map);
	}

	@Override
	public int addComment(Comment comment) {
	return commentMapper.addComment(comment);
	}

	@Override
	public int update(Comment comment) {
		return commentMapper.update(comment);
	}

	@Override
	public int deleteCommentByBlogId(int id) {
		return commentMapper.deleteCommentByBlogId(id);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
	return commentMapper.getTotal(map);
	}

	@Override
	public int deleteComment(int id) {
		return commentMapper.deleteComment(id);
	}

}
