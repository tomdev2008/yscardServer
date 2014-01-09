package com.yscard.framework.service;

import com.yscard.framework.jdbcrepository.reps.Comment;

public interface UserYscardService {

	public void saveSomeTestComment();
	
	public java.util.List<Comment> findAll();
	
}
