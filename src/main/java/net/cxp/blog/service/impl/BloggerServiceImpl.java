package net.cxp.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.cxp.blog.dao.BloggerMapper;
import net.cxp.blog.entity.Blogger;
import net.cxp.blog.service.BloggerService;

@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {
	
	@Resource
	private BloggerMapper bloggerMapper;

	@Override
	public Blogger getBloggerData() {
	   return bloggerMapper.getBloggerData();
	}

	@Override
	public Blogger getByUsername(String username) {
     	return 	bloggerMapper.getByUsername(username);
	}

	@Override
	public int updateBlogger(Blogger blogger) {
		return bloggerMapper.updateBlogger(blogger);
	}

}
