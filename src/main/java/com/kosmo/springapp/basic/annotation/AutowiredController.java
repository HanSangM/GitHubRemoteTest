package com.kosmo.springapp.basic.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AutowiredController {
	/*
	 * 테스트 시나리오
	 * 1. Type 체크,  Type기반
	 *  1-1. 빈 설정파일(servlet-context.xml)에 Command객체 하나 등록(id속성 / qualifier태그 생략)
	 *  		빈 설정파일에 Command객체 하나 등록(id속성/qualifier태그 생략)
	 *  	@Autowired
			private Command fCommand
			@Autowired
			private Command sCommand;
			
			fCommand와 sCommand는 같은 객체가 주입된다.
			
		1-2. 빈 설정파일에서 Command객체 등록 태그 주석처리
			500에러 발생
			
		1-3. 빈 설정파일에 Command객체 2개 등록 (id속성 / qualifier태그 생략)
			500에러 발생(객체가 2개 생성됨으로 타입이 같아서)
			
		1-4. @Autowired(required = false)  required속성 추가
			주입이 필수가 아니기 때문에 객체가 없으면 주입이 안되므로 
			fCommand와 sCommand는 null값이 나온다.
			
		2. id 기반
			빈 설정파일에서 id속성은 주입대상 클래스의 멤버필드명과 변수명을 일치 시켜라
		
		3. Qualifier 기반
		 3-1. 빈 설정파일에서 id속성 제거 - 에러발생
		 3-2. qualifier태그 추가 ( 식별자가 됨) -> <beans:qualifier value="식별자1"/>
		 3-3. 필드에 @Qualifier("식별자1") -> 변수명 넣으면됨
			
	 */
	/*
	//@Autowired : 타입 -> id -> Qualifier 
	//타입이 같으면 X , id 가지고 설정 하지만 id 없으면 Qualifier로 구별
	//[필드에 부착]
	//@Autowired(required = false)//
	@Autowired//default값이 true 인데 false주면 주입이 필수가 아니다란 뜻으로 주입이 안된다.
	@Qualifier("fCommand")
	private Command fCommand;//id 값과 맞춰주는게 좋다.
	
	@Autowired
	@Qualifier("sCommand")
	private Command sCommand;
	*/
	
	/*
	//[세터에 부착] - 가공이 필요할때,== 추가적인 로직이 필요할때
	//※ 이때는 빈 설정파일의 id속성값이 세터의 매개변수명과 일치 시켜야 한다
	private Command fCommand;//멤버변수명
	private Command sCommand;
	@Autowired
	public void setfCommand(Command fCommand) {//fCommand = 매개변수
		this.fCommand = fCommand;
	}
	@Autowired
	public void setsCommand(Command sCommand) {
		this.sCommand = sCommand;
	}*/
	
	//[생성자에 부착](단, @Qualifier 부착 불가)
	//※ 이때는 빈 설정파일의 id속성값이 생성자의 매개변수명과 일치 시켜야 한다
	private Command fCommand;//멤버변수명
	private Command sCommand;
	@Autowired
	public AutowiredController(Command fCommand, Command sCommand) {//생성자의 매개변수와 id를 일치 시켜야한다.
		this.fCommand = fCommand;
		this.sCommand = sCommand;
	}




	@RequestMapping("/Annotation/Autowired.do")
	public String execute(Model model) {
		model.addAttribute("message", String.format("fCommand:%s,sCommand:%s", fCommand,sCommand));
		
		
		//뷰 정보 반환]
		return "Chap06_annotation/Annotation";
	}
	
}/////////
