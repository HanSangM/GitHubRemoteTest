package com.kosmo.springapp.basic.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
@RestController : 주로 데이터만 보낼때, @Controller + @ResponseBody 와 같다.
웹서비스를 구현할때 많이 사용, 요청하면 데이터만 제공 주로 JSON으로 백엔드쪽
@Controller 주로 페이지를 보낼때 (클라이언트로)
*/
/*
 * 
 */
//@Controller
@RestController
public class RequestBodyController {
	
	//클라이언트에서 데이터를 폼으로 받거나(폼으로 받는건 Spring 프레임워크 지원 - 커맨드객체 지원)
	//JSON으로 받은 데이터를 커맨드객체로 변환.(이때는 jackson라이브러리가 있어야한다)
	//다시 커맨드객체 반환(JSON으로 변환되서 반환)
	/*
	 	Form데이터를 받을때는 @ModelAttribute나 혹은 생략
	 	(단,@RequestBody는 415에러: Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported) 
	 	직접 받을 수 있다.
	 	JSON데이터를 받을때는 @RequestBody 사용 - 필요하다.
	 */
	//스프링에선 커맨드객체가  DTO계열(?)
	@RequestMapping("/Annotation/RequestBody.do")
	//@ResponseBody //@RestController 사용시는 주석처리. POSTMAN툴로 테스트 하거나 자바 스크립트로 POST요청
	public LoginCommand exec(@RequestBody LoginCommand cmd) {//JSON -> 자바타입(LoginCommand) - jackson라이브러리가 변환해준다.
		//public LoginCommand 가 JSON으로 변환되서 브라우저
		System.out.println("아이디:"+cmd.getUser());
		System.out.println("비번:"+cmd.getPass());
		return cmd;//자바타입(LoginCommand) -> JSON으로 변환 - jackson라이브러리가 변환해준다.
	}//////////////////
	//커맨드 객체를 받고 그대로 다시 커맨드객체 반환
}
