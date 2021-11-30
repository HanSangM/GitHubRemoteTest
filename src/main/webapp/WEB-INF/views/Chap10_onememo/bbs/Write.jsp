<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!-- 상단메뉴 시작 -->	
<jsp:include page="/WEB-INF/views/template/Top_.jsp"/>
<!-- 상단메뉴 끝 -->

<!-- 실제 내용 시작 -->
<div class="container">
	
	<div class="page-header">
		<h1>한줄 메모 게시판 <small>등록 페이지</small></h1>
	</div>	
	<div class="row">
		<div class="col-md-12">
			<form class="form-horizontal" method="post"
				action="<c:url value='/onememo/bbs/Write.do'/>">
				<!-- 씨큐리티 적용:csrf취약점 방어용 -->
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div class="form-group">
					<label class="col-sm-2 control-label">제목</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="title"
							placeholder="제목을 입력하세요?">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">내용</label>
					<!-- 중첩 컬럼 사용 -->
					<div class="col-sm-10">
						<div class="row">
							<div class="col-sm-8">
								<textarea class="form-control" name="content" rows="5"
									placeholder="내용 입력하세요"></textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">등록</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- 실제 내용 끝-->
<!-- 푸터 시작 -->
<jsp:include page="/WEB-INF/views/template/Footer_.jsp"/>
<!-- 푸터 끝 -->
