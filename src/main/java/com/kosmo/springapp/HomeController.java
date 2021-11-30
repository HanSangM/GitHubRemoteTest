package com.kosmo.springapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
//spring container 가 자동으로 생성한다 - 무엇을?
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)//post로 바꾸면 405에러 GET 방식으로 얻어온다
	//여기 value값에는 /가 디폴트값이므로 있어야한다.(있는게 좋다?)
	public String home(Locale locale, Model model) { //controller 메소드
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		//리퀘스트에 serverTime 이름 저장
		
		return "home";
		//return "/WEB-INF/views/home.jsp"; 원래 이렇게인대 forward 된 것.
		//view resolver 적용
	}
	
}
