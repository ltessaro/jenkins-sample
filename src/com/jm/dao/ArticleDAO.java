package com.jm.dao;

import java.util.List;

import com.jm.vo.Article;
import com.jm.vo.Magazine;

public class ArticleDAO {
	public Article[] listByMagazine(Magazine m) {
		List<Magazine> all = EmulateData.getMagazines();
		for (Magazine mag : all) {
			if (mag.getNumber() == m.getNumber())
				return mag.getArticles();
		}
		return null;
	}
}