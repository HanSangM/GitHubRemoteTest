package com.kosmo.springapp.onememo.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo.springapp.onememo.service.ListPagingData;
import com.kosmo.springapp.onememo.service.OneMemoDTO;
import com.kosmo.springapp.onememo.service.OneMemoService;
import com.kosmo.springapp.onememo.service.impl.OneMemoServiceImpl;

/*
※스프링 씨큐리티 사용시에는 기존 방식의 로그인처리 및 로그인 여부 판단 그리고 로그아웃등
  모두 제거한다(.jsp 에서 혹은 .java에서)
  그리고 나서 스프링 씨큐리티에서 제공하는 API로 처리한다
  단,로그인처리 및 로그아웃은 스프링 씨큐리티에서 제공함으로  로그인 판단 여부만 처리하면 된다.
*/

@SessionAttributes("id")//하나면 대괄호 안써도 된다. 스프링 씨큐리티를 사용할때 주석
@RequestMapping("/onememo/bbs/")
@Controller
public class OneMemoController {

	//서비스 호출해야하므로 서비스 주입]
	@Resource(name="memoService")
	private OneMemoService memoService;//인터페이스가 부모니까 OneMemoServiceImpl대신 써도 됨
	
	//목록 처리]
	@RequestMapping("List.do")
	public String list(					
						@RequestParam Map map,//nowPage가 map에 있지만 따로 다시 받아도된다.
						//검색 파라미터 및 페이징용 키값 저장용
						@RequestParam(required = false,defaultValue = "1") int nowPage,//현재페이지용
						HttpServletRequest req,//페이징에 사용할 컨텍스트 루트 경로 얻기용
						Model model//저장용
			) {
		//주입을 받았으니 서비스 호출]
		ListPagingData<OneMemoDTO> listPagingData= memoService.selectList(map, req, nowPage);
		//호출을 받았으니 데이터 저장]
		model.addAttribute("listPagingData", listPagingData);
		//뷰 정보 반환]
		return "Chap10_onememo/bbs/List";
	}////////////////List
	
	
	//로그인 하지 않고 각 컨트롤러 메소드 실행시 오류 : @ModelAttribute("id") String id사용시
	//씨큐리티 사용시에는 아래 예외처리 불필요
	/*
	@ExceptionHandler({Exception.class})
	public String error(Model model) {
		model.addAttribute("NotMember", "로그인후 이용바람....");
		//로그인이 안된경우 로그인 페이지로
		return "Chap10_onememo/member/Login";
	}*/
	//입력폼으로 이동]
	@RequestMapping(value="Write.do",method = RequestMethod.GET)//Get방식이므로 GETMapping해도되고
	public String write(@ModelAttribute("id") String id//(씨큐리티 미 사용시)세션영역에서 id를 가져온다 -아이디가 저장이 안되어있다면 에러난다.
						) {
		
		
		//뷰 정보 반환]
		return "Chap10_onememo/bbs/Write";
	}/////////////////////
	
	//입력처리]
	@RequestMapping(value="Write.do",method = RequestMethod.POST)
	public String writeOk(@ModelAttribute("id") String id,
						@RequestParam Map map
			) {
		//서비스 호출]
		map.put("id", id);//씨큐리티 미 사용시. 호출전 아이디 맵에 저장
		memoService.insert(map);
		
		
		//뷰 정보 반환] - 목록으로 이동
		return "forward:/onememo/bbs/List.do";//앞뒤에 경로가 다 붙을때는 forward 붙여준다
	}
	
	//컨트롤러 메소드 작성 규칙]
	/*
	 * 접근지정자 : public
	 * 반환타입 : 주로 String(뷰정보를 문자열로 반환)
	 * 메소드명: 임의
	 * 인자 : 원하는 타입을 사용할 수 있다(단, 사용할 수 있는 타입이 정해져 있다)
	 *       어노테이션도 가능
	 * 예외를 throws할 수 있다(선택) 
	 */
	
	
	//상세보기]
	@RequestMapping("View.do")
	public String view(@ModelAttribute("id") String id,@RequestParam Map map,Model model) {
		//서비스 호출]
		OneMemoDTO record= memoService.selectOne(map);
		//데이터 저장]
		//줄바꿈 처리
		record.setContent(record.getContent().replace("\r\n","<br/>"));
		model.addAttribute("record", record);
		///////////////////////////
		//뷰정보 반환]
		return "Chap10_onememo/bbs/View";
		
		
	}
	/*
	//수정처리]
	@RequestMapping(value="Edit.do",method= RequestMethod.GET)
	public String update(@ModelAttribute("id") String id) {
			
		
		//뷰정보 반환]
		return "forward:/onememo/bbs/View.do";
	}/////////혼자 해본것
	*/
	
	
	//수정폼으로 이동 및 수정처리]
	@RequestMapping("Edit.do")
	public String edit(@RequestParam Map map,HttpServletRequest req) {
		if(req.getMethod().equals("GET")) {
			//서비스 호출]
			OneMemoDTO record= memoService.selectOne(map);
			//데이터 저장
			req.setAttribute("record", record);
			//수정폼으로 이동]
			return "Chap10_onememo/bbs/Edit";
		}
		//수정처리후 상세보기로 이동
		//서비스 호출
		memoService.update(map);
		//뷰로 포워드
		return "forward:/onememo/bbs/View.do";
	}//////////////////
	
	//삭제처리]
	@RequestMapping("Delete.do")
	public String delete(@RequestParam Map map) {
		//서비스 호출
		memoService.delete(map);
		//뷰로 포워드
		return "forward:/onememo/bbs/List.do";
		
	}
	
	
}//////////////////
