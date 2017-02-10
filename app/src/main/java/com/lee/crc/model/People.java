package com.lee.crc.model;


import java.io.Serializable;

public class People implements Serializable {
	private Integer id;
	private String name;
	private String	from;
	private String content;
	private String url;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", from=" + from + ", content=" + content + ", url=" + url + "]";
	}
	


	

}
