package com.kosmo.springapp.basic.ajax;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosmo.springapp.onememo.service.ListPagingData;
import com.kosmo.springapp.onememo.service.OneMemoDTO;
import com.kosmo.springapp.onememo.service.OneMemoService;

/*
 * 	사전준비:pom.xml에 jackson-databind라이브러리 의존성 추가
 *
	[Jackson]
	Java 객체(Map혹은 DTO)를 JSON으로 변환하거나
	JSON을 Java 객체(Map혹은 DTO)로 변환하는 라이브러리
	List계열 컬렉션 즉 List<Map> 혹은 List<DTO>는
	자바스크립트로 변환시 JSON배열로 변환된다
	예] [ {key1:value2,key2:value2,},{},{},{}...]
	
	Spring 3.0 이후로부터, Jacskon과 관련된 API를 제공
	Jackson라이브러리를 사용하면 자동화 처리 가능
	
	Jackson라이브러리 POM.XML에 설정시
	MessageConverter API인 MappingJacksonHttpMessageConverter API가
	작동하여 컨트롤러가 리턴하는 객체를 후킹하여 ObjectMapper API로 JSON
	형태의 문자열로 자동으로 변환하여 반환한다.	
	1.자바객체를 JSON으로 변환시
	writeValue(File객체,DTO혹은 MAP) :객체를 JSON파일(.json)로 변환	
	writeValueAsString(DTO혹은 MAP):객체를 JSON형식의 문자열로 변환
	writerWithDefaultPrettyPrinter().writeValueAsString(DTO혹은 MAP)
	2.JSON을 자바객체로 변환시
	readValue(File객체,DTO혹은 MAP):JSON파일(.json)에 있는 내용을 자바객체로 읽어들일때
	readValue(JSON형식 문자열,DTO혹은 MAP):JSON형식의 문자열을 자바객체로 읽어 들일때
 */

@Controller
public class AjaxController {

	@Autowired
	private OneMemoService service;
	
	//[ajax 미 사용] - 새로고침이 됨.
	//
	//
//	@RequestMapping("/Ajax/NoAjax.do")
//	public void noajax(@RequestParam Map map,HttpServletResponse resp) throws IOException {
//		//1] 컨텐츠 타입 설정
//		resp.setContentType("text/html; charset=UTF-8");
//		//2] 웹 브라우저에 출력하기 위한 출력 스트림 얻기
//		PrintWriter out=resp.getWriter();
//		//3] 비지니스 로직 호출
//		boolean isLogin=service.isLogin(map);
//		if(isLogin)
//			out.println("<h2>"+map.get("id")+"님 즐감하세요</h2>");
//		else {
//			out.println("<script>");
//			out.println("alert('아이디와 비번이 틀려요');");
//			out.println("history.back();");
//			out.println("</script>");
//		}
//		//4] 웹 브라우저와 연결된 스트림 닫기
//		out.close();
//	}
	
	@RequestMapping("/Ajax/NoAjax.do")
	public String noajax(@RequestParam Map map,Model model) {
		//1]서비스 호출]
		boolean isLogin=service.isLogin(map);
		//2]데이터 저장]
		model.addAttribute("isLogin", isLogin?map.get("id")+"님 반갑습니다":"회원정보 불일치");
		//3]뷰 정보 반환]
		return "Chap12_ajax/Ajax";
	}///////////////////////////
	
	/*
	 [AJAX 사용] - 페이지를 전송하지 않고 데이터만 전송
	 [TEXT로 응답할때]
	 - 반환타입은 void이거나
	 - 반환타입이 String인 경우는 @ResponseBody()어노테이션 사용
	 */
	/*
	@RequestMapping("/Ajax/AjaxText.do")
	public void ajaxText(@RequestParam Map map,HttpServletResponse resp) throws IOException {
		//1] 컨텐츠 타입 설정
		resp.setContentType("text/html; charset=UTF-8");
		//2] 웹 브라우저에 출력하기 위한 출력 스트림 얻기
		PrintWriter out=resp.getWriter();
		//3] 비지니스 로직 호출
		boolean isLogin=service.isLogin(map);
		//Y 혹은 N 값으로 응답할때 - 반드시 print()메소드로 안그러면 println은 줄바꿈이 추가됨
		//out.print(isLogin? "Y":"N");
		//일반 메시지로 응답할때
		out.print(isLogin? map.get("id")+"님 즐감!":"회원가입해..");
		//4] 웹 브라우저와 연결된 스트림 닫기
		out.close();
	}/////////////////////////////
	*/
	
