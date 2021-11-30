package com.kosmo.springapp.basic.annotation;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*
@SessionAttributes() 어노테이션]
- 서블릿 API(HttpSession)를 사용하지 않고 세션처리를 하기위한 어노테이션
- 클래스 앞에 붙인다.
- 세션변수(세션 영역에 저장한 속성명)에 값을 저장하려면
    메소드의 매개변수중 모델계열(Model,Map,ModelMap)
   을 추가하여 add계열("세션변수명",값)으로
   저장하면 그 이름으로
   세션영역에도 저장된다.(리퀘스트 영역뿐만 아니라)
   
예] @SessionAttributes("세션변수명")
 ※세션변수명이 여러개일때
 @SessionAttributes({"세션변수명1","세션변수명2",...})
 
-세션영역에서 값 읽어올때
 컨트롤러 메소드(@ModelAttribute(value="세션변수명")  String 세션값받을변수) 객체일수도있음
 
-세션해제

컨트롤러 메소드(SessionStatus session){
session.setComplete();
}
*/
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

//1. 커맨드 객체 미 사용 - 아이디 / 비번 파라미터를 맵으로 받을 시
//세션영역에 저장할 속성명은 폼의 파라미터명과 일치시켜라 ※
//@SessionAttributes({"user","pass"}) // 속성(변수)명은 user 와 pass가 되는것

//2. 커맨드 객체를 사용해서 세션 처리하기 - 아이디 / 비번 파라미터를 커맨드 객체로 받을시
@SessionAttributes(types = LoginCommand.class)//중괄호를 붙여야하지만 1개일땐 안붙여도된다.
@Controller
@RequestMapping("/Annotation")
public class SessionAttributeController {
//	
//	//[서블릿 API 사용]
//	//로그인 처리]
//	@RequestMapping("/SessionAttributeLogin.do")
//	public String login(HttpSession session,@RequestParam Map map,Model model) {
//		//데이터 저장]
//		//회원 여부 판단
//		if("KIM".equals(map.get("user"))/* "user" 맵의 키값 */ && "1234".equals(map.get("pass"))) {
//			//로그인 처리 - 세션영역에 필요값 저장
//			session.setAttribute("user" /* 변수 "user" */, map.get("user"));
//		}
//		else {
//			model.addAttribute("errorMessage", "아이디와비번이 일치하지 않아요");
//		}
//		
//		//뷰 정보 반환]
//		return "annotation06/Annotation";
//	}//////////////
//	//로그인 여부 판단]
//	@RequestMapping("/isLogin.do")
//	public String isLogin(HttpSession session,ModelMap model) {
//		//로그인 여부 판단 - 세션영역에 존재 유무로 판단 후 데이터 저장]
//		model.addAttribute("isLoginMessage", session.getAttribute("user")==null?"로그인 하세요" : "로그인 되었습니다" );
//		
//		
//		//뷰 정보 반환]
//		return "annotation06/Annotation";
//	}////////////
//	//로그아웃]
//	@RequestMapping("/SessionAttributeLogout.do")
//	public String logout(HttpSession session) {
//		//로그아웃 처리 - 세션영역에 저장된 속성 삭제]
//		session.invalidate();
//		
//		//뷰 정보 반환]
//		return "annotation06/Annotation";
//	}//////////////
	//[@SessionAttribute 어노테이션 사용]
	//[1.세션영역에 저장할 속성명을 문자열로 지정시-예:@SessionAttributes({"user","pass"})]
	//로그인 처리]
//	@RequestMapping("/SessionAttributeLogin.do")
//	public String login(@RequestParam Map map,Model model) {//영역에 저장해야하니까 Model, Command 안하니까@RequestParam 으로 받는다 
//		//회원 여부 판단
//		if("KIM".equals(map.get("user"))/* "user" 맵의 키값 */ && "1234".equals(map.get("pass"))) {
//			//로그인 처리 - 세션영역에 필요값 저장// model에만 저장하면 된다
//			//@SessionAttributes 사용시 세션 및 리퀘스트 두 영역에 저장됨.
//			model.addAllAttributes(map);
//		}
//		else {
//			model.addAttribute("errorMessage", "아이디와비번이 일치하지 않아요");
//		}
//		//뷰 정보 반환]
//		return "annotation06/Annotation";
//	}//////////////////
//	//로그아웃]
//	@RequestMapping("/SessionAttributeLogout.do")
//	public String logout(SessionStatus status) {
//		//로그아웃 처리 - 세션영역에 저장된 속성 삭제]
//		status.setComplete();
//		//뷰 정보 반환]
//		return "annotation06/Annotation";
//	}////////////////
//	//로그인 여부 판단] - 세션영역에 반드시 user라는 속성(키)이 존재해야 한다. 그렇지 않으면 에러
//	//세션영역에서 getAttribute 할 필요 없다 - 세션영역에서 바로 읽어오니까
//	@RequestMapping("/isLogin.do")
//	public String isLogin(@ModelAttribute("user") String id,Model model) {//user라는 속성을 찾는다 없으면 100% 에러 있으면 id에 넣어준다
//		model.addAttribute("isLoginMessage", id+"님 로그인 되었습니다");
//		//뷰 정보 반환]
//		return "annotation06/Annotation";
//	}//////////////
	@ExceptionHandler({Exception.class})
	public String error(Model model) {
		model.addAttribute("isLoginMessage", "로그인 하세요!!!");
		//뷰 정보 반환]
		return "Chap06_annotation/Annotation";
	}
	
