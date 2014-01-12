package com.yscard.framework.jdbcrepository.ymptp;

import com.yscard.framework.jdbcrepository.JdbcRepository;
import com.yscard.framework.jdbcrepository.RowUnmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yscard.framework.jdbcrepository.ymptp.Admin_Manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class Admin_ManagerRepository extends
		JdbcRepository<Admin_Manager, Integer> {
	
	public Admin_ManagerRepository() {
		this("admin_manager","a_id");
		      
	}
    
    public Admin_ManagerRepository(String tableName) {
		super(MAPPER, ROW_UNMAPPER, tableName);
	}
    
    public Admin_ManagerRepository(String tableName,String idColumn) {
		super(MAPPER, ROW_UNMAPPER, tableName,idColumn);
	}

	public Admin_ManagerRepository(RowMapper<Admin_Manager> rowMapper, RowUnmapper<Admin_Manager> rowUnmapper, String tableName, String idColumn)
	{
		super(rowMapper, rowUnmapper, tableName, idColumn);
	}
	
	public static final RowMapper<Admin_Manager> MAPPER = new RowMapper<Admin_Manager>() {

			@Override
			public Admin_Manager mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Admin_Manager(
						rs.getInt("a_id"),
						rs.getString("a_name"),
						rs.getString("a_password"),
						rs.getInt("a_competence"),
						rs.getString("a_iphone"),
						rs.getString("a_landedip"),
						rs.getString("amdin_rename")
				);
			}
		};

		private static final RowUnmapper<Admin_Manager> ROW_UNMAPPER = new RowUnmapper<Admin_Manager>() {
			@Override
			public Map<String, Object> mapColumns(Admin_Manager adminmanager) {
				Map<String, Object> mapping = new LinkedHashMap<String, Object>();
				mapping.put("a_id", adminmanager.getA_id());
				mapping.put("a_name", adminmanager.getA_name());
				mapping.put("a_password", adminmanager.getA_password());
				mapping.put("a_competence", adminmanager.getA_competence());
				mapping.put("a_iphone", adminmanager.getA_iphone());
				mapping.put("amdin_rename", adminmanager.getAmdin_rename());
				return mapping;
			}
		};

		@Override
		protected <S extends Admin_Manager> S postCreate(S entity, Number generatedId) {
			entity.setA_id(generatedId.intValue());
			return entity;
		}
}
