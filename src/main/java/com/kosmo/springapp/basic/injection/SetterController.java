package com.kosmo.springapp.basic.injection;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SetterController {

	//현재 클래스가 Person객체 필요] - new 하지않고 세터를 통해서 주입 받자
	
	//STEP 1] 멤버변수(속성) 선언
	/*
	 //방법 1] 속성에 붙이기(세터를 만들 필요 없다)
	@Resource(name = "personType")
	private Person personType;
	@Resource(name = "personIndex")
	private Person personProperty;
	*/
	
	private Person personType;
	private Person personProperty;
	
	//	@Qualifier테스트 시 
	//1. ConstructorController의 생성자 주석
	//2. 빈 설정파일(servlet-context.xml)에서 Person타입의 id속성 제거
	//3. @Resource()의 name 속성 제거
	
	
	//방법2] 세터에 붙이기 - 주입받은 값을 가공해서 속성해 넣을때
	@Resource//인자 설정 안하면 () 빼도 된다.
	@Qualifier("person1")
	public void setPersonType(Person personType) {
		personType.setAge(personType.getAge()*2);//가공하기
		this.personType = personType;
	}
	@Resource
	@Qualifier("person2")
	public void setPersonProperty(Person personProperty) {
		this.personProperty = personProperty;
	}
	
	
	
	public SetterController() {
		System.out.println("생성자-personType-"+personType);
		System.out.println("생성자-personProperty-"+personProperty);
	}
	//컨트롤러 메소드]
	@RequestMapping("/Injection/Setter.do")
	public String execute(Map map) {
		System.out.println("컨트롤러 메소드-personType-"+personType);
		System.out.println("컨트롤러 메소드-personProperty-"+personProperty);
		//데이터 저장]
		map.put("personInfo", personType+"<hr/>"+personProperty);
		//뷰정보 반환
		return "Chap05_injection/Injection";
	}
}
