<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>findidpw</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user/findidpw.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font/nanumbarungothicsubset.css" />
  </head>
  <body>
    <div class="find-nav-btn">
      <span class="find-id-btn findBtn">아이디 찾기</span>
      <span class="find-pw-btn findBtn">비밀번호 찾기</span>
    </div>
    <!-- 클릭시 활성화, 글자배경색 주기.
      아이디 찾기 클릭 시 새창 열리고, 새 창에
      두 가지 탭 -->

    <div class="findIdPw">
      <div class="find-id" action="${pageContext.request.contextPath}" method="post">
       <span class="findtxt"><span class="resultId"></span></span>
        <label
          ><input
            class="find-input-box nameId"
            type="text"
            placeholder="이름"
            required
        /></label>
        <br />
        <label>
          <input
            class="find-input-box phoneId"
            type="text"
            placeholder="핸드폰 번호"
            required
        /></label>
        <br />
        <div>
        <button type="button" class="find-submit-btn idBtn">확인</button>
        <button type="button" class="find-submit-btn" onclick="window.close();">닫기</button>
        </div>
      </div>

      <div class="find-pw">
        <span class="findtxt"><span class="resultPw"></span></span>
        <label
          ><input
            class="find-input-box idPw"
            type="text"
            placeholder="아이디"
            required
        /></label>
        <br />
        <label
          ><input
            class="find-input-box namePw"
            type="text"
            placeholder="이름"
            required
        /></label>
        <br />
        <label
          ><input
            class="find-input-box phonePw"
            type="text"
            placeholder="핸드폰 번호"
            required
        /></label>
        <br />

        <div>
          <button class="find-submit-btn pwBtn" type="submit">확인</button>
          <button class="find-submit-btn" type="button" onclick="window.close();">닫기</button>
        </div>
    </div>
    <script
      src="https://code.jquery.com/jquery-3.6.3.js"
      integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
      crossorigin="anonymous"
    ></script>
    <script src="${pageContext.request.contextPath}/assets/js/user/findidpw.js"></script>
  </body>
</html>