<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Main</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font/nanumbarungothicsubset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <style>
      * {
        font-family: "NanumBarunGothic", sans-serif;
      }
    </style>
  </head>
  <body>
    <header>
		<jsp:include page="${pageContext.request.contextPath}/app/header.jsp"/>
	</header>
    <main>
      <div style="overflow: hidden;" class="main">
        <div class="main-img">
          <div class="main-first">
            <a href="${pageContext.request.contextPath}/sulkit/sulkit.suk">
              <img src="${pageContext.request.contextPath}/assets/img/banner/mainImg.jpg" />
            </a>
          </div>
          <div class="main-second">
            <a href="${pageContext.request.contextPath}/sulkit/sulkit.suk">
              <img src="${pageContext.request.contextPath}/assets/img/banner/mainimg2.jpg" />
            </a>
          </div>
          <div class="main-first">
            <a href="${pageContext.request.contextPath}/sulkit/sulkit.suk">
              <img src="${pageContext.request.contextPath}/assets/img/banner/mainImg.jpg" />
            </a>
          </div>
        </div>
        <div class="button-box">
          <button class="first"></button>
          <button class="second"></button>
        </div>
      </div>
      <!-- <div class="button-box">
        <button class="first"></button>
        <button class="second"></button>
      </div> -->
      <div class="section-1">
        <div class="border-box">
          <div class="slides-wrap">
            <ul class="slide-box">
              <li>
                <div class="slide-img">
                  <a href="${pageContext.request.contextPath}/partners/partners.ptn"><img src="${pageContext.request.contextPath}/assets/img/sub-banner/brand_image_left.jpg" alt="" /></a>
                </div>
              </li>
              <li>
                <div class="slide-img">
                  <a href="${pageContext.request.contextPath}/sulkit/sulkit.suk"><img src="${pageContext.request.contextPath}/assets/img/sub-banner/brand_image_main.jpg" alt="" /></a>
                </div>
              </li>
              <li>
                <div class="slide-img">
                  <a href="${pageContext.request.contextPath}/myrecipe/myRecipe.mrb"><img src="${pageContext.request.contextPath}/assets/img/sub-banner/brand_image_right.jpg" /></a>
                </div>
              </li>
            </ul>
            <!-- &lt, &gt는 html에서 <, > 를 나타낼 때 사용 -->
            <div class="prev">&lt</div>
            <div class="next">&gt</div>
          </div>
        </div>
      </div>
    </main>
    <footer>
		<jsp:include page="${pageContext.request.contextPath}/app/footer.jsp"/>
	</footer>
  </body>
  <script
    src="https://code.jquery.com/jquery-3.6.3.js"
    integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
    crossorigin="anonymous"
  ></script>
  <script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
</html>
