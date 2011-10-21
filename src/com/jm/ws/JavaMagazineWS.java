package com.jm.ws;

import java.util.Date;

import com.jm.bus.JMagazineBusiness;
import com.jm.exception.BusinessException;
import com.jm.vo.Article;
import com.jm.vo.Magazine;

public class JavaMagazineWS {
	private JMagazineBusiness business = new JMagazineBusiness();
	
	public Magazine getMagazineByMonthAndYear(int month, int year) throws BusinessException{
		return business.getTheMagazine(month, year);
	}

	public Article[] listMagazineArticlesByMagazineNumber(int number) throws BusinessException{
		return business.listMagazineArticles(number);
	}
	
	public Magazine[] listAllMagazinesStartingIn(Date startDate) throws BusinessException{
		return business.listMagazines(startDate, new Date());
	}
}
