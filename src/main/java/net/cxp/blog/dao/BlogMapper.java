package net.cxp.blog.dao;

import java.util.List;
import java.util.Map;

import net.cxp.blog.entity.Blog;


public interface BlogMapper {
	
	// 获取博客信息，根据日期月份分组查询，只是将博客按年月分类，并没有博客的详细信息
	public List<Blog> getBlogData();
	
	// 分页查询博客
	List<Blog> listBlog(Map<String, Object> map);
	
	//获取总记录数
	public Long getTotal(Map<String, Object> map);
	
	//根据id获取博客
	public Blog findById(Integer id);
	
	//更新博客信息
	public Integer update(Blog blog);
	
	//获取上一篇博客
	public Blog getPrevBlog(Integer id);
	
	//获取下一篇博客
	public Blog getNextBlog(Integer id);
	
	//添加博客
	public Integer addBlog(Blog blog);
	
	//删除博客信息
	public Integer deleteBlog(Integer id);
	
	//根据博客类型的id查询该类型下的博客数量
	Integer getBlogNumByTypeId(Integer typeId);
	
	
    int deleteByPrimaryKey(Long id);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);
}