	//[2. 커맨드 객체 사용]
	//로그인 처리]
	@RequestMapping("/SessionAttributeLogin.do")
	public String login(LoginCommand cmd,Model model,SessionStatus status) {
		//데이터 저장
		//회원여부 판단]
		//※키값은 자동으로 소문자로 시작하는 커맨드 클래스명이  키값(loginCommand)이 됨			
		//  매개변수의 LoginCommand객체가 무조건(회원이든 아니든)자동으로 세션 영역에 저장됨
		//  단,빈 설정 파일에 <annotation-driven/>태그 추가해야됨
		//  예]session.setAttribute("loginCommand",cmd)식으로 저장됨
		if(!("KIM".equals(cmd.getUser()) && "1234".equals(cmd.getPass()))) {//회원이 아닐시
			//로그인 처리 - 세션영역에 필요값 저장
			model.addAttribute("errorMessage", "아이디/비번 불일치");
			//무조건 커맨드객체를 세션영역에 저장하기 떄문에
			//회원이 아닌 경우는 삭제 해줘야한다.			
			status.setComplete();//지워줘야한다.
		}
		//뷰 정보 반환]
		return "Chap06_annotation/Annotation";
		}
		//로그아웃]
		@RequestMapping("/SessionAttributeLogout.do")
		public String logout(SessionStatus status) {
			//로그아웃 처리 - 세션영역에 저장된 속성 삭제]
			status.setComplete();
			//뷰 정보 반환]
			return "Chap06_annotation/Annotation";
		}////////////////
		//로그인 여부 판단] - 세션영역에 반드시 user라는 속성(키)이 존재해야 한다. 그렇지 않으면 에러
		//세션영역에서 getAttribute 할 필요 없다 - 세션영역에서 바로 읽어오니까
		@RequestMapping("/isLogin.do")
		public String isLogin(@ModelAttribute("loginCommand") LoginCommand cmd,Model model,HttpSession session) {//user라는 속성을 찾는다 없으면 100% 에러 있으면 id에 넣어준다
			//서블릿 API(HttpSession)으로 세션영역에 저장된 값 읽어오기(테스트용)
			System.out.println("테스트용:"+((LoginCommand)session.getAttribute("loginCommand")).getUser());
			model.addAttribute("isLoginMessage", cmd.getUser()+"님 로그인 되었습니다");
			//뷰 정보 반환]
			return "Chap06_annotation/Annotation";
		}//////////////
	
		/*
		@SessionAttribute 어노테이션 사용

		1.커맨드 객체 사용 안하는 경우 
		@SessionAttribute({"속성명1","속성명2",...}) 속성명은 폼의 파라미터 명과 반드시 일치 시켜라
		 [로그인] - 모델계열에 사용자가 입력한 아이디와 비번을 저장하면 세션영역에도 저장된다
		 login(Model model,@RequestParam Map map){
			회원 여바 판단후 회원이라면 model 에 map저장
		         	회원이 아니라면 model에 에러메시지 저장
		 }
		 [로그아웃]
		 logout(SessionStatus status){
			status.setComplete();
			}
		 	
		 [로그인여부 판단]
		 isLogin(@ModelAttribute("속성명1") String id,Model model){
			//메소드 안으로 들어 온다는 애기는 세션영역에 "속성명1" 존재한다는 말 고로 로그인이 되었다
		        //세션영역에 "속성명1" 없다면 무조건 500에러 - @ExceptionHandler 나 설정파일로 에러 처리
		        model에 로그인되었다는 정보를 저장
			
		}
		2.커맨드 객체 사용하는 경우
		-※빈 설정 파일에 <annotation-driven/>태그 추가

		@SessionAttribute(types=커맨드객체 클래스명.class) 
		 [로그인] - 아이디와 비번을 커맨드객체로 받는다 이때 커맨드 객체는 회원이든 아니든 무조건 세션영역에 저장된다
		              세션 영역에 저장될때 소문자로 시작하는 커맨드객체 클래명(loginCommand)이 키값이 된다
		              value값은 당연히 커맨드 객체가 된다
			

		 login(Model model,LoginCommand cmd,SessionStatus status){
			회원이 아닌 경우를 판단해서
		         세션영역에 저장된 커맨드를 객체를 status.setComplete()로 삭제해한다
		         model에는 에러메시지 저장
		 }
		 [로그아웃]
		 logout(SessionStatus status){
			status.setComplete();
		}
		 [로그인여부 판단]
		 isLogin(@ModelAttribute("loginCommand") LoginCommad cmd,Model model){
			//메소드 안으로 들어 온다는 애기는 세션영역에 "loginCommand" 존재한다는 말 고로 로그인이 되었다
		        //세션영역에 "loginCommand" 없다면 무조건 500에러 - @ExceptionHandler 나 설정파일로 에러 처리
		        model에 로그인되었다는 정보를 저장
			}

		*/
}
