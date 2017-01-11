package net.cxp.blog.dao;

import java.util.List;
import java.util.Map;

import net.cxp.blog.entity.BlogType;


public interface BlogTypeMapper {
	
	// 根据id查找博客类型信息
	public BlogType findById(Integer id);
	
	//获得博客类型信息
	public List<BlogType> getBlogTypeData();
    
    //分页查询博客类型信息
	public List<BlogType> listBlogType(Map<String, Object> map);
	
	//添加博客类型
	int addBlogType(BlogType blogType);
	
	//更新博客类型
	int updateBlogType(BlogType blogType);
	
	//删除博客类型
	int deleteBlogType(int id);
	
	// 获取总记录数
    public Long getTotal(Map<String, Object> map);
	
    int deleteByPrimaryKey(Long id);

    int insert(BlogType record);

    int insertSelective(BlogType record);

    BlogType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlogType record);

    int updateByPrimaryKey(BlogType record);
}