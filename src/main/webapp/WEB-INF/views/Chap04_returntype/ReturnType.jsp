<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!-- 상단메뉴 시작 -->	
<jsp:include page="/WEB-INF/views/template/Top_.jsp"/>
<!-- 상단메뉴 끝 -->

<!-- 실제 내용 시작 -->
<div class="container">
	
	<div class="page-header">
		<h1>스프링 <small>컨트롤러 메소드의 반환타입</small></h1>
	</div>
	<fieldset>
		<legend>컨트롤러 메소드의 반환타입</legend>
		<ul>
			<li><a href="<c:url value="/ReturnType/ModelAndView.do?returnType=ModelAndView!!!"/>">ModelAndView 반환</a></li>
			<li><a href="<c:url value="/ReturnType/String.do?returnType=String!!!"/>">String 반환</a></li>
			<li><a href="<c:url value="/ReturnType/Void.do?returnType=void!!!"/>">void(@Controller어노테이션 사용시 Ajax나 Rest API로 구현시 주로 사용)</a></li>
		</ul>
		<h2>결과값 출력</h2>
		<ul>			
			<li>\${requestScope.message } : ${requestScope.message }</li>
			<li>\${requestScope.returnType } : ${requestScope.returnType }</li>
			<li>\${param.returnType } : ${param.returnType }</li>
			
		</ul>		
	</fieldset>
	
	
</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp"/>
<!-- 푸터 끝 -->
