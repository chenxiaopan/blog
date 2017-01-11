package net.cxp.blog.dao;

import net.cxp.blog.entity.Blogger;


public interface BloggerMapper {
	
	//获取博主信息
	Blogger getBloggerData();
	
	//通过用户名查询博主
	public Blogger getByUsername(String username);
	
	//更新博主信息
	int  updateBlogger(Blogger blogger);
	
    int deleteByPrimaryKey(Long id);

    int insert(Blogger record);

    int insertSelective(Blogger record);

    Blogger selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Blogger record);

    int updateByPrimaryKey(Blogger record);
}