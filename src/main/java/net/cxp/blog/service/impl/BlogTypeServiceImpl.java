package net.cxp.blog.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.cxp.blog.dao.BlogTypeMapper;
import net.cxp.blog.entity.BlogType;
import net.cxp.blog.service.BlogTypeService;

import org.springframework.stereotype.Service;

@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

	@Resource
	private BlogTypeMapper blogTypeMapper;

	@Override
	public List<BlogType> getBlogTypeData() {
		return blogTypeMapper.getBlogTypeData();
	}

	@Override
	public List<BlogType> listBlogType(Map<String, Object> map) {
		return blogTypeMapper.listBlogType(map);
	}

	@Override
	public int addBlogType(BlogType blogType) {
		return blogTypeMapper.addBlogType(blogType);
	}

	@Override
	public int updateBlogType(BlogType blogType) {
		return blogTypeMapper.updateBlogType(blogType);
	}

	@Override
	public int deleteBlogType(int id) {
		return blogTypeMapper.deleteBlogType(id);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return blogTypeMapper.getTotal(map);
	}

}
