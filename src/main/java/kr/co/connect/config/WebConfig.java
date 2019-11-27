package kr.co.connect.config;
// @Controller 빈들만 등록 가능한 설정파일 (계층구조 적용)

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import kr.co.connect.group.controller.GroupController;
import kr.co.connect.group.mapper.GroupMapperInterface;

//@ComponentScan(basePackages = "*", useDefaultFilters = false, includeFilters = @ComponentScan.Filter(kr.co.connect.group.controller.GroupController.class))
@Configuration
@ComponentScan(basePackages = "kr.co.connect")
@EnableAspectJAutoProxy
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	// js, css, img 등 리소스 파일의 URL 매핑
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	// ViewResolver -> 설정 내용이 없으면 404 예외 발생
	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver viewResolver = new BeanNameViewResolver();
		viewResolver.setOrder(0); // 우선순위
		return viewResolver;
	}

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(1);
		return viewResolver;
	}

	// 여기서부터 Jdbc 관련 빈들

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
		MapperFactoryBean<GroupMapperInterface> mapperFactoryBean = new MapperFactoryBean<GroupMapperInterface>(
				GroupMapperInterface.class);
		mapperFactoryBean.setSqlSessionFactory(sqlSession);
		return mapperFactoryBean;
	}
}
