package kr.co.connect.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import kr.co.connect.group.controller.GroupController;

// @EnableWebMvc : <mvc:annotation-driven /> 과 동일
// DispatcherServlet 은 servlet-context.xml 파일 대신 @Configuration 파일을 읽어서 스프링 컨테이너를 생성 (ApplicationContext)
// web 에 필요한 빈들은 대부분 자동 생성 (HandlerMapping 등) 
// 추가 설정 필요시, WebMvcConfigurerAdapter 클래스를 상속받고 오버라이드 

@Configuration
@ComponentScan(basePackages = "kr.co.connect", excludeFilters = @ComponentScan.Filter(GroupController.class)) // @Controller 제외 
@EnableAspectJAutoProxy
@EnableWebMvc
public class AppConfig {
	
	
}