	@RequestMapping(value="/Ajax/AjaxText.do",produces = "text/plain; charset=UTF-8")
	//@ResponseBody <-여기에 있어도 되고 밑에 들어가도된다. 이걸 쓰면 한글로 출력할때 한글 깨진다.
	public @ResponseBody String ajaxText(@RequestParam Map map) {
		//1]서비스 호출]
		boolean isLogin=service.isLogin(map);
		// Y 혹은 N 으로 응답할때
		//return isLogin? "Y":"N";
		//일반 메시지로 응답할때
		return isLogin? map.get("id")+"님 즐감하삼!":"회원가입하삼";
	}///////////////////////
	
	@Autowired
	private ObjectMapper mapper;	
	
	//JSON으로 응답할때]
	@RequestMapping(value="/Ajax/AjaxJson.do",produces = "application/json; charset=UTF-8")
	public @ResponseBody String ajaxJson(@RequestParam Map map) throws JsonProcessingException {
		//1]서비스 호출]
		boolean isLogin=service.isLogin(map);
		
		//ObjectMapper 미 사용 : 직접 json형식의 문자열 생성해서 반환.
		
		//반환 : -회원인 경우- {"isLogin":"방가방가"} -비회원인 경우- {"isLogin":"다음기회에"}
//		return String.format("{\"isLogin\":\"%s\",\"id\":\"%s\",\"pwd\":\"%s\"}",
//			isLogin?"방가방가":"다음기회에",
//			map.get("id"),
//			map.get("pwd"));
		//[ObjectMapper 사용]
		//Map을 JSON형식의 문자열로 변경 - writeValueAsString()메소드로
		//{"id":"KIM","pwd":"1234","isLogin":"방가방가"}
		map.put("isLogin",isLogin?"방가방가":"다음기회에");
		System.out.println(mapper.writeValueAsString(map));
		return mapper.writeValueAsString(map);
		
	}//////////////////////////////
	
	@RequestMapping(value="/Ajax/AjaxJsonArray.do",produces = "application/json; charset=UTF-8")
	public @ResponseBody String ajaxJsonArray(@RequestParam Map map, HttpServletRequest req) throws JsonProcessingException {
		//1] 서비스 호출
		ListPagingData<OneMemoDTO> datas= service.selectList(map, req, 1);
		List<OneMemoDTO> lists= datas.getLists();
		
		
				
		//System.out.println(mapper.writeValueAsString(lists));
		
		/*
		  
		 */
		
		
		return mapper.writeValueAsString(lists);
	}
	
	@RequestMapping(value="/Ajax/AjaxCourse.do",produces = "application/json; charset=UTF-8")
	public @ResponseBody String ajaxCourse(@RequestParam String course) throws JsonProcessingException {
		Map map = new HashMap();
		switch(course) {
			case "java":
				map.put("j01", "자바");
				map.put("j02", "JSP");
				map.put("j03", "스프링");
				break;
			case "dotnet":
				map.put("j01", "C#");
				map.put("j02", "ASP.NET");
				map.put("j03", "WPF4");
				break;
			default:
				map.put("i01", "라즈베리 파이");
				map.put("i02", "파이썬");
					
		}
		
		return mapper.writeValueAsString(map);
	}////////////////////////////////////////
	
	//[Key=value 쌍으로 데이터 받기]
	@RequestMapping("/Ajax/form.do")
	public String form(OneMemoDTO dto,Model model) throws StreamWriteException, DatabindException, IOException {
		//[자바객체를 JSON으로 변환]
		//1. JSON 파일로 저장
		mapper.writeValue(new File("onememo.json"), dto);
		//2. JSON형태의 문자열로 변환
		String json=mapper.writeValueAsString(dto);
		System.out.println(json);
		model.addAttribute("formRequestResult", json);
		return "Chap12_ajax/Ajax";
	}/////////////////////
	
}
