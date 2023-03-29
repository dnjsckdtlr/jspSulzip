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
    <!-- <a href="_blank" onclick="window.open(this.href, '', 'width=400, height=500'); return false;">
      이거누르면새창열림
    </a> -->
    <div class="find-nav-btn">
      <span class="find-id-btn">아이디 찾기</span>
      <span class="find-pw-btn">비밀번호 찾기</span>
    </div>
    <!-- 클릭시 활성화, 글자배경색 주기.
      아이디 찾기 클릭 시 새창 열리고, 새 창에
      두 가지 탭 -->

    <div class="findIdPw">
      <form class="find-id">
        <label
          ><input
            class="find-input-box"
            type="text"
            placeholder="이름"
            required
        /></label>
        <br />
        <label>
          <input
            class="find-input-box"
            type="text"
            placeholder="핸드폰 번호"
            required
        /></label>
        <br />
        <button type="submit" class="find-submit-btn">확인</button>
        <button type="button" class="find-submit-btn" onclick="window.close();">
          닫기
        </button>
      </form>

      <form class="find-pw">
        <label
          ><input
            class="find-input-box"
            type="text"
            placeholder="아이디"
            required
        /></label>
        <br />
        <label
          ><input
            class="find-input-box"
            type="text"
            placeholder="이름"
            required
        /></label>
        <br />
        <label
          ><input
            class="find-input-box"
            type="text"
            placeholder="핸드폰 번호"
            required
        /></label>
        <br />

        <div>
          <button class="find-submit-btn" type="submit">확인</button>
          <button
            class="find-submit-btn"
            type="button"
            onclick="window.close();"
          >
            닫기
          </button>
        </div>
      </form>
    </div>
    <script
      src="https://code.jquery.com/jquery-3.6.3.js"
      integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
      crossorigin="anonymous"
    ></script>
    <script src="${pageContext.request.contextPath}/assets/js/user/findidpw.js"></script>
  </body>
</html>