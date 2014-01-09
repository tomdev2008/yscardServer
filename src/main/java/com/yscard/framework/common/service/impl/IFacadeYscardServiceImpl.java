package com.yscard.framework.common.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yscard.framework.common.model.Trader;
import com.yscard.framework.common.service.IFacadeYscardService;
import com.yscard.framework.jdbcrepository.reps.Comment;
import com.yscard.framework.service.UserYscardService;
import com.yscard.framework.springmvc.model.Commentlist;
import com.yscard.framework.springmvc.model.CommentVO;


@Service(value = "ifacadeYscardService")
@Transactional
public class IFacadeYscardServiceImpl implements IFacadeYscardService {

	@Resource(name = "userYscardService")
	UserYscardService userService;
	
	public void saveSomeTestComment(Trader trader){
		userService.saveSomeTestComment();	
	}
	
	public Commentlist query(Trader trader) {
		// TODO Auto-generated method stub
		List<Comment> moments = userService.findAll();
		Commentlist cl = new Commentlist();
		ArrayList<CommentVO> commentvoList = new ArrayList<CommentVO>();
	    for (Comment comment : moments) {
	    	commentvoList.add(coyetoVO(comment));
		}
	    cl.setMoments(commentvoList);
		return cl;
	}
	
	private CommentVO coyetoVO(Comment co ){
		CommentVO vo = new CommentVO();
		vo.setUserName(co.getUserName());
		vo.setContents(co.getContents());
		vo.setCreatedTime(vo.getCreatedTime());
		vo.setFavouriteCount(vo.getFavouriteCount());
		return vo;
	}
}
