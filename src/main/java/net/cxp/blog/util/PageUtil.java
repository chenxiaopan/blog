package net.cxp.blog.util;

import net.cxp.blog.entity.Blog;

/**
 * 分页工具类
 * 
 * @author cxp
 * @date 2017-1-03
 * 
 */
public class PageUtil {

	/**
	 * 生成分页代码，嵌入到jsp页面
	 * 
	 * @param targetUrl
	 * @param totalNum
	 * @param currentPage
	 * @param pageSize
	 * @param param
	 * @return
	 */
	public static String genPagination(String targetUrl, long totalNum,
			int currentPage, int pageSize, String param) {

		// 计算总页数
		long totalPage = totalNum % pageSize == 0 ? totalNum / pageSize
				: totalNum / pageSize + 1;

		if (totalPage == 0) {
			return "未查询到数据";
		} else {
			// StringBuffer是线程安全的
			StringBuffer pageCode = new StringBuffer();
			if (currentPage > 1) {
				pageCode.append("<li><a href='" + targetUrl + "?page=1&"
						+ param + "'>首页</a></li>");
				pageCode.append("<li><a href='" + targetUrl + "?page="
						+ (currentPage - 1) + "&" + param + "'>上一页</a></li>");
			} else {
				pageCode.append("<li class='disable'><a>首页</a></li>");
				pageCode.append("<li class='disable'><a>上一页</a></li>");
			}

			for (int i = currentPage; i <=(totalPage>3?currentPage + 2:totalPage); i++) {
				if (i < 1 || i > totalPage) {
					pageCode.append("<li class='active'><a href='" + targetUrl
							+ "&page=" + i + "&" + param + "'>" + i
							+ "</a></li>");
				} else {
					pageCode.append("<li><a href='" + targetUrl + "?page=" + i
							+ "&" + param + "'>" + i + "</a></li>");
				}
			}

			if (currentPage < totalPage) {
				pageCode.append("<li><a href='" + targetUrl + "?page="
						+ (currentPage + 1) + "&" + param + "'>下一页</a></li>");
				pageCode.append("<li><a href='" + targetUrl + "?page="
						+ totalPage + "&" + param + "'>尾页</a></li>");
			} else {
				pageCode.append("<li class='disable'><a>下一页</a></li>");
				pageCode.append("<li class='disable'><a>尾页</a></li>");
			}

			return pageCode.toString();
		}

	}

	public static String getPrevAndNextPageCode(Blog prev, Blog next,
			String projectContent) {

		StringBuffer pageCode = new StringBuffer();
		if (prev == null || prev.getId() == null) {
			pageCode.append("<p>上一篇：无</p>");
		} else {
			pageCode.append("<p>上一篇：<a href='" + projectContent
					+ "/blog/articles/" + prev.getId() + ".html'>"
					+ prev.getTitle() + "</a></p>");
		}
		if (next == null || next.getId() == null) {
			pageCode.append("<p>下一篇：无</p>");
		} else {
			pageCode.append("<p>下一篇：<a href='" + projectContent
					+ "/blog/articles/" + next.getId() + ".html'>"
					+ next.getTitle() + "</a></p>");
		}
		return pageCode.toString();
	}

	/**
	 * Lucence搜索博客结果的分页
	 */
	public static String getUpAndDownPageCode(Integer page, Integer totalNum,
			String q, Integer pageSize, String projectContext) {

		// 计算总页数
		long totalPage = totalNum % pageSize == 0 ? totalNum / pageSize
				: totalNum / pageSize + 1;
		StringBuffer pageCode = new StringBuffer();

		if (totalPage == 0) {
			return "";
		} else {
			pageCode.append("<nav>");
			pageCode.append("<ul class='pager'>");

			if (page > 1) {
				pageCode.append("<li><a href='" + projectContext
						+ "/blog/search.html?page=" + (page - 1) + "&q=" + q
						+ "'>上一页</a></li>");
			} else {
				pageCode.append("<li class=disadle><a>上一页</a></li>");
			}

			if (page < totalPage) {
				pageCode.append("<li><a href='" + projectContext
						+ "/blog/search.html?page" + (page + 1) + "&q" + q
						+ "'>下一页</a></li>");
			} else {
				pageCode.append("<li class='disable'><a>下一页</a></li>");

			}
			pageCode.append("</ul>");
			pageCode.append("<nav>");
			pageCode.append("<nav>");
			pageCode.append("<nav>");
		}
		return pageCode.toString();
	}

}
