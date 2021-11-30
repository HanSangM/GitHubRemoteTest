package com.kosmo.springapp.basic.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 1. 확장자가 .properties인 리소스 파일 src/main/resources 에 생성
 *    (하위 폴더 생성시에는 new->package로 생성)
 * 2. servlet-context.xml파일에 <context:property-placeholder>등록
 * 3. 클래스에서 사용시에는 @Value어노테이션 사용
 *
 */

@Controller
public class ResourceValueController {

	//주입받기
	@Autowired
	private UserCommand command;
	/*
	 * 
	 */
	
	@Value("${name}")
	private String name;
	@Value("${user}")
	private String username;
	@Value("${pass}")
	private String password;
	
	
	@RequestMapping("/Resource/Resource.do")
	public String exec(Model model) {
		//데이터 저장]
		model.addAttribute("resource", command);
		model.addAttribute("value", 
				String.format("[name:%s,username:%s,password:%s]",
						name,username,password));
		
		
		//뷰정보 반환]
		return "Chap08_resource/Resource";
	}
}
