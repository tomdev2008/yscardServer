package com.yscard.framework.jdbcrepository.conf;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.yscard.framework.jdbcrepository.reps.BoardingPassRepository;
import com.yscard.framework.jdbcrepository.reps.CommentRepository;
import com.yscard.framework.jdbcrepository.reps.CommentWithUserRepository;
import com.yscard.framework.jdbcrepository.reps.UserRepository;
import com.yscard.framework.jdbcrepository.ymptp.Admin_ManagerRepository;

@EnableTransactionManagement
@Configuration
public class JdbcRepositoryConfig {

	@SuppressWarnings("static-access")
	public @Bean
	DataSource dataSource() throws Exception {
		Properties prop = new Properties();
		prop.load(JdbcRepositoryConfig.class.getClassLoader()
				.getResourceAsStream("jdbc.properties"));
		// 建立数据工厂
		DataSource myDataSource = BasicDataSourceFactory.createDataSource(prop);
		BasicDataSourceFactory dataSourceFactory = new BasicDataSourceFactory();
		myDataSource = dataSourceFactory.createDataSource(prop);
		return myDataSource;
	}

	public @Bean
	CommentRepository commentRepository() {
		return new CommentRepository();
	}

	public @Bean
	UserRepository userRepository() {
		return new UserRepository();
	}

	public @Bean
	BoardingPassRepository boardingPassRepository() {
		return new BoardingPassRepository();
	}

	public @Bean
	CommentWithUserRepository commentWithUserRepository() {
		return new CommentWithUserRepository();
	}

	public @Bean
	Admin_ManagerRepository admin_ManagerRepository() {
		return new Admin_ManagerRepository();
	}
	
	public @Bean
	PlatformTransactionManager transactionManager() throws Exception {
		return new DataSourceTransactionManager(dataSource());
	}
}
