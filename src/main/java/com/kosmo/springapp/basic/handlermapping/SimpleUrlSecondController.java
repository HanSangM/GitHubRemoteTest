package com.kosmo.springapp.basic.handlermapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

//컨트롤러 클래스]
public class SimpleUrlSecondController extends AbstractController{

	//컨트롤러 메소드]
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return new ModelAndView("Chap01_handlermapping/HandlerMapping","message","[SimpleUrlSecond.do]");
	}

}
