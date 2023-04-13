<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/clientboard/servicewrite.css"/>
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
                <img class="banner-img" src="${pageContext.request.contextPath}/assets/img/banner/csbanner.jpg" alt="파트너스이미지">
            </a>
        </div>
    </div>
    <div class="container">
        <!-- 작성완료 경로 처리하기 -->
        <form id="write-form" action="/clientboard/serviceWriteOk.clb" method="post">
          <h1>문의글</h1>
          <div class="form-group">
            <label for="title">제목</label>
            <input type="text" id="title" name="boardTitle" required />
          </div>
          <div class="form-group">
            <label for="author">작성자</label>
            <!-- 작성자 서버 연결시 로그인한 회원 아이디로 수정하기 -->
            <div class="writer"><c:out value="${userId}" /></div>
          </div>
          <div class="form-group">
            <label for="content">내용</label>
            <textarea id="content" name="boardContent" required></textarea>
          </div>
          <div class="btn-group">
            <button type="submit" class="submit-btn">작성 완료</button>
            <!-- 취소 버튼 js로 처리하기 -->
            <button type="button" class="cancle-btn">취소</button>
          </div>
        </form>
      </div>
<footer>
	<jsp:include page="${pageContext.request.contextPath}/app/footer.jsp"/>
</footer>
<%-- <script src="${pageContext.request.contextPath}/assets/js/clientboard/clientboardwrite.js"></script> --%>
</body>
</html>