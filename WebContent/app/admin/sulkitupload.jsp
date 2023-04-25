<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Product-upload</title>
    <link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/sulkitupload.css" />
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/font/nanumbarungothicsubset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footer.css" />

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
      <div class="upload-container">
        <!-- 첨부파일-->
        <div class="file-upload">
			<label for="ex-file" class="label-wrap">
				<div class="img-icon">
					<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                	<path d="M220.6 121.2L271.1 96 448 96v96H333.2c-21.9-15.1-48.5-24-77.2-24s-55.2 8.9-77.2 24H64V128H192c9.9 0 19.7-2.3 28.6-6.8zM0 128V416c0 35.3 28.7 64 64 64H448c35.3 0 64-28.7 64-64V96c0-35.3-28.7-64-64-64H271.1c-9.9 0-19.7 2.3-28.6 6.8L192 64H160V48c0-8.8-7.2-16-16-16H80c-8.8 0-16 7.2-16 16l0 16C28.7 64 0 92.7 0 128zM168 304a88 88 0 1 1 176 0 88 88 0 1 1 -176 0z" />
              		</svg>
					<div>이미지 업로드</div>
				</div>
			</label> 
			<input type="file" id="ex-file" name="sulkitFile" accept=".jpg, .jpeg, .png" multiple />
				<div class="img-preview"></div>
			</div>
			<form action="/admin/sulkitUploadOk.adm" method="post" enctype="multipart/form-data">
				<input type="file" name="sulkitFile" id="" class="myRecipeFileInput" /> <br />
        <!-- 상품 이름 입력 -->
        <div class="name-title"><span>상품이름(국문)</span></div>
        <input type="text" class="input" name="sulkitNameKor"/>
        <div class="name-title"><span>상품이름(영문)</span></div>
        <input type="text" class="input" name="sulkitNameEng"/>
        <!-- 상품 설명 -->
        <div class="pro-info-title"><span>상품설명</span></div>
        <input type="text" class="info-input" name="sulkitDesc"/>
        <!-- 커서 이동하는 법 물어보기 -->
        <!-- 가격 입력 -->
        <div class="pro-price-title"><span>가격</span></div>
        <input type="text" class="input" name="sulkitprice"/>
        <!-- 재료 -->
	       <div class="ingredient-title">
				<span class="ingre-svg"> 재료 정보&nbsp;&nbsp; 
				<svg
					xmlns="http://www.w3.org/2000/svg" width="20" height="20"
					fill="currentColor" class="bi bi-plus-circle-fill"
					viewBox="0 0 16 16">
	              <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3v-3z" />
	            </svg> 
	            <span class="ingre-cnt">1</span> 
	            <svg xmlns="http://www.w3.org/2000/svg" width="20"
						height="20" fill="currentColor" class="bi bi-dash-circle-fill"
						viewBox="0 0 16 16">
	              <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM4.5 7.5a.5.5 0 0 0 0 1h7a.5.5 0 0 0 0-1h-7z" />
	            </svg>
				</span>
			</div>
			
			
			<div class="all">
				<div class="ingre-sample">
					<div class="ingre-box">
						<div>none</div>
						<select name="category" class="sulkit-category category">
							<option value="1" selected>카테고리</option>
							<option value="2">술</option>
							<option value="3">재료</option>
						</select> 
						<select name="category1" class="alcohol pro">
							<option value="" selected>술</option>
							<c:forEach var="alcohol" items="${alcoholList}">
								<option value="${alcohol.getProductNumber()}">
									<c:out value="${alcohol.getProductNameKor()}" />
								</option>
							</c:forEach>
						</select> 
						<select name="category1" class="ingre pro">
							<option value="" selected>재료</option>
							<c:forEach var="ingre" items="${ingreList}">
								<option value="${ingre.getProductNumber()}">
									<c:out value="${ingre.getProductNameKor()}" />
								</option>
							</c:forEach>
						</select> 
						<input type="text" placeholder="용량, 단위" name="pmBridgeVol" class="vol pro" />
					</div>
				</div>
				<div class="ingre-box">
					<div>1.</div>
					<select name="category" class="sulkit-category category">
						<option value="1" selected>카테고리</option>
						<option value="2">술</option>
						<option value="3">재료</option>
					</select> <select name="category1" class="alcohol pro">
						<option value="" selected>술</option>
						<c:forEach var="alcohol" items="${alcoholList}">
							<option value="${alcohol.getProductNumber()}">
								<c:out value="${alcohol.getProductNameKor()}" />
							</option>
						</c:forEach>
					</select> 
					<select name="category1" class="ingre pro">
						<option value="" selected>재료</option>
						<c:forEach var="ingre" items="${ingreList}">
							<option value="${ingre.getProductNumber()}">
								<c:out value="${ingre.getProductNameKor()}" />
							</option>
						</c:forEach>
					</select> 
					<input type="text" placeholder="용량, 단위" name="psBridgeVol" class="vol pro" />
				</div>
			</div>
				
				
        <!-- 레시피 -->
        <div class="recipe-title"><span>레시피</span></div>
        <div class="input-box">
          <textarea name="sulkitRecipe" id="" cols="30" rows="10" class="recipe-input"></textarea>
        </div>
        <!-- 등록버튼 -->
        <div class="upload-btn-box">
          <button type="submit"><span>업로드</span></button>
        </div>
        </form>
      </div>
      
    </main>
     <footer>
    	<jsp:include page="${pageContext.request.contextPath}/app/footer.jsp"/>
    </footer>
    <script src="https://code.jquery.com/jquery-3.6.4.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/admin/sulkitupload.js"></script>
  </body>
</html>
