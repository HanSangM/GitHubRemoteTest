package com.kosmo.springapp.basic.validation;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidationController {
	/*
	//방법1] 스프링 API사용하지 않고 유효성 검증하기
	@RequestMapping("/Validation/ValidationCheck.do")
	public String exec(FormCommand cmd,Model model) {//RequestBody 붙이면 405에러 데이터 받을때만 쓴다(?)
		//model = 디스패처 서블릿이 빈 바구니로 넘겨준다 값을 넣어달라고
		System.out.println("성별:"+cmd.getGender());
		System.out.println("관심사항:"+cmd.getInters());
		
		
		if(!validate(cmd,model)) {//유효성 실패
			
			//※${param.inters}로 출력시 선택한 처음것만 출력됨으로
			model.addAttribute("inters", Arrays.toString(cmd.getInters()));//체크된거 유지용
			//뷰 정보 반환]- 다시 입력폼으로 이동
			return "Chap09_validation/Validation";
			
		}
		//데이터 저장]
		//줄바꿈 처리용]
		model.addAttribute("self", cmd.getSelf().replace("\r\n", "<br/>"));
		//관심사항 츌력용
		model.addAttribute("inters", cmd.getInters());//체크된거 유지용
		//뷰 정보 반환]
		return "Chap09_validation/ValidationComplete";
	}
	
	//내가 만든 유효성 검증용 메소드]
	private boolean validate(FormCommand cmd,Model model) {//FormCommand cmd 지역변수(매개변수) 사용자가 입력한 값이 cmd에 있으니까
		if(cmd.getName().trim().equals("")){//null일 수가 없다.
			model.addAttribute("nameError", "이름을 입력하세요");
		}
		if(cmd.getYears().trim().length()==0){//String이니까 length로 해도된다.
			model.addAttribute("yearsError", "나이를 입력하세요");
			return false;
		}
		else {//나이를 입력했다면 숫자인지 아닌지 판단
			try {//숫자가 아니라면
				Integer.parseInt(cmd.getYears().trim());
			}
			catch(Exception e) {
				model.addAttribute("yearsError", "나이는 숫자만..");
				return false;
			}
		}
		if(cmd.getGender() ==null){
			model.addAttribute("genderError", "성별을 선택하세요");
			return false;
		}
		if(cmd.getInters() ==null){
			model.addAttribute("intersError", "관심사항을 선택하세요");
			return false;
		}
		else {
			if(cmd.getInters().length < 2) {
				model.addAttribute("intersError", "관심사항은 2개이상 선택하세요");
				return false;
			}
		}
		if(cmd.getGrade().length()==0){
			model.addAttribute("gradeError", "학력을 선택하세요");
			return false;
		}
		if(cmd.getSelf().trim().length()==0){
			model.addAttribute("selfError", "자기소개를 입력하세요");
			return false;
		}
		return true;
	}///////////////////
	*/
	
	
	//방법2] 스프링 API 사용
	@Autowired
	private FormValidator validator;
	
	
	@RequestMapping("/Validation/ValidationCheck.do")
	public String exec(FormCommand cmd,BindingResult errors, Model model) {//매개변수 순서 : ※FormCommand다음에 BindingResult순으로
		/*
		 * 내가 만든 Validator클래스의 validate()호출 
		 * validate()메소드 첫번째 매개변수에 유효성 검증 해달라고 커맨드 객체 넣어주고 
		 * 두번째 매개변수에는 에러정보를 담아 달라고 Errors타입 전달
		 */
		
		validator.validate(cmd, errors);
		/*
		  FormValidator에서 한번이라도 
		  rejectValue()를 한다면
		  BindingResult타입의 hasErrors()메소드는 true반환
		  */
		if(errors.hasErrors()) {
			model.addAttribute("inters", Arrays.toString(cmd.getInters()));//체크된거 유지용
			return "Chap09_validation/Validation";
		}
		//줄바꿈 처리용]
		model.addAttribute("self", cmd.getSelf().replace("\r\n", "<br/>"));
		//관심사항 출력용
		model.addAttribute("inters",cmd.getInters());
		//뷰 정보 반환]
		return "Chap09_validation/ValidationComplete";
	}
	
	
}
