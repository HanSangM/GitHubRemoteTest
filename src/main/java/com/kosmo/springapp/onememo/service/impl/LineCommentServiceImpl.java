package com.kosmo.springapp.onememo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.springapp.onememo.service.LineCommentService;

@Service("commentService")//DAO 주입 받아야한다.
public class LineCommentServiceImpl implements LineCommentService {

	//LineCommentDAO주입]
	@Autowired
	private LineCommentDAO dao;//주입 받았다]
	
	@Override
	public List<Map> selectList(Map map) {		
		return dao.selectList(map);
	}

	@Override
	public String insert(Map map) {
		//영향받은 행의 수가 아니라 새로 입력된 레코드의 키값(lno)를 반환 받는다.
		int lno=dao.insert(map);//이름 반환
		String name=dao.findNameById(map.get("id").toString());
		return String.format("%s:%s", lno,name);
	}

	@Override
	public int delete(Map map) {
		
		return dao.delete(map);
	}

	@Override
	public int update(Map map) {
		
		return dao.update(map);
	}

}
