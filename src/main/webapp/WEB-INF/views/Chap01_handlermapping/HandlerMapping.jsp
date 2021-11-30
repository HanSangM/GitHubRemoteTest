<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!-- 상단메뉴 시작 -->	
<jsp:include page="/WEB-INF/views/template/Top_.jsp"/>
<!-- 상단메뉴 끝 -->

<!-- 실제 내용 시작 -->
<div class="container">
	
	<div class="page-header">
		<h1>스프링 <small>핸들러 매핑</small></h1>
	</div>
	<fieldset>
		<legend>HandlerMapping<span style="color: red;font-size: 1.4em">${message}</span></legend>
		<h2>디폴트(기본) 핸들러 매핑</h2>
		<ul>			
			<li><a href="<c:url value="/HandlerMapping/BeanNameUrl.do"/>">BeanNameUrlHandlerMapping</a></li>
			<li><a href="<c:url value="/HandlerMapping/Annotation.do"/>">DefaultAnnotationHandlerMapping</a></li>
		</ul>
		<h2>SimpleUrlHandlerMapping(기본 핸들러 매핑이 아님)</h2> <!-- 기본 매핑이 아니라서 자동생성 안됨 프레임워크가 생성 안해줌 -->
		<ul>			
			<li><a href="<c:url value="/HandlerMapping/SimpleUrlFirst.do"/>">SimpleUrlFirst.do</a></li>
			<li><a href="<c:url value="/HandlerMapping/SimpleUrlSecond.do"/>">SimpleUrlSecond.do</a></li>
		</ul>
		
		
	</fieldset>
	
	
</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp"/>
<!-- 푸터 끝 -->
