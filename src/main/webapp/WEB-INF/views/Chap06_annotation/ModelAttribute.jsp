<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<!-- 상단메뉴 시작 -->	
<jsp:include page="/WEB-INF/views/template/Top_.jsp"/>
<!-- 상단메뉴 끝 -->

<!-- 실제 내용 시작 -->
<div class="container">
	
	<div class="page-header">
		<h1>스프링 <small>Annotation-@ModelAttribute</small></h1>
	</div>
	<fieldset>
				<legend>@ModelAttribute어노테이션 결과 페이지</legend>
				
					<table class="table table-bordered" bgcolor="gray" cellspacing="1" width="60%">
						<tr bgcolor="white">
							<td>이름</td>
							<td><input type="text" name="name" value="${name}${cmd.name}"/></td>
						</tr>
						<tr bgcolor="white">
							<td>나이</td>
							<td><input type="text" name="years" value="${years}${cmd.years}"/></td>
						</tr>
						<tr bgcolor="white">
							<td>성별</td>
							
							<td><input type="radio" name="gender" value="남자" <c:if test="${gender=='남자' or cmd.gender=='남자'}">checked</c:if>/>남자
								<input type="radio" name="gender" value="여자" <c:if test="${gender=='여자' or cmd.gender=='여자'}">checked</c:if>/>여자</td>
						</tr>
						<tr bgcolor="white">
							<td>관심사항</td>
							
							<td>
							<input type="checkbox" name="inters" value="정치" <c:if test="${fn:contains(inters,'치') or fn:contains(cmd.inters,'치')}">checked</c:if>/>정치
							<input type="checkbox" name="inters" value="경제" <c:if test="${fn:contains(inters,'제') or fn:contains(cmd.inters,'제')}">checked</c:if>/>경제
							<input type="checkbox" name="inters" value="스포츠" <c:if test="${fn:contains(inters,'츠') or fn:contains(cmd.inters,'츠')}">checked</c:if>/>스포츠
							</td>
						</tr>
						
						<tr bgcolor="white">
							<td>학력</td>
							<td><select name="grade">
									<option value="초등학교" <c:if test="${fn:contains(grade,'초') or fn:contains(cmd.grade,'초')}">selected</c:if>>초등학교</option>
									<option value="중학교"  <c:if test="${fn:contains(grade,'중') or fn:contains(cmd.grade,'중')}">selected</c:if>>중학교</option>
									<option value="고등학교" <c:if test="${fn:contains(grade,'고') or fn:contains(cmd.grade,'고')}">selected</c:if>>고등학교</option>
									<option value="대학교"  <c:if test="${fn:contains(grade,'대') or fn:contains(cmd.grade,'대')}">selected</c:if>>대학교</option>
							</select></td>
						</tr>
						<tr bgcolor="white">
							<td>자기소개</td>
							<td><textarea name="self" cols="30" rows="10">${self}${cmd.self}</textarea></td>
						</tr>
						
					</table>
				
			</fieldset>
	
	
</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp"/>
<!-- 푸터 끝 -->
