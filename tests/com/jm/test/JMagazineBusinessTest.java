package com.jm.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jm.bus.JMagazineBusiness;
import com.jm.exception.BusinessException;
import com.jm.vo.Article;
import com.jm.vo.Magazine;

public class JMagazineBusinessTest {
	private int invalidMagazine, notfoundMagazine, validMagazine;
	private Date validStart, validEnd, validMonthYear, notfoundStart, notfoundEnd, notfoundMonthYear;
	private JMagazineBusiness business = new JMagazineBusiness(); 
	@Before
	public void setUp() throws Exception {
		this.invalidMagazine 	= -1; 
		this.notfoundMagazine 	= 127;
		this.validMagazine 		= 95;
		this.validStart 		= new Date(2011,  8, 01);
		this.validEnd 			= new Date(2011, 10, 31);
		this.validMonthYear 	= new Date(2011, 10, 01);
		this.notfoundStart 		= new Date(2011, 3, 1);
		this.notfoundEnd 		= new Date(2011, 5, 1);
		this.notfoundMonthYear 	= new Date(2011, 5, 1);
	}

	@Test
	public void testListMagazineArticlesValid() throws Exception {
		Article[] as = business.listMagazineArticles(this.validMagazine);
		
		Assert.assertNotNull(as);
		Assert.assertTrue(as.length > 0);
	}
	
	@Test
	public void testListMagazineArticlesInvalid() throws Exception {
		try {
			Article[] as = business.listMagazineArticles(this.invalidMagazine);
			Assert.assertNull(as);
		} catch (BusinessException ex) {
			Assert.assertEquals("Invalid Magazine", ex.getMessage());
		}
	}
	
	@Test
	public void testListMagazineArticlesNotFound() throws Exception {
		Article[] as = business.listMagazineArticles(this.notfoundMagazine);
		
		Assert.assertNull(as);
	}
	
	@Test
	public void testGetTheMagazineValid() throws Exception {
		Magazine m = business.getTheMagazine(
				this.validMonthYear.getMonth(), 
				this.validMonthYear.getYear());
		
		Assert.assertNotNull(m);
	}
	
	@Test
	public void testGetTheMagazineNotFound() throws Exception {
		try {
			Magazine m = business.getTheMagazine(
					this.notfoundMonthYear.getMonth(), 
					this.notfoundMonthYear.getYear());

			Assert.assertNull(m);
		} catch (BusinessException ex) {
			Assert.assertEquals("There is no Magazine on this month and year combination.", ex.getMessage());
		}
	}
}