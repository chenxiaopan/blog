package net.cxp.blog.service;

import net.cxp.blog.entity.Blogger;

public interface BloggerService {

	public Blogger getBloggerData();

	public Blogger getByUsername(String username);

	public int updateBlogger(Blogger blogger);

}
