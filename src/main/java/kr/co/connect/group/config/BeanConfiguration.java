package kr.co.connect.group.config;

//import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import kr.co.connect.group.mapper.GroupMapperInterface;

// @EnableWebMvc : <mvc:annotation-driven /> 과 동일
// DispatcherServlet 은 @Configuration 파일을 읽어서 내부적으로 스프링 컨테이너를 생성 (ApplicationContext)
// web 에 필요한 빈들을 대부분 자동 생성 
// 추가 설정 필요시, WebMvcConfigurerAdapter 클래스를 상속받고 오버라이드 

@Configuration
@ComponentScan(basePackages = "kr.co.connect.*") // @Controller 도 포함 
@EnableAspectJAutoProxy
@EnableWebMvc 
public class BeanConfiguration extends WebMvcConfigurerAdapter {
	
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
