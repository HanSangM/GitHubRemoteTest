package com.kosmo.springapp.basic.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//컨트롤러 클래스]
@Controller
public class OneMethodController {
	
	//컨트롤러 메소드]
	@RequestMapping({
		"/Controller/OneMethod/List.do",
		"/Controller/OneMethod/Edit.do",
		"/Controller/OneMethod/Delete.do",
		"/Controller/OneMethod/View.do"})
	//하나의 메소드로 4개의 요청 처리
	public String parameter(@RequestParam int paramvar,Map map) {
		switch(paramvar) {
			case 1: map.put("message", "목록 요청");break;
			case 2: map.put("message", "수정 요청");break;
			case 3: map.put("message", "삭제 요청");break;
			default: map.put("message", "상세보기 요청");
		}
		//디스패처 서블릿에게 뷰정보 반환]
		return "Chap02_controller/Controller";
		
	}////////////parameter
}
