package com.yscard.framework.springmvc.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.code.ssm.Cache;
import com.yscard.framework.common.model.Trader;
import com.yscard.framework.common.service.IFacadeYscardService;
import com.yscard.framework.common.utils.SystemMobileRuntimeException;
import com.yscard.framework.springmvc.model.Commentlist;

/**
 * return json format data
 * @author towne
 *
 */
@Controller
@RequestMapping(value="/json",method={RequestMethod.GET})
public class ResponseJSONController {
	
	@Autowired
	IFacadeYscardService ifacadeYscardService;
	
	@Autowired
	private Cache me;
	
	
	static String userIP = "127.0.0.1";
	
	
	
	@RequestMapping(value="/commens",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Commentlist getContactsInJSON(){
		Trader trader = new Trader();
		Commentlist ml = ifacadeYscardService.query(trader);
		return ml;
	}
	
    /** 
     * 运行时异常页面控制 
     *  
     * @param runtimeException 
     * @return 
     * @throws UnsupportedEncodingException 
     */  
    @ExceptionHandler(RuntimeException.class)  
    public @ResponseBody  
    Map<String,Object> runtimeExceptionHandler(RuntimeException runtimeException) throws UnsupportedEncodingException { 
    	String RESTR = "";
    	if (runtimeException instanceof SystemMobileRuntimeException) {
    		RESTR = runtimeException.getMessage();
		}

        Map<String, Object> model = new TreeMap<String, Object>();  
        model.put("status", RESTR);  
        return model;  
    }   
}
