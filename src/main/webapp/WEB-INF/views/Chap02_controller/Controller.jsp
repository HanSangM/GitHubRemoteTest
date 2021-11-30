<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!-- 상단메뉴 시작 -->	
<jsp:include page="/WEB-INF/views/template/Top_.jsp"/>
<!-- 상단메뉴 끝 -->

<!-- 실제 내용 시작 -->
<div class="container">
	
	<div class="page-header">
		<h1>스프링 <small>컨트롤러</small></h1>
	</div>
	
	<fieldset>
		<legend>컨트롤러 구현하기<span style="color: red;font-size: 0.9em">${requestScope.message}<c:if test="${! empty param.paramvar }">,파라미터:${param.paramvar}</c:if></span></legend>
		<h2>하나의 컨트롤러(클래스)로 여러 요청 처리하기(요청 수만큼 컨트롤러 메소드 생성)</h2>
		<ul>			
			<li><a href="<c:url value="/Controller/OneClass/List.do"/>">목록요청</a></li>
			<li><a href="<c:url value="/Controller/OneClass/Edit.do"/>">수정요청</a></li>
			<li><a href="<c:url value="/Controller/OneClass/Delete.do"/>">삭제요청</a></li>
			<li><a href="<c:url value="/Controller/OneClass/View.do"/>">상세보기요청</a></li>
		</ul>
		
		<h2>하나의 컨트롤러(메소드)로 여러 요청 처리하기 - @RequestMapping(String[]) 사용(String형 배열)</h2>
		<ul>			
			<li><a href="<c:url value="/Controller/OneMethod/List.do?paramvar=1"/>">목록요청</a></li>
			<li><a href="<c:url value="/Controller/OneMethod/Edit.do?paramvar=2"/>">수정요청</a></li>
			<li><a href="<c:url value="/Controller/OneMethod/Delete.do?paramvar=3"/>">삭제요청</a></li>
			<li><a href="<c:url value="/Controller/OneMethod/View.do?paramvar=4"/>">상세보기요청</a></li>
		</ul>
		
		<h2>하나의 컨트롤러(메소드)로 여러 요청 처리하기 - @RequestMapping("~/{변수}") 와 @pathVariable 사용(String형 배열)</h2>
		<ul>			
			<li><a href="<c:url value="/Controller/OneMethodNoParam/List.do"/>">목록요청</a></li>
			<li><a href="<c:url value="/Controller/OneMethodNoParam/Edit.do"/>">수정요청</a></li>
			<li><a href="<c:url value="/Controller/OneMethodNoParam/Delete.do"/>">삭제요청</a></li>
			<li><a href="<c:url value="/Controller/OneMethodNoParam/View.do"/>">상세보기요청</a></li>
		</ul>
		
		
	</fieldset>
	
	
</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp"/>
<!-- 푸터 끝 -->
