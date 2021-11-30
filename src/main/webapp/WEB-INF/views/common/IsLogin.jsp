<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- @SessionAttribute사용해서 @ModelAttribute로 읽을때는 현재 파일 불필요 -->
<c:if test="${empty sessionScope.id }">
	<script>
		alert("로그인후 이용하세요");
		location.replace("<c:url value="/onememo/auth/Login.do"/>");
	
	</script>
</c:if>