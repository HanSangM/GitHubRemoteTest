package com.kosmo.springapp.basic.handlermapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤러 클래스]
@Controller
public class AnnotationController {

	//컨트롤러 메소드]
	@RequestMapping("/HandlerMapping/Annotation.do")
	public String handleRequest(Model model) {
		//데이터 저장]
		model.addAttribute("message","[DefaultAnnotationHandlerMapping]");
		//뷰정보 반환]
		return "Chap01_handlermapping/HandlerMapping";
	}///////handleRequest
}
