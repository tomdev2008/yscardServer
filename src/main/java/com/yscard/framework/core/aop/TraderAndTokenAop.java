package com.yscard.framework.core.aop;

import java.util.Map;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.code.ssm.Cache;
import com.google.code.ssm.api.format.SerializationType;
import com.yscard.framework.common.model.Trader;
import com.yscard.framework.common.utils.CommonKey;
import com.yscard.framework.common.utils.MobileCommonUtil;
import com.yscard.framework.common.utils.SessionUtil;
import com.yscard.framework.common.utils.SystemMobileRuntimeException;
import com.yscard.framework.common.utils.TokenFactory;
import com.yscard.framework.system.filter.vo.Cookie;
import com.yscard.framework.system.filter.vo.MobileLogger;
import com.yscard.framework.system.filter.vo.ThreadLocalLog;


public class TraderAndTokenAop {
	private Logger logger = Logger.getLogger(TraderAndTokenAop.class);
     
	@Autowired
	private Cache me;
	
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        //System.out.println("AOP START");
    	
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length != 0) {
            Object arg1 = args[0];
            if (arg1 != null) {
                if (arg1.getClass().equals(Trader.class)) {
                    Trader trader = (Trader) arg1;
                    MobileLogger logVO = ThreadLocalLog.getSystemLoggerVO();
                    java.util.Date dt = new java.util.Date();
                    logVO.setId(dt.getTime());
                    logVO.setTraderName(trader.getTraderName());
                    logVO.setTraderPassword(trader.getTraderPassword());
//                    logVO.setClientSystem(trader.getClientSystem());
//                    logVO.setClientVersion(trader.getClientVersion());
//                    logVO.setInterfaceVersion(trader.getInterfaceVersion());
//                    logVO.setProtocol(trader.getProtocol());
//                    logVO.setLongitude(trader.getLongitude());
//                    logVO.setLatitude(trader.getLatitude());
//                    logVO.setDeviceCode(trader.getDeviceCode());
                    String userToken = TokenFactory.getUserToken();
               
                    Object tmpTrader = me.get(CommonKey.TRADER + userToken, SerializationType.PROVIDER);
                    Object tmpOneUsercookieMap = me.get(CommonKey.USER_TOKEN_KEY + userToken, SerializationType.PROVIDER);
                    if (tmpTrader == null
                    		&& tmpOneUsercookieMap == null) {
                    	trader.setUserToken(userToken);
                    } else if ((tmpTrader == null && tmpOneUsercookieMap != null)
                    		|| (tmpTrader != null && tmpOneUsercookieMap == null)) {
                		MobileCommonUtil.removeSessionInfo(me, userToken);
                    } else {
                    	for (int i=0; i<3; i++) {
                    		userToken = TokenFactory.getUserToken();
//                    		if (me.get(CommonKey.TRADER + userToken) == null
//                            		&& me.get("USER_TOKEN_KEY:" + userToken) == null) {
                    		if (tmpTrader == null
                            		&& tmpOneUsercookieMap == null) {
                            	trader.setUserToken(userToken);
                            	break;
                    		}
                    		if (i==2) {
                    			userToken = TokenFactory.getUserToken();
                    			trader.setUserToken(userToken);
                    			logger.error("[info]TraderAndTokenAop.invoke:try getUserToken 3 repeat");
                    		}
                    	}
                    }
                    
                    logVO.setUserToken(trader.getUserToken());
                    SessionUtil.setLogVO(me,logVO);
                }
                if (arg1.getClass().equals(String.class)) {
                    String token = (String) arg1;
                    //一个用户的cookies对象,中间可以保存多个cookieVO
                    @SuppressWarnings("unchecked")
					Map<String, Cookie> oneUsercookieMap = (Map<String, Cookie>) me
                        .get(CommonKey.USER_TOKEN_KEY + token, SerializationType.PROVIDER);
                    if (oneUsercookieMap == null) {
                        throw new SystemMobileRuntimeException("用户Token过期,请重新登陆");
                    }
                    Trader trader = (Trader) me.get(CommonKey.TRADER + token, SerializationType.PROVIDER);
                    if (trader == null) {
                        throw new SystemMobileRuntimeException("用户Token过期,请重新登陆");
                    }
                    MobileLogger logVO = ThreadLocalLog.getSystemLoggerVO();
                    logVO.setTraderName(trader.getTraderName());
                    logVO.setTraderPassword(trader.getTraderPassword());
//                    logVO.setClientSystem(trader.getClientSystem());
//                    logVO.setClientVersion(trader.getClientVersion());
//                    logVO.setInterfaceVersion(trader.getInterfaceVersion());
//                    logVO.setProtocol(trader.getProtocol());
                    logVO.setUserToken(token);
//                    logVO.setLongitude(trader.getLongitude());
//                    logVO.setLatitude(trader.getLatitude());
//                    logVO.setDeviceCode(trader.getDeviceCode());
//                    logVO.setDeviceCodeNotEncrypt(trader.getDeviceCodeNotEncrypt());
                    SessionUtil.setLogVO(me,logVO);
                }
            } else {
            	if(joinPoint.getSignature().getName() == "addFeedback")
            	{
            		String arg2 = (String)args[1];
            		if(arg2 != null && arg2.indexOf(" IMEI:")>0)
                    {
                    	int pos =arg2.indexOf(" IMEI:");
                    	String imei = arg2.substring(pos + 6);
                    	SessionUtil.setUserGUID(me,imei);
                    }
            	}
            	else   
            		throw new SystemMobileRuntimeException("Trader出错或用户过期");
            }
        }
           Object obj = joinPoint.proceed();
            //System.out.println("AOP END");
           return obj;
    }
}
