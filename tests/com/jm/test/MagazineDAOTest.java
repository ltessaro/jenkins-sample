package com.jm.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jm.dao.MagazineDAO;
import com.jm.vo.Magazine;

public class MagazineDAOTest {
	private Date validStartDate, validEndDate, validMonthYear, notfoundStartDate, notfoundEndDate, notfoundMonthYear;
	
	@Before
	public void setUp() throws Exception {
		this.validStartDate	  	= new Date(2011,  8, 01);
		this.validEndDate	  	= new Date(2011, 10, 31);
		this.validMonthYear	  	= new Date(2011, 10, 01);
		this.notfoundStartDate 	= new Date(2011,  3, 01);
		this.notfoundEndDate	= new Date(2011,  5, 01);
		this.notfoundMonthYear 	=  new Date(2011, 5, 01);
	}

	@Test
	public void testByValidPeriod() {
		MagazineDAO mDAO = new MagazineDAO();
		Magazine[] ms = mDAO.listByPeriod(this.validStartDate, this.validEndDate);
		
		Assert.assertNotNull(ms);
		Assert.assertTrue(ms.length > 0);
	}

	@Test
	public void testByNotFoundPeriod() {
		MagazineDAO mDAO = new MagazineDAO();
		Magazine[] ms = mDAO.listByPeriod(this.notfoundStartDate, this.notfoundEndDate);
		
		Assert.assertNotNull(ms);
		Assert.assertTrue(ms.length == 0);
	}

	@Test
	public void testGetByDate() {
		MagazineDAO mDAO = new MagazineDAO();
		Magazine m = mDAO.getByDate(validMonthYear.getMonth(), validMonthYear.getYear());

		Assert.assertNotNull(m);
	}
	
	@Test
	public void testNotFoundByDate() {
		MagazineDAO mDAO = new MagazineDAO();
		Magazine m = mDAO.getByDate(notfoundMonthYear.getMonth(), notfoundMonthYear.getYear());

		Assert.assertNull(m);
	}
}
