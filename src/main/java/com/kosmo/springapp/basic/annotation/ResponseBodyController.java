package com.kosmo.springapp.basic.annotation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseBodyController {

	//[웹브라우저로 직접 출력하기]
	//방법1] 반환타입은 void, 매개변수는 서블릿 API 사용 - @ResponseBody어노테이션 미 사용
	/*
	@RequestMapping("/Annotation/ResponseBody.do")
	public void exec(HttpServletResponse resp) throws IOException {
		//응답헤더에 컨텐트 타입 설정]- 그래야 한글이 안깨짐
		resp.setContentType("text/html; charset=UTF-8");
		//웹 브라우저에 출력하기 위한 출력 스트림 얻기]
		PrintWriter out = resp.getWriter();
		out.println("<fieldset>");
		out.println("<legend> 반환타입:void,서블릿 API사용:HttpServletResponse</legend");
		out.println("<h2>웹 브라우저로 직접 출력합니다.</h2>");
		out.println("</fieldset>");
		//스트림 닫기
		out.close();
	}*/
	
	//방법2] 반환타입 String, 서블릿 API 미사용 및 @ResponseBody 어노테이션 사용
	//@RequestMapping("/Annotation/ResponseBody.do") : 한글깨짐
	@RequestMapping(value="/Annotation/ResponseBody.do",produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String exec() {
		//※ 반환되는 문자열이 응답바디에 쓰인다.
		
		return "<h2>웹 브라우저로 직접 출력합니다.</h2>";
	}
	
}
