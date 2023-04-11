<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Myrecipe-ditail</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myrecipe/myrecipedetail.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font/nanumbarungothicsubset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
  </head>
  <body>
    <header>
		<jsp:include page="${pageContext.request.contextPath}/app/header.jsp"/>
    </header>
    <main>
      <div class="detail-main">
        <div class="img-preview">
          <c:forEach var="file" items="${fileList}">
            <div class="preview">
              <img src="${pageContext.request.contextPath}/assets/img/myrecipe/${file.getFileSystemName()}" class="">
            </div>
          </c:forEach>
        </div>
        <div class="main-img">
        	<img src="${pageContext.request.contextPath}/assets/img/myrecipe/${fileList.get(0).getFileSystemName()}" class="card-img-top inside" alt="빅터프랑켄슈타인이미지">
        </div>
        <div class="info">
          <div class="info-title">
            <div class="kor-name">${myRecipe.getMyRecipeNameKor()}</div>
            <div class="eng-name">${myRecipe.getMyRecipeNameEng()}</div>
          </div>
          <div class="info-desc">
            ${myRecipe.getMyRecipeDesc()}
          </div>
          <div class="abv">
            <span>${myRecipe.getUserNumber()}</span>
          </div>
          <!-- <div class="button-box">
            <button class="like-btn">
              <span>3</span>
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                <path
                  d="M323.8 34.8c-38.2-10.9-78.1 11.2-89 49.4l-5.7 20c-3.7 13-10.4 25-19.5 35l-51.3 56.4c-8.9 9.8-8.2 25 1.6 33.9s25 8.2 33.9-1.6l51.3-56.4c14.1-15.5 24.4-34 30.1-54.1l5.7-20c3.6-12.7 16.9-20.1 29.7-16.5s20.1 16.9 16.5 29.7l-5.7 20c-5.7 19.9-14.7 38.7-26.6 55.5c-5.2 7.3-5.8 16.9-1.7 24.9s12.3 13 21.3 13L448 224c8.8 0 16 7.2 16 16c0 6.8-4.3 12.7-10.4 15c-7.4 2.8-13 9-14.9 16.7s.1 15.8 5.3 21.7c2.5 2.8 4 6.5 4 10.6c0 7.8-5.6 14.3-13 15.7c-8.2 1.6-15.1 7.3-18 15.2s-1.6 16.7 3.6 23.3c2.1 2.7 3.4 6.1 3.4 9.9c0 6.7-4.2 12.6-10.2 14.9c-11.5 4.5-17.7 16.9-14.4 28.8c.4 1.3 .6 2.8 .6 4.3c0 8.8-7.2 16-16 16H286.5c-12.6 0-25-3.7-35.5-10.7l-61.7-41.1c-11-7.4-25.9-4.4-33.3 6.7s-4.4 25.9 6.7 33.3l61.7 41.1c18.4 12.3 40 18.8 62.1 18.8H384c34.7 0 62.9-27.6 64-62c14.6-11.7 24-29.7 24-50c0-4.5-.5-8.8-1.3-13c15.4-11.7 25.3-30.2 25.3-51c0-6.5-1-12.8-2.8-18.7C504.8 273.7 512 257.7 512 240c0-35.3-28.6-64-64-64l-92.3 0c4.7-10.4 8.7-21.2 11.8-32.2l5.7-20c10.9-38.2-11.2-78.1-49.4-89zM32 192c-17.7 0-32 14.3-32 32V448c0 17.7 14.3 32 32 32H96c17.7 0 32-14.3 32-32V224c0-17.7-14.3-32-32-32H32z"
                />
              </svg>
            </button>
            <button class="link-btn">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                <path
                  d="M360.2 83.8c-24.4-24.4-64-24.4-88.4 0l-184 184c-42.1 42.1-42.1 110.3 0 152.4s110.3 42.1 152.4 0l152-152c10.9-10.9 28.7-10.9 39.6 0s10.9 28.7 0 39.6l-152 152c-64 64-167.6 64-231.6 0s-64-167.6 0-231.6l184-184c46.3-46.3 121.3-46.3 167.6 0s46.3 121.3 0 167.6l-176 176c-28.6 28.6-75 28.6-103.6 0s-28.6-75 0-103.6l144-144c10.9-10.9 28.7-10.9 39.6 0s10.9 28.7 0 39.6l-144 144c-6.7 6.7-6.7 17.7 0 24.4s17.7 6.7 24.4 0l176-176c24.4-24.4 24.4-64 0-88.4z"
                />
              </svg>
            </button>
          </div> -->
        </div>
      </div>
      <!-- 재료, 레시피 -->
      <div class="myrecipe-detail-container">
        <div class="detail">
          <!-- 제료 설명 -->
          <div class="section-1">
            <div class="ingre-title"><span>재료 정보</span></div>
            <div class="ingre-box">
              
              <c:forEach var="ingre" items="${ingreList}">
           		<div class="ingre">
            		<div class="ingre-icon">
            			<img src="${pageContext.request.contextPath}/assets/img/productAll/${ingre.getProductSystemName()}"/>
            		</div>
            		<div class="span">
              			<div class="name"><span>${ingre.getProductNameKor()}</span></div>
              			<div class="vol"><span id="vol">${ingre.getPmBridgeVol()}</span></div>
            		</div>
          		</div>
        	  </c:forEach>
              
            </div>
          </div>
          <!-- 레시피 설명 -->
          <div class="section-2">
            <div class="recipe-title"><span>레시피</span></div>
            <div class="recipe-box">
              <p>${myRecipe.getMyRecipeRecipe()}</p>
            </div>
          </div>
        </div>
      </div>
    </main>
    <footer>
    	<jsp:include page="${pageContext.request.contextPath}/app/footer.jsp"/>
    </footer>
    <script src="https://code.jquery.com/jquery-3.6.4.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/myrecipe/myrecipedetail.js"></script>
  </body>
</html>
