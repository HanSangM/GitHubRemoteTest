package com.kosmo.springapp.basic.handlermapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*
 * Controller계열 인터페이스나 클래스를 구현 
 * 혹은 확장해야
 * 사용자 요청을 처리하는 컨트롤러 클래스 됨
 * 즉 스프링 프레임워크에서 사용자 요청을 처리할 수는
 * 자격을 갖추게 됨.
 * 또한 POJO로 작성한 후 Annotation을 이용해도
 * 컨트롤러 클래스가 됨. 
 */

//컨트롤러 클래스]
public class BeanNameUrlController implements Controller{
	
	//컨트롤러 메소드]
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1]요청받고 분석
		//2]비지니스로직(모델) 호출 및 결과값 받기
		//3]필요한 값을 리퀘스트 영역에 저장하거나 ModelAndView에 저장.
		ModelAndView mav = new ModelAndView();
		//4]데이타 저장
		mav.addObject("message", "[BeanNameUrlHandlerMapping]");
		//5]뷰 정보 저장
		mav.setViewName("Chap01_handlermapping/HandlerMapping");
		//6]디스패처서블릿에게 ModelAndView반환
		
		return mav;
	}
	
}
