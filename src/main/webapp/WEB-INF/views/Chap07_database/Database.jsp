<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!-- 상단메뉴 시작 -->	
<jsp:include page="/WEB-INF/views/template/Top_.jsp"/>
<!-- 상단메뉴 끝 -->

<!-- 실제 내용 시작 -->
<div class="container">
	
	<div class="page-header">
		<h1>스프링 <small>Database</small></h1>
	</div>
	<fieldset>
		<legend>데이터베이스 연동<span style="color: red;font-size: .8em">${message}${param.method}</span></legend>
		<h2>디폴트(기본) 핸들러 매핑</h2>
		<ul>			
			<li><a href="<c:url value="/Database/JDBConnection.do?method=JDBC"/>">스프링 JDBC API사용</a></li>
			<li><a href="<c:url value="/Database/JNDIConnection.do?method=JNDI"/>">스프링 JNDI API사용</a></li>
		</ul>		
	</fieldset>
	
	
</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp"/>
<!-- 푸터 끝 -->
