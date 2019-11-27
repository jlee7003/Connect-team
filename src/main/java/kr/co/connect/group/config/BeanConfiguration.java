package kr.co.connect.group.config;

//import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import kr.co.connect.group.mapper.GroupMapperInterface;

@Configuration
@ComponentScan(basePackages = { "kr.co.connect.group.*" })
public class BeanConfiguration {
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/connect?useSSL=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("12345678");
		return dataSource;
	}
	
	// SqlSessionFactory : Jdbc 처리 클래스 사용 
	@Bean
	public SqlSessionFactory sqlSessionFactory(DriverManagerDataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
//		sqlSessionFactoryBean.setMapperLocations("classpath:kr/co/connect/group/mapper/GroupMapperInterface.class");
		
		SqlSessionFactory sqlSession = sqlSessionFactoryBean.getObject();
		return sqlSession;
	}
	
	// GroupMapperInterface : 쿼리문을 처리하는 클래스 (myBatis)
	@Bean
	public MapperFactoryBean<GroupMapperInterface> getMapper(SqlSessionFactory sqlSession) {
		MapperFactoryBean<GroupMapperInterface> mapperFactoryBean = new MapperFactoryBean<GroupMapperInterface>(GroupMapperInterface.class);
		mapperFactoryBean.setSqlSessionFactory(sqlSession);
		return mapperFactoryBean;
	}
	
}
