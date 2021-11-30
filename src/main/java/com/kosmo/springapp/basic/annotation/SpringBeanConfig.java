package com.kosmo.springapp.basic.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosmo.springapp.basic.validation.FormValidator;

@Configuration
public class SpringBeanConfig {

	/*
	 * 접근지정자 : public
	 * 반환타입 : 스프링 컨테이너에 등록하고자 하는 빈의 타입
	 * 메소드명 : 소문자로 시작하는 클래스명
	 * 
	 * name 속성으로 빈의 아이디 설정 가능
	 * 해당 빈을 필요로 하는 곳에서 @Autowired나 @Resource로 자동 주입해서 사용
	 */
	@Bean
	@Lazy //ConfigurationController에도 @Lazy를 추가해야 한다.
	public ConfigBean configBean() {//클래스명을 소문자로 주로 쓴다.
		return new ConfigBean();
	}
	/* 아래 두개는 유효성 검증용*/
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource message= new ResourceBundleMessageSource();
		message.setBasenames("com/kosmo/springapp/basic/validation/ErrorMessage");
		message.setDefaultEncoding("UTF-8");
		return message;
	}
	@Bean
	public FormValidator formValidator() {
		return new FormValidator();
	}
	
	//자바객체를 JSON형식의 문자열로 변경(onememo에서 사용)
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
	
}
