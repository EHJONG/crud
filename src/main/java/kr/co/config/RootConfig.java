package kr.co.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "kr.co.bean")
@MapperScan(basePackages = "kr.co.mapper") // <ㅡ 이거 해야 함
@ComponentScan(basePackages = "kr.co.dao") // <ㅡ 이거 해야 함
@ComponentScan(basePackages = "kr.co.service") // <ㅡ 이거 해야 함
@ComponentScan(basePackages = "kr.co.controller")
public class RootConfig {
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Seoul&useSSL=false");
		hikariConfig.setUsername("root");
		hikariConfig.setPassword("1234");
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
	}

	// 쿼리문과 접속 정보를 관리하는 객체
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory) sqlSessionFactory.getObject();
	}
}
