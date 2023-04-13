<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>footer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font/nanumbarungothicsubset.css" />
  </head>
  <body>
    <div class="f-footer">
      <div class="f-footer-box">
        <nav class="f-footer-menu">
          <div class="f-column">
            <ul class="f-index">
              <li class="f-index-ul">쇼핑 및 레시피</li>
              <li class="f-index-li"><a href="${pageContext.request.contextPath}/app/sulkit/sulkit1.jsp" class="f-a">칵테일 패키지</a></li>
              <li class="f-index-li"><a href="${pageContext.request.contextPath}/app/product/ingredients1.jsp" class="f-a">칵테일 재료</a></li>
            </ul>
          </div>
          <div class="f-column">
            <ul class="f-index">
              <li class="f-index-ul">계정</li>
              <li class="f-index-li"><a href="${pageContext.request.contextPath}/app/user/login.jsp" class="f-a">로그인</a></li>
              <li class="f-index-li"><a href="${pageContext.request.contextPath}/app/user/join.jsp" class="f-a">회원가입</a></li>
              <li class="f-index-li"><a href="${pageContext.request.contextPath}/app/user/mypage.jsp" class="f-a">마이페이지</a></li>
              <li class="f-index-li"><a href="${pageContext.request.contextPath}/app/cart/cart.jsp" class="f-a">장바구니</a></li>
            </ul>
          </div>
          <div class="f-column">
            <ul class="f-index">
              <li class="f-index-ul">파트너스</li>
              <li class="f-index-li"><a href="" class="f-a">가입문의</a></li>
            </ul>
          </div>
          <div class="f-column">
            <ul>
              <li class="f-index-ul">고객센터</li>
              <li class="f-index-li">02-0000-0000</li>
              <li class="f-index-li">
                운영시간 : 오전10:00~오후06:00 <br />점심시간 :
                오후12:00~오후13:00 <br />
                휴<span class="f-transparency">무휴</span>무 : 토, 일,
                공휴일
              </li>
            </ul>
          </div>
          <div class="f-column">
            <ul>
              <li class="f-index-ul">카카오톡 채널상담</li>
              <li class="f-index-li">sulzip_official</li>
              <li class="f-index-li">
                카카오톡 채널로 문의주시면 <br />
                빠르게 답변 받으실 수 있습니다.
              </li>
            </ul>
          </div>
        </nav>
        <div class="f-footer-legal">
          <div class="f-footer-copyright-wrap">
            <div class="f-footer-copyright">
              Copyright © 2023 Sulzip Inc. 모든 권리 보유.
            </div>
            <ul>
              <a href="" class="f-footer-copyright-li">개인정보 처리방침</a>
              <a href="" class="f-footer-copyright-li">웹 사이트 이용 약관</a>
            </ul>
          </div>
          <div class="f-footer-company">
            사업자등록번호 : 000-00-00000 | 통신판매업신고번호 : 제
            2023-서울강남-00000호 | 주소 : 서울 강남구 테헤란로 152
            강남파이낸스센터 | 대표전화 : 02-0000-0000 | 팩스 : 02-0000-0000 |
            sulzip@naver.com
          </div>
        </div>
      </div>
    </div class="f-footer">
  </body>
</html>