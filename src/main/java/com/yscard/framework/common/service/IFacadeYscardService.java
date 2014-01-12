package com.yscard.framework.common.service;


import com.yscard.framework.common.model.Trader;
import com.yscard.framework.springmvc.model.Commentlist;

public interface IFacadeYscardService {

	public void saveSomeTestComment(Trader trader);
	public Commentlist query(Trader trader) ;
	public void saveAdminString();
	
}
