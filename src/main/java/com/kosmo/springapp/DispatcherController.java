package com.kosmo.springapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*
 어노테이션 미 사용시
 Controller계열 인터페이스나 클래스를 상속받아 컨트롤러로 구현
 대부분의 Controller계열 클래스가 Deprecated됨
 
 */
public class DispatcherController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//이런식으로 찍어보면 요청이 넘어오는지 파악할수 있음
		//System.out.println("요청이 들어오나");
		
		//ModelAndView 객체에 뷰정보와 모델(데이터)을 닫아 디스패처서블릿에게 반환
		// 뷰정보 : "/WEB-INF/views/home.jsp"
		// 데이터 정보 : 
		// 속성명 : "dispatcherservlet"
		// 속성값 : "또 다른 웹 어플리케이션 영역입니다"
		return new ModelAndView("/WEB-INF/views/home.jsp","dispatcherservlet","또 다른 웹 어플리케이션 영역입니다");
	}

}
