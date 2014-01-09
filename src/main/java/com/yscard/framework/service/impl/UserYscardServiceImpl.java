package com.yscard.framework.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yscard.framework.jdbcrepository.reps.Comment;
import com.yscard.framework.jdbcrepository.reps.CommentRepository;
import com.yscard.framework.service.UserYscardService;

@Service(value = "userYscardService")
@Transactional
public class UserYscardServiceImpl implements UserYscardService {
	
	@Resource
	private CommentRepository repository;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveSomeTestComment(){
		//given
		final Comment comment = new Comment("towne", "Some content", new Date().toString(), 0);
		//when
		repository.save(comment);

	}
	
	public java.util.List<Comment> findAll(){
		return repository.findAll();
	}
}
