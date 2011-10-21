package com.jm.vo;

import java.util.Date;

public class Magazine {	
	private int number;
	private String name;
	private String publisher;
	private Date created;
	private Article[] articles;

	public Magazine() {}
	public Magazine(int n) { this.number = n; }
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Article[] getArticles() {
		return articles;
	}

	public void setArticles(Article[] articles) {
		this.articles = articles;
		if (this.articles != null) {
			for (Article a : this.articles) {
				if (a != null)
					a.setMagazine(this);
			}
		}
	}
	/*
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nMagazine Name: ").append(this.name);
		sb.append("\nMagazine Nmuber: ").append(this.number);
		sb.append("\nMagazine Created: ").append(this.created);
		sb.append("\nMagazine Articles: ");
		if (this.articles != null && articles.length > 0) {
			for (Article a : this.articles)
				sb.append("\n\t").append(a.getTitle());
		} else {
			sb.append("No article found.");
		}
		return sb.toString();
	}*/
}