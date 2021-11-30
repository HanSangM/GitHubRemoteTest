<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
	<html lang="ko">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
	<title>List.jsp</title>
	
	
	<!-- 부트스트랩 -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	
	<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
	<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
	<!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
	 <style>
		body {
		padding-top: 60px
			}
	</style>
	
	</head>
	<body>
	
		<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
			<div class="container-fluid">
				<!-- 화면 크기가 작을때 보여지는 네비게이션바(모바일용) -->
				<div class="navbar-header">
					<button class="navbar-toggle collapsed" data-toggle="collapse"
						data-target="#collapse-menu">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<!-- CI 표시 -->
					<a class="navbar-brand" href="<c:url value="/"/>">
						<span class="glyphicon glyphicon-education"></span> 
						<strong>KOSMO</strong>
					</a>
				</div>
	
				<!-- 화면 크기가 클때 상단에 보여지는 네비게이션바(데스크탑용) -->
				<div class="collapse navbar-collapse" id="collapse-menu">
					<!-- 네비게이션바에 폼 추가 -->
					<form class="navbar-form navbar-right">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="검색">
						</div>
						<button type="submit" class="btn btn-info">확인</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="<c:url value="/"/>">HOME</a></li>
						<c:if test="${empty sessionScope.id }" var="isLogin">
						<li><a href="<c:url value="/onememo/auth/Login.do"/>">로그인</a></li>	
						</c:if>	
							<c:if test="${not isLogin }">
							<li><a href="<c:url value="/onememo/auth/Logout.do"/>">로그아웃</a></li>
						</c:if>			
						<li><a href="<c:url value="/onememo/bbs/List.do"/>">한줄 댓글 게시판</a></li>
						<li><a href="#">공지사항</a></li>	
						
					</ul>					
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		