package net.cxp.blog.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.cxp.blog.dao.BlogMapper;
import net.cxp.blog.entity.Blog;
import net.cxp.blog.service.BlogService;

@Service("blogService")
public class BlogServiceImpl implements BlogService {
	
	@Resource
	private BlogMapper blogMapper;

	@Override
	public List<Blog> getBlogData() {
	return blogMapper.getBlogData();
	}

	@Override
	public List<Blog> listBlog(Map<String, Object> map) {
		return blogMapper.listBlog(map);
	}

	@Override
	public long getTotal(Map<String, Object> map) {
            return blogMapper.getTotal(map);
	}

	@Override
	public Blog findById(Integer id) {
		return blogMapper.findById(id);
	}

	@Override
	public Integer update(Blog blog) {
		return blogMapper.update(blog);
	}

	@Override
	public Blog getPrevBlog(Integer id) {
		return blogMapper.getPrevBlog(id);
	}

	@Override
	public Blog getNextBlog(Integer id) {
		return blogMapper.getNextBlog(id);
	}

	@Override
	public Integer addBlog(Blog blog) {
		return blogMapper.addBlog(blog);
	}

	@Override
	public Integer deleteBlog(Integer id) {
		return blogMapper.deleteBlog(id);
	}

	@Override
	public Integer getBlogNumByTypeId(Integer typeId) {
		return blogMapper.getBlogNumByTypeId(typeId);
	}


}
