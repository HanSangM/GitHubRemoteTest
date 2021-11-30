package com.kosmo.springapp.basic.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤러 클래스]
@Controller
public class OneMethodNoParamController {

	@RequestMapping("/Controller/OneMethodNoParam/{path}") //변수명 {path}
	public String noparam(@PathVariable String path,Map map) {//위에 변수명과 일치 시켜야한다.
		System.out.println(path);//List 확장자는 빠짐.
		//데이터 저장
		switch(path.toUpperCase()) {
			case "LIST" : map.put("message", "LIST");break;
			case "EDIT" : map.put("message", "EDIT");break;
			case "DELETE" : map.put("message", "DELETE");break;
			default: map.put("message", "VIEW");
		}
		//디스패처 서블릿에게 뷰정보 반환
		return "Chap02_controller/Controller";
	}/////////noparam
}
