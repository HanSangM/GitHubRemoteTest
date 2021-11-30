package com.kosmo.springapp.basic.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 스프링에 빈 등록  방법
	방법1. @Controller,@Service,@Repository,@Component,@Configuration가 붙은 클래스를 스캔 해서 스프링 컨테이너에 빈으로 등록
	
	빈의 아이디는 카멜 케이스  형태의 클래스명이 된다
	
	빈의 아이디를 직접 지정시에는 name속성 추가.단,@Component(value="빈 아이디")는 value속성 사용


방법 2.@Congiguration어노테이션과 @Bean어노테이션  사용해서 자바코드로 내가 생성해서 빈 등록

	@Configuration
	
	public  class  SpringBeanConfig{
	        @Bean
	         public  OneMemoService  oneMemoService(){
	             return  new  OneMemoService();
	          }
	         public  OneMemoRepository  oneMemoRepository(){
	               return  new  OneMemoRepository();
	         }
	}
이때 빈의 아이디는 카멜케이스  형태의 메소드명이된다
혹은 @Bean(name="빈이름")으로 지정한다
단.@Controller는  요청처리를 하기위한 빈이니까
@Configuration으로 등록하는 빈에서 제외한다
이제 서비스와 리포지토리에서 @Service  ,@Repository는 붙이지 않는다
※생성된 빈은 @Autowired나 @Resource로 주입해서 사용
 */

@Controller
@Lazy //최초실행시 생성이 안되고 요청이 있을때 생성된다.
public class ConfigurationController {

	//ConfigBean을 주입 받는다.
	@Autowired
	private ConfigBean configBean;
	
	@RequestMapping("/Configuration/Configuration.do")
	public String exec(Model model) {
		//데이터 저장]
		model.addAttribute("message", configBean);
		//뷰 정보 반환]
		return "Chap06_annotation/Annotation";
	}
}
