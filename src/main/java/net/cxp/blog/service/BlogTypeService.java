package net.cxp.blog.service;

import java.util.List;
import java.util.Map;

import net.cxp.blog.entity.BlogType;

public interface BlogTypeService {

	public List<BlogType> getBlogTypeData();

	public List<BlogType> listBlogType(Map<String, Object> map);

	public int addBlogType(BlogType blogType);

	public int updateBlogType(BlogType blogType);

	public int deleteBlogType(int id);

	public Long getTotal(Map<String, Object> map);


}
