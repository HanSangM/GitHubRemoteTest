<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!-- 상단메뉴 시작 -->	
<jsp:include page="/WEB-INF/views/template/Top_.jsp"/>
<!-- 상단메뉴 끝 -->

<!-- 실제 내용 시작 -->
<div class="container">
	
	<div class="page-header">
		<h1>스프링 <small>ViewResolver</small></h1>
	</div>
	<fieldset>
		<legend>뷰 리졸버<span style="color: red;font-size: 1.4em">Scope : ${message},Parameter : ${param.message}</span></legend>
		<a href="<c:url value="/ViewResolver/ViewResolver.do"/>">InternalResourceViewREsolver</a>
		
	</fieldset>
	
	
</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp"/>
<!-- 푸터 끝 -->
