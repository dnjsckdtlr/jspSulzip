<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/clientboard/servicewrite.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font/nanumbarungothicsubset.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <style>
        	.h-ctg7{
				color: black !important;
			}
        </style>
</head>
<body>
    <header>
    	<jsp:include page="${pageContext.request.contextPath}/app/header.jsp"/>
    </header>
  <div class="container-fluid">
        <div class="img-content">
            <a href="javascript:alert('준비중인 페이지입니다.');">
                <img class="banner-img" src="${pageContext.request.contextPath}/assets/img/banner/csbanner.jpg" alt="cs배너이미지">
            </a>
        </div>
    </div>
		<div class="container">
				<!-- 작성완료 경로 처리하기 -->
				<form id="write-form" action="${pagetContext.request.contextPath}/clientboard/serviceUpdateOk.clb" method="post">
					
					<input type="hidden" name="boardNumber" value="${clientBoard.getBoardNumber()}">
					
					<h1>글수정</h1>
		
					<div class="form-group">
						<label for="title">제목</label> <input type="text" id="title" name="boardTitle" value="${clientBoard.getBoardTitle()}" required />
					</div>
					<div class="form-group">
						<label for="author">작성자</label>
						<!-- 작성자 서버 연결시 로그인한 회원 아이디로 수정하기 -->
						<div class="writer">
							<c:out value="${clientBoard.getUserId()}" />
						</div>
					</div>
					<div class="form-group">
						<label for="content">내용</label>
						<textarea id="content" name="boardContent" required><c:out value="${clientBoard.getBoardContent()}"/></textarea>
					</div>
				
					<div class="btn-group">
						<button type="submit" class="submit-btn">작성 완료</button>
						<!-- 취소 버튼 js로 처리하기 -->
						<button type="button" class="cancle-btn" onclick="fn_go_to_link('${pageContext.request.contextPath}/clientboard/serviceListOk.clb')">취소</button>
					</div>
				</form>
			</div>
	<footer>
    	<jsp:include page="${pageContext.request.contextPath}/app/footer.jsp"/>
    </footer>
			<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
			<%-- <script src="${pagetContext.request.contextPath}/assets/js/clientboardwrite.js"></script> --%>
			<script type="text/javascript"> function fn_go_to_link(link){location.href=link;}</script>
</body>
</html>