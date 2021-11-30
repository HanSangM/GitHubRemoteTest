package com.kosmo.springapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 [일반 자바클래스 형태 즉 POJO(Plain Old Java Object)]
 
 컴파일러에게 "아래 클래스는 사용자 요청을 처리하는 클래스야" 라고 알려주는 역할]
 - 컨트롤러 클래스
 */
//컨트롤러 클래스
@Controller
public class IndexController {
	//컨트롤러 메소드]
	//아래 있는게 사용자 요청 - 사용자 요청과 메소드를 매핑시켜줘야한다.
	@RequestMapping("/handlermapping.do")
	public String handlerMapping() {
		//뷰정보 반환] - 디스패처서블릿에게 
		return "Chap01_handlermapping/HandlerMapping"; //디렉토리명/파일이름 순으로 
	}/////////////handlerMapping
	
	@RequestMapping("/controller.do")
	public String controller() {
		//뷰정보 반환]
		return "Chap02_controller/Controller";
	}/////////////handlerMapping
	
	@RequestMapping("/viewresolver.do")
	public String viewresolver() {
		//뷰정보 반환]
		return "Chap03_viewresolver/ViewResolver";
	}/////////////handlerMapping
	
	@RequestMapping("/returntype.do")
	public String returntype() {
		//뷰정보 반환]
		return "Chap04_returntype/ReturnType";
	}/////////////handlerMapping
	
	@RequestMapping("/injection.do")
	public String injection() {
		//뷰정보 반환]
		return "Chap05_injection/Injection";
	}/////////////handlerMapping
	
	@RequestMapping("/annotation.do")
	public String annotation() {
		//뷰정보 반환]
		return "Chap06_annotation/Annotation";
	}/////////////handlerMapping
	
	@RequestMapping("/database.do")
	public String database() {
		//뷰정보 반환]
		return "Chap07_database/Database";
	}/////////////handlerMapping
	
	@RequestMapping("/resource.do")
	public String resource() {
		//뷰정보 반환]
		return "Chap08_resource/Resource";
	}/////////////handlerMapping
	
	@RequestMapping("/validation.do")
	public String validation() {
		//뷰정보 반환]
		return "Chap09_validation/Validation";
	}/////////////handlerMapping
	@RequestMapping("/dynamicsql.do")
	public String dynamicsql() {
		//뷰정보 반환]
		return "Chap11_dynamicsql/DynamicSQL";
	}/////////////handlerMapping
	
	@RequestMapping("/ajax.do")
	public String ajax() {
		//뷰정보 반환]
		return "Chap12_ajax/Ajax";
	}/////////////handlerMapping
	
	
	
	
}
