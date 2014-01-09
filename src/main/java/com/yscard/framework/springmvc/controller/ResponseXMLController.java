package com.yscard.framework.springmvc.controller;



import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.ssm.Cache;
import com.google.code.ssm.api.format.SerializationType;
import com.google.code.ssm.providers.CacheException;
import com.yscard.framework.common.model.Trader;
import com.yscard.framework.common.service.IFacadeYscardService;
import com.yscard.framework.springmvc.model.Commentlist;

/**
 * return xml format data
 * @author towne
 *
 */
@Controller
@RequestMapping(value="/xml",method={RequestMethod.GET})
public class ResponseXMLController {
	
	@Autowired
	IFacadeYscardService ifacadeYscardService;
	
	@Autowired
	private Cache cache;

	/**
	 * query multiple xml data
	 * @return
	 */	
	@RequestMapping(value="/commens",produces=MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody Commentlist getContactsInXML(){
		Trader trader = new Trader();
		Commentlist ml = ifacadeYscardService.query(trader);
		try {
			System.out.println(">>>>>> "+cache.get("USER_LOGVO_127.0.0.1",SerializationType.PROVIDER));
			System.out.println(">>>>>> "+cache.get("USER_SESSION_127.0.0.1",SerializationType.PROVIDER));
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CacheException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ml;
	}
}
