package com.yscard.framework.springmvc.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "commentlist")
public class Commentlist implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1233898340811709177L;

	private String tname = "towne_TAG";

	private List<CommentVO> moments;

	public List<CommentVO> getMoments() {
		return moments;
	}

	@XmlElement
	public void setMoments(List<CommentVO> moments) {
		this.moments = moments;
	}

	/**
	 * @return the tname
	 */
	public String getTname() {
		return tname;
	}

	/**
	 * @param tname
	 *            the tname to set
	 */
	@XmlElement
	public void setTname(String tname) {
		this.tname = tname;
	}
}
