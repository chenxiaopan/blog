package net.cxp.test;

import java.util.List;

import javax.annotation.Resource;

import net.cxp.blog.entity.Blog;
import net.cxp.blog.lucene.BlogIndex;
import net.cxp.blog.service.BlogService;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMyBatis {

	private static Logger logger = Logger.getLogger(TestMyBatis.class);

	@Resource
	BlogService blogService;

	@Test
	public void test1() {
		List<Blog> blogList = blogService.getBlogData();
		// JSON.toJSONString(blogList)格式化输出对象信息，不然只会打印对象的地址
		logger.info(JSON.toJSONString(blogList));
	}

	//建立lucene的索引文件，不要重复测试，否则会建立重复的索引，会搜索出重复项
	@Test
	public void test2() throws Exception {
           
		BlogIndex blogIndex = new BlogIndex();
		List<Blog> blogList = blogService.listBlog(null);
		System.out.println(blogList.size());
		for (Blog blog : blogList) {
			blog.setContentNoTag(blog.getContent());
			System.out.println(blog.getId()+"-->"+blog.getTitle()+"-->"+blog.getReleaseDate()+"-->"+blog.getContentNoTag());
			blogIndex.addIndex(blog);
		}
	  List<Blog>  blogIndexList=blogIndex.searchBlog("git");
	  System.out.println(blogIndexList.size());
	}

}
