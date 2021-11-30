package com.kosmo.springapp.onememo.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;

//@Transactional() 여기다가 넣어도 된다
public interface OneMemoService {
	//로그인 용]
	boolean isLogin(Map map);
	
	//목록용]-전체목록 가져오는 용
	ListPagingData<OneMemoDTO> selectList(Map map,HttpServletRequest req,int nowPage);
	//전체 레코드 수]
	int getTotalRecord(Map map);//검색때문에 map으로 받는다
	//상세보기 용]
	OneMemoDTO selectOne(Map map);//map으로 받는 이유 : 나중에 파라미터받을때 requestMap으로 받으면 편하다
	//입력/수정/삭제용]
	int insert(Map map);
	int delete(Map map);
	int update(Map map);
	
	//아이디로 이름 찾기
	//String findNameById(String id);
	
}
