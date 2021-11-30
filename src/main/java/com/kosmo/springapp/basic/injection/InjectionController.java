package com.kosmo.springapp.basic.injection;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InjectionController {
	//Person은 주입받자
	//@Resource는 생성자를 제외한 세터 및 속성에 붙인다.
	@Resource(name = "personArgs")
	private Person personArgs;
	@Resource(name = "personDefault")
	private Person personDefault;
	
	@RequestMapping("/Injection/Injection.do")
	public String execute(@RequestParam Map map,Model model) {
		//데이터 저장]
		//사용자 입력값으로 personDefault를 설정
		personDefault.setAddr(map.get("addr").toString());//get()키값은 
		personDefault.setAge(Integer.parseInt(map.get("age").toString()));
		personDefault.setName(map.get("name").toString());
		model.addAttribute("personInfo", personArgs +"<hr/>"+ personDefault);
		
		
		//뷰정보 반환
		return "Chap05_injection/Injection";
	}/////////////
}
