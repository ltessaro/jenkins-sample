package com.jm.bus;

import java.util.Date;

import com.jm.dao.ArticleDAO;
import com.jm.dao.MagazineDAO;

import com.jm.exception.BusinessException;

import com.jm.vo.Article;
import com.jm.vo.Magazine;

public class JMagazineBusiness {
	private ArticleDAO aDAO 	= new ArticleDAO();
	private MagazineDAO mDAO 	= new MagazineDAO();
	
	public Article[] listMagazineArticles(int magNumber) throws BusinessException {
		if (magNumber <= 0)
			throw new BusinessException("Invalid Magazine");
		else {
			Magazine m = new Magazine();
			m.setNumber(magNumber);

			return aDAO.listByMagazine(m);
		}
	}
	public Magazine getTheMagazine(int month, int year) throws BusinessException {
		Magazine[] ms = this.listMagazines(new Date(year, month, 1), null);
		if (ms == null || ms.length == 0)
			throw new BusinessException("There is no Magazine on this month and year combination.");
		return ms[0];
	}
	
	public Magazine[] listMagazines(Date startDate, Date endDate) throws BusinessException {
		if (startDate != null && endDate == null) {
			Magazine m = mDAO.getByDate(startDate.getMonth(), startDate.getYear());
			if (m == null)
				return null;
			else
				return new Magazine[] { m };
		} else if (startDate == null && endDate != null) {
			Magazine m = mDAO.getByDate(endDate.getMonth(), endDate.getYear());
			if (m == null)
				return null;
			else
				return new Magazine[] { m };
		} else if (startDate == null && endDate == null)
			throw new BusinessException("Invalid Dates. At least one is mandatary.");
		else 
			return mDAO.listByPeriod(startDate, endDate);
	}
}
