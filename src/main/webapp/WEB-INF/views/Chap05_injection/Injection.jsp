<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!-- 상단메뉴 시작 -->	
<jsp:include page="/WEB-INF/views/template/Top_.jsp"/>
<!-- 상단메뉴 끝 -->

<!-- 실제 내용 시작 -->
<div class="container">
	
	<div class="page-header">
		<h1>스프링 <small>Dependency Injection(의존성 주입)</small></h1>
	</div>
	<fieldset>
			<legend>의존성 주입(DI)</legend>
			<span style="color: green; font-size: 1.2em">${personInfo }</span>
			<ul style="list-style: decimal;">
				<li><a href="<c:url value="/Injection/Constructor.do"/>">생성자
						인젝션(Constructor Injection)</a></li>
				<li><a href="<c:url value="/Injection/Setter.do"/>">세터
						인젝션(Setter Injection)</a></li>
			</ul>
		</fieldset>
		<fieldset>
			<legend>DI로 객체 사용하기</legend>
			<form action="<c:url value='/Injection/Injection.do'/>" method="post">
				<table class="table table-bordered"
					style="border-spacing: 1px; background-color: gray; width: 450px">
					<tr style="background-color: white">
						<td style="width: 25%">이름</td>
						<td><input type="text" name="name" style="width: 80%" /></td>
					</tr>
					<tr style="background-color: white">
						<td style="width: 25%">주소</td>
						<td><input type="text" name="addr" style="width: 80%" /></td>
					</tr>
					<tr style="background-color: white">
						<td style="width: 25%">나이</td>
						<td><input type="text" name="age" style="width: 80%" /></td>
					</tr>
					<tr style="background-color: white; text-align: center">
						<td colspan="2"><input type="submit" value="확인" /></td>
					</tr>
				</table>
			</form>
		</fieldset>
	
	
</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp"/>
<!-- 푸터 끝 -->
