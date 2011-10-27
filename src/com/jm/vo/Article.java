package com.jm.vo;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7765052377384192126L;
	
	private String title = "It is a sample text.";
	private String text;
	private Date published;
	private Magazine magazine;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	Magazine getMagazine() {
		return magazine;
	}

	void setMagazine(Magazine magazine) {
		this.magazine = magazine;
		if (this.published == null && this.magazine != null)
			setPublished(this.magazine.getCreated());
			
	}

}
