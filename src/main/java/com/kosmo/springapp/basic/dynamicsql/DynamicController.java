package com.kosmo.springapp.basic.dynamicsql;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mybatis")
public class DynamicController {

	//DAO주입
	@Autowired
	private DynamicSqlDAO dynamic;
	
	
	@RequestMapping("/If1.do")
	public String if1(@RequestParam Map map,Model model) {
		List list= dynamic.if1(map);
		model.addAttribute("message", "검색된 총 글 수:"+list.size());
		return "Chap11_dynamicsql/DynamicSQL";
	}/////////////////if1
	
	@RequestMapping("/If2.do")
	public String if2(@RequestParam Map map,Model model) {
		List list= dynamic.if2(map);
		model.addAttribute("message", "검색된 총 글 수:"+list.size());
		return "Chap11_dynamicsql/DynamicSQL";
	}/////////////////if2
	
	@RequestMapping("/choose.do")
	public String choose(@RequestParam Map map,Model model) {
		List list= dynamic.choose(map);
		model.addAttribute("message", "검색된 총 글 수:"+list.size());
		return "Chap11_dynamicsql/DynamicSQL";
	}/////////////////if1
	
	@RequestMapping("/where.do")
	public String where(@RequestParam Map map,Model model) {
		List list= dynamic.where(map);
		model.addAttribute("message", "검색된 총 글 수:"+list.size());
		return "Chap11_dynamicsql/DynamicSQL";
	}/////////////////if1
	
	@RequestMapping("/trim1.do")
	public String trim1(@RequestParam Map map,Model model) {
		List list= dynamic.trim1(map);
		model.addAttribute("message", "검색된 총 글 수:"+list.size());
		return "Chap11_dynamicsql/DynamicSQL";
	}/////////////////if1
	
	@RequestMapping("/trim2.do")
	public String trim2(@RequestParam Map map,Model model) {
		
		if(!(map.get("title")==null && map.get("content")==null))
			model.addAttribute("message", "수정된 총 글 수:"+dynamic.trim2(map));
		else
			model.addAttribute("message", "제목이나 내용 둘 중 하나는 전송하세요");		
		return "Chap11_dynamicsql/DynamicSQL";
	}/////////////////if1
	
	@RequestMapping("/set.do")
	public String set(@RequestParam Map map,Model model) {
		
		if(!(map.get("title")==null && map.get("content")==null))
			model.addAttribute("message", "수정된 총 글 수:"+dynamic.set(map));
		else
			model.addAttribute("message", "제목이나 내용 둘 중 하나는 전송하세요");		
		return "Chap11_dynamicsql/DynamicSQL";
	}/////////////////if1
	
	@RequestMapping("/foreach.do")
	public String foreach(Model model) {
		
		List list = Arrays.asList(98,99,100,102,150);//List 쉽게 만드는 방법
		/*
		//1. Map인 경우
		Map map = new HashMap();
		map.put("keyno", list);
		List resultList=dynamic.foreach(map);
		*/
		//2. List인 경우
		List resultList=dynamic.foreach(list);
		model.addAttribute("message", "검색된 총 글수:"+resultList.size());
		
		return "Chap11_dynamicsql/DynamicSQL";
	}///////////////////
	@RequestMapping("/foreachExam.do")
	public String foreachExam(Model model,@RequestParam int[] email) {
		
		int affected = dynamic.foreachExam(email);
		model.addAttribute("message", "삭제된 총 글수:"+affected);
		return "Chap11_dynamicsql/DynamicSQL";
	}///////////////////////////////
}
