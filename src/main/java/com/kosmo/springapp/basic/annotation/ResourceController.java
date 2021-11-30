package com.kosmo.springapp.basic.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResourceController {

	// id -> 타입 -> Qualifier 
	//필드와 세터에만 붙일 수 있다.
	//반드시 IOC가 되어 빈이 생성되어 있어야한다. 그렇지 않으면 무조건 에러
	//Autowired - @Autowired(required = false) 이게 있지만
	//Resource - @Resource에는 없다.
	//아무것도 지정안하면 Type 기반이라서 Command로 찾는다
	//@Resource 만 설정시는 타입으로 찾아서 주입
	//[필드에 부착]
	/*
	@Resource(name = "fCommand")//name속성에 빈 설정파일에서 등록한 빈의 id속성값 설정
	private Command fCmd;
	@Resource(name = "sCommand")
	private Command sCmd;
	*/
	//[세터에 부착]
	private Command fCmd;
	private Command sCmd;
	@Resource(name = "fCommand")//name속성에 빈 설정파일에서 등록한 빈의 id속성값 설정
	public void setfCmd(Command fCmd) {
		this.fCmd = fCmd;
	}

	@Resource(name = "sCommand")
	public void setsCmd(Command sCmd) {
		this.sCmd = sCmd;
	}


	@RequestMapping("/Annotation/Resource.do")
	public String execute(Model model) {
		model.addAttribute("message", String.format("fCommand:%s,sCommand:%s", fCmd,sCmd));
		
		
		//뷰 정보 반환]
		return "Chap06_annotation/Annotation";
	}
}
