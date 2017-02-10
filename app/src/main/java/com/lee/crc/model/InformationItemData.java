package com.lee.crc.model;

import java.io.Serializable;

/**
 * 新闻详情实体bean。
 * 
 * @author Administrator
 * @since 2014年8月8日16:14:24
 * @version 1.0.1
 * @Modefied 2014年11月5日11:00:46 by qiu 增加注释。</br>
 */
public class InformationItemData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String content;
	private String date;
	private String[] imageUrl;

	public InformationItemData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String[] getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String[] imageUrl) {
		this.imageUrl = imageUrl;
	}

}
