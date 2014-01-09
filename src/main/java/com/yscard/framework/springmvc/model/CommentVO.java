package com.yscard.framework.springmvc.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "comment")
public class CommentVO {
	
	private String userName;

	private String contents;

	private String createdTime;

	private int favouriteCount;

	public String getUserName() {
		return userName;
	}

	@XmlElement
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContents() {
		return contents;
	}

	@XmlElement
	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	@XmlElement
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public int getFavouriteCount() {
		return favouriteCount;
	}

	@XmlElement
	public void setFavouriteCount(int favouriteCount) {
		this.favouriteCount = favouriteCount;
	}
}
