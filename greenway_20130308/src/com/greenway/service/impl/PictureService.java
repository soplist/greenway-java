package com.greenway.service.impl;

import com.greenway.pojo.inter.IPicDAO;
import com.greenway.pojo.impl.Pic;
import com.greenway.service.inter.IPictureService;

public class PictureService implements IPictureService {
    IPicDAO picDAO;

	public void save(Pic transientInstance) {
		// TODO Auto-generated method stub
		picDAO.save(transientInstance);
	}
	public IPicDAO getPicDAO() {
		return picDAO;
	}
	public void setPicDAO(IPicDAO picDAO) {
		this.picDAO = picDAO;
	}

}
