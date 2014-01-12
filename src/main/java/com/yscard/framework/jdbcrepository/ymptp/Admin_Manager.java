package com.yscard.framework.jdbcrepository.ymptp;

import java.util.Date;

import org.springframework.data.domain.Persistable;

public class Admin_Manager implements Persistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1434488168036377924L;
	
	private Integer a_id;
	private String  a_name;
	private String a_password;
	private int a_competence;
	private String a_iphone	;
	private String a_landedip;	
	private String amdin_rename;
	
	public Admin_Manager(String aName, String aPassword, int aCompetence,
			String aIphone, String aLandedip,String aAmdinrename) {
		// TODO Auto-generated constructor stub
		this.a_name = aName;
		this.a_password = aPassword;
		this.a_competence = aCompetence;
		this.a_iphone = aIphone;
		this.a_landedip = aLandedip;
		this.amdin_rename = aAmdinrename;
	}
	
	public Admin_Manager(Integer aId,String aName, String aPassword, int aCompetence,
			String aIphone, String aLandedip,String aAmdinrename) {
		// TODO Auto-generated constructor stub
	    this(aName, aPassword, aCompetence, aIphone, aLandedip, aAmdinrename);
	    this.a_id = aId;
	}

	public Integer getA_id() {
		return a_id;
	}

	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public String getA_password() {
		return a_password;
	}

	public void setA_password(String a_password) {
		this.a_password = a_password;
	}

	public int getA_competence() {
		return a_competence;
	}

	public void setA_competence(int a_competence) {
		this.a_competence = a_competence;
	}

	public String getA_iphone() {
		return a_iphone;
	}

	public void setA_iphone(String a_iphone) {
		this.a_iphone = a_iphone;
	}

	public String getA_landedip() {
		return a_landedip;
	}

	public void setA_landedip(String a_landedip) {
		this.a_landedip = a_landedip;
	}

	public String getAmdin_rename() {
		return amdin_rename;
	}

	public void setAmdin_rename(String amdin_rename) {
		this.amdin_rename = amdin_rename;
	}
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return a_id;
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return a_id == null;
	}
}
