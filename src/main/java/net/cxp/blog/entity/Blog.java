package net.cxp.blog.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Blog {
    private Long id;

    private String title;

    private String summary;

    private Date releaseDate;

    private Long clickHit;

    private Long replyHit;

    private String content;

    private String keyword;

    private BlogType blogType;
    
	private Integer blogCount; //博客数量，非博客实际属性，用于根据发布日期归档查询
    private String releaseDateStr; //发布日期的字符串，只取年月
    private String contentNoTag; //不带标签的博客内容，用于Lucene索引中
    
    private List<String> imageList = new LinkedList<String>();//博客里存的图片，主要用于展示缩略图

    public List<String> getImageList() {
		return imageList;
	}

	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getClickHit() {
        return clickHit;
    }

    public void setClickHit(Long clickHit) {
        this.clickHit = clickHit;
    }

    public Long getReplyHit() {
        return replyHit;
    }

    public void setReplyHit(Long replyHit) {
        this.replyHit = replyHit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

	public BlogType getBlogType() {
		return blogType;
	}

	public void setBlogType(BlogType blogType) {
		this.blogType = blogType;
	}

    public Integer getBlogCount() {
		return blogCount;
	}

	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}

	public String getReleaseDateStr() {
		return releaseDateStr;
	}

	public void setReleaseDateStr(String releaseDateStr) {
		this.releaseDateStr = releaseDateStr;
	}
	
	public String getContentNoTag() {
		return contentNoTag;
	}

	public void setContentNoTag(String contentNoTag) {
		this.contentNoTag = contentNoTag;
	}

}