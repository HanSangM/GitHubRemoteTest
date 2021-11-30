package com.kosmo.springapp.onememo.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosmo.springapp.onememo.service.impl.LineCommentServiceImpl;

@SessionAttributes({"id"})//씨큐리티 사용시 주석
@RestController//뷰 리졸버가 작동 안한다 -> 접두어, 접미어 안붙는다
public class CommentsController {

	//서비스 주입 받아야한다.
	//서비스 주입]
	@Autowired
	private LineCommentServiceImpl commentService;//주입 완료
	//ObjectMapper API(Jackson에 포함된 클래스) 주입:빈 설정파일에 등록 혹은 SpringBeanConfig클래스에 @Bean으로 등록
	
	@Autowired
	private ObjectMapper mapper;//자바객체를 JSON객체로 변환 시키기 위한 주입
	/*
	 * @RequestParam : key - value쌍으로 받을때
	 * 					1.form으로 전송시
	 *                 <form action="my.do" enctype="x-www-form-urlencoded">
	 *                 	<input type="text" name="age"/>
	 *                 </form>
	 *                
	 * 					key : age ,value : 사용자 입력값
	 * 					전송방식 즉 post 혹은 get상관없다
	 * 					 2.쿼리 스트링으로 전송시
	 * 	                <a href="my.do?age=30">클릭</a>
	 * 					key : age ,value : 30
	 * 
	 * @RequestBody : JSON으로 받을때 즉 자바스크립트 객체로 받을떼 사용
	 * 	
	 * produces = "text/plain;charset=UTF-8"은 응답바디에 쓰여진다
	 * Content-type:text/plain;charset=UTF-8
	 * 
	 * ※@RequestParam Map map으로 받은때는 요청을보낼때 JSON이 아니라 key=value형태로 보내야 한다
	 */
	
	//plain -> 일반 텍스트 라는 의미
	//html -> 페이지
	//ObjectMapper API 주입
	//아니면 여기서 String 대신 List를 써도된다.
	//1. String 반환시
	//@PostMapping(value="/onememo/comments/List.do",produces ="text/plain; charset=UTF-8")
	//public String list(@ModelAttribute("id") String id,@RequestParam Map map) throws JsonProcessingException {
	//2.List<Map>으로 반환시
	@PostMapping(value="/onememo/comments/List.do",produces = "application/json; charset=UTF-8")	
	public List<Map> list(@ModelAttribute("id") String id,@RequestParam Map map) throws JsonProcessingException {
		//서비스 호출]
		List<Map> lists= commentService.selectList(map);
		//데이터 베이스에서 읽어온 값 : 2021-11-23 12:34:49.0
		if(lists.size() !=0)
			System.out.println("데이터베이스에서 읽어온 값:"+lists.get(0).get("LPOSTDATE"));
		//JACKSON이 List<Map>을 JSON형태 문자열로 변경시
		//날짜데이터를 2021-11-23 12:34:49.0에서 1637638489000로 변경해버린다.
		//숫자형태의 날짜를 년월일 형태의 문자열로 변경해서 다시 Map에 해당 키값으로 저장해야한다.
		for(Map comment:lists) {
			comment.put("LPOSTDATE", comment.get("LPOSTDATE").toString().substring(0, 10));
		}
		//데이타 반환]
		//String으로 반환시
		//String comments=mapper.writeValueAsString(lists);
		//return comments;
		//List<Map>으로 반환시
		return lists;
		
	}
	
	//코멘트 입력처리]
	@PostMapping(value="/onememo/comments/Write.do",produces ="text/plain; charset=UTF-8")
	public String write(@ModelAttribute("id") String id,@RequestParam Map map) {
		//map -> no, lno, linecomment만 넘어오니까 id도 받아야한다
		map.put("id", id);//(씨큐리티 미 사용시) 한줄 댓글 작성자의 아이디를 맵에 설정
		//서비스 호출]
		String commentInfo = commentService.insert(map);
		//데이터 반환]
		return commentInfo;//입력된 글의 키와 작성자 이름 문자열로 반환		
	}
	//코멘트 수정처리]
	@PostMapping(value="/onememo/comments/Edit.do",produces="text/plain; charset=UTF-8")
	public String update(@ModelAttribute("id") String id,@RequestParam Map map) {
		//서비스 호출]
		commentService.update(map);
		//수정한 글의 키값 반환
		return map.get("lno").toString();
	}//////////////////
	
	//코멘트 삭제처리]
		@PostMapping(value="/onememo/comments/Delete.do",produces="text/plain; charset=UTF-8")
		public String delete(@ModelAttribute("id") String id,@RequestParam Map map) {
			//서비스 호출]
			int affected=commentService.delete(map);
			//삭제된 행의 수를 반환
			return String.valueOf(affected);
		}///////////
	
	
	
	
}
