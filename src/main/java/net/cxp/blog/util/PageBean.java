package net.cxp.blog.util;

/**
 * 分页Model类
 * @author cxp
 * @date 2017-1-03
 *
 */
public class PageBean {
  
	private int page;//第几页
	private int pageSize;//每页记录数
	private int start;//起始行（当前页显示的第一行数据）
	
	
	public PageBean(int page,int pageSize){
		super();
		this.page=page;
		this.pageSize=pageSize;
	}
	
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getStart() {
		start=(page-1)*pageSize;
		return start;
	}
	
}
