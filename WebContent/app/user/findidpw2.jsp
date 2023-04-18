<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>findidpw</title>
      <link rel="stylesheet" href="/sulzip/css/findId.css">
  </head>
  <body>
    <!-- <a href="_blank" onclick="window.open(this.href, '', 'width=400, height=500'); return false;">
      이거누르면새창열림
    </a> -->
    <div class="find-nav-btn">
      <span class="find-id-btn">아이디 찾기</span>
    </div>
    <!-- 클릭시 활성화, 글자배경색 주기.
      아이디 찾기 클릭 시 새창 열리고, 새 창에
      두 가지 탭 -->
<!---->
      
<!---->
    <div class="findIdPw">
      <form class="find-id" action="${pageContext.request.contextPath}" method="post">
        <h3>회원의 아이디는 ${user.getUserId()}입니다.</h3>
        <br />
        <button type="submit" class="find-submit-btn">확인</button>
        <button type="button" class="find-submit-btn" onclick="window.close();">
          닫기
        </button>
      </form> 
    <script
      src="https://code.jquery.com/jquery-3.6.3.js"
      integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
      crossorigin="anonymous"
    ></script>
    <script src="${pageContext.request.contextPath}/assets/js/user/findidpw.js"></script>
  </body>
</html>