package com.jm.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jm.dao.ArticleDAO;
import com.jm.vo.Article;
import com.jm.vo.Magazine;

public class ArticleDAOTest {
	private int notfoundNumber, validNumber;
	
	@Before
	public void setUp() throws Exception {
		this.notfoundNumber = 125;
		this.validNumber 	= 95;
	}

	@Test
	public void testNotFound() {
		ArticleDAO aDAO = new ArticleDAO();
		Article[] as = aDAO.listByMagazine(new Magazine(this.notfoundNumber));
		
		Assert.assertNull(as);
		//Assert.assertFalse(as.length == 0);
	}

	@Test
	public void testValid() {
		ArticleDAO aDAO = new ArticleDAO();
		Article[] as = aDAO.listByMagazine(new Magazine(this.validNumber));

		Assert.assertNotNull(as);
		Assert.assertTrue(as.length > 0);
	}
}