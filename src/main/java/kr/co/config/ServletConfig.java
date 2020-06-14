package kr.co.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import kr.co.mapper.TestMapper;

// ComponentScan 은 이 클래스에서 !! 
@EnableWebMvc
//@ComponentScan(basePackages = "kr.co.controller")
@ComponentScan(basePackages = "kr.co.home")		//  <ㅡ 얘는 여기에 해야 함
//@ComponentScan(basePackages= "kr.co.service")		<ㅡ 이거 없어도 됨 
//@ComponentScan(basePackages = "kr.co.dao")		<ㅡ 이거 없어도 됨
//@MapperScan(basePackages = "kr.co.mapper")		<ㅡ 이거 없어도 됨
public class ServletConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		res.setBasenames("/WEB-INF/properties/error_message");
		return res;
	}
}

/*
 * Servlet-context.xml을 대신하는 별도의 ServletConfig 클래스를 작성한다. ServletConfig 클래스는 기존의
 * servlet-context.xml에 설정된 모든 내용을 담아야 하는데, 이때는 주로 다음과 같은 방식을 이용한다.
 * 
 * @EnableWebMvc 어노테이션과 WebMvcConfigurer 인터페이스를 구현하는 방식 (과거에는
 * WebMvcConfigurerAdapter 추상클래스를 사용했으나, 스프링5버전부터는 Deprecated되었으므로 주의하자)
 * 
 * @Configuration과 WebMvcConfigurationSupport 클래스를 상속하는 방식 - 일반 @Configuration우선
 * 순위가 구분되지 않는 경우에 사용
 * 
 * 위 ServletConfig 셋팅은 @EnableWebMvc 어노테이션을 이용해서 셋팅한다.
 */