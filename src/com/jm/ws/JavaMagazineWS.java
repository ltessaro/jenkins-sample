 package com.jm.ws;

import java.util.Date;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

import com.jm.bus.JMagazineBusiness;
import com.jm.exception.BusinessException;
import com.jm.vo.Article;
import com.jm.vo.Magazine;

@HandlerChain(file = "handler-chain.xml")
@WebService  
@SOAPBinding(parameterStyle=ParameterStyle.WRAPPED)  
public class JavaMagazineWS {
	private JMagazineBusiness business = new JMagazineBusiness();
	
	@WebMethod
	public Magazine getMagazineByMonthAndYear(@WebParam(name="month") int month, @WebParam(name="year") int year) throws BusinessException{
		return business.getTheMagazine(month, year);
	}

	@WebMethod
	public Article[] listMagazineArticlesByMagazineNumber(@WebParam(name="number") int number) throws BusinessException{
		return business.listMagazineArticles(number);
	}
	
	@WebMethod
	public Magazine[] listAllMagazinesStartingIn(@WebParam(name="startDate") Date startDate) throws BusinessException{
		return business.listMagazines(startDate, new Date());
	}
}
