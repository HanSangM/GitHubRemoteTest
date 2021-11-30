package com.kosmo.springapp.basic.dynamicsql;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 컨트롤러에서 바로 DAO 주입 받아서 호출하자

@Repository
public class DynamicSqlDAO {

	@Autowired
	private SqlSessionTemplate template;

	public List if1(Map map) {
		return template.selectList("findOneMemoWithTitleLike", map);
	}////////////////////if1

	public List if2(Map map) {
		return template.selectList("findOneMemoLike", map);
	}////////////////////if2

	public List choose(Map map) {
		return template.selectList("findOneMemoLikeChoose", map);
	}////////////choose

	public List where(Map map) {
		return template.selectList("findOneMemoLikeWhere", map);
	}//////////////where

	public List trim1(Map map) {
		return template.selectList("findOneMemoLikeTrim", map);
	}/////////////trim1

	public int trim2(Map map) {
		return template.update("updateOneMemoLikeTrim", map);
	}/////////////trim2

	public int set(Map map) {
		return template.update("updateOneMemoSet", map);
	}///////////////set
	//Map 사용시
	/*
	public List foreach(Map map) {//"keyno" : 키, no 가 저장된 리스트 : 벨류
		return template.selectList("findOneMemoForeach",map);
	}*/
	public List foreach(List list) {
		return template.selectList("findOneMemoForeach",list);
	}////////////////foreach

	public int foreachExam(int[] email) {
		return template.delete("deleteEmail",email);
	}///////////////foreachExam
	
}
