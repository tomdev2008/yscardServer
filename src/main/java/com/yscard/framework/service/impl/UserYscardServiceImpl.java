package com.yscard.framework.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yscard.framework.jdbcrepository.reps.Comment;
import com.yscard.framework.jdbcrepository.reps.CommentRepository;
import com.yscard.framework.jdbcrepository.ymptp.Admin_Manager;
import com.yscard.framework.jdbcrepository.ymptp.Admin_ManagerRepository;
import com.yscard.framework.service.UserYscardService;

@Service(value = "userYscardService")
@Transactional
public class UserYscardServiceImpl implements UserYscardService {
	
	@Resource
	private CommentRepository repository;
	
	@Resource
	private Admin_ManagerRepository adminresitory;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveSomeTestComment(){
		//given
		final Comment comment = new Comment("towne", "Some content", new Date().toString(), 0);
		//when
		repository.save(comment);

	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveAdminString(){
		//given
		Admin_Manager adminmanager =  new Admin_Manager("1", "1", 1, "1", "1", "1");
		//when
		adminresitory.save(adminmanager);

	}
	
	public java.util.List<Comment> findAll(){
		return repository.findAll();
	}
}
