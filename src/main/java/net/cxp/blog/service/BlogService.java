package net.cxp.blog.service;

import java.util.List;
import java.util.Map;

/**
 * @Description 博客Service接口
 * @author cxp
 * @date 2017-1-03
 *
 */
import net.cxp.blog.entity.Blog;

public interface BlogService {

	//根据日期分类查询博客
	List<Blog> getBlogData();
    
	//分页查询博客
	List<Blog> listBlog(Map<String, Object> map);

	//获取总记录数
	long getTotal(Map<String, Object> map);
   
	//根据id获取博客
	public Blog findById(Integer id);
	
	//更新博客信息
	public Integer update(Blog  blog);
	
	//获取上一篇博客
	public Blog getPrevBlog(Integer id);
	
	//获取下一篇博客
	public Blog getNextBlog(Integer id);
	
	//添加博客
	public Integer  addBlog(Blog blog);
	
	//删除博客信息
	public Integer deleteBlog(Integer id);
	
	//根据博客类型的id查询该类型下的博客数量
	public Integer getBlogNumByTypeId(Integer id);
}
