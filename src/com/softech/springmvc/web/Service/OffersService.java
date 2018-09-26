package com.softech.springmvc.web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softech.springmvc.web.DAO.Offer;
import com.softech.springmvc.web.DAO.OffersDAO;

@Service("offersService")
public class OffersService {
	
	private OffersDAO offersDao;
	
	@Autowired
	public void setOffersDao(OffersDAO offersDao) {
		this.offersDao=offersDao;
	}
	
	public List<Offer> getCurrent(){
		return offersDao.getOffers();
	}

}
