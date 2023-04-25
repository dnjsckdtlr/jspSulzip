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
	href="${pageContext.request.contextPath}/assets/css/admin/productupload.css" />
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
			<input type="file" id="ex-file" name="productFile" accept=".jpg, .jpeg, .png" multiple />
				<div class="img-preview"></div>
			</div>
			<form action="/admin/productUploadOk.adm" method="post" enctype="multipart/form-data">
				<input type="file" name="productFile" id="" class="productFileInput" /> <br />
        <!-- 상품 이름 입력 -->
        <div class="ctg-title"><span>상품분류</span> <br></div>
        <div class="ctg-box">
        	술<input type="radio" name="category" value="2" class="ctg" checked/>
        	재료<input type="radio" name="category" value="3" class="ctg"/>
        	용품<input type="radio" name="category" value="4" class="ctg"/>
        </div>
        <div class="name-title"><span>상품이름(국문)</span></div>
        <input type="text" class="input" name="productNameKor"/>
        <div class="name-title"><span>상품이름(영문)</span></div>
        <input type="text" class="input" name="productNameEng"/>
        <!-- 가격 입력 -->
        <div class="pro-price-title"><span>가격</span></div>
        <input type="text" class="input" name="productPrice"/>
        <!-- 등록버튼 -->
        <div class="upload-btn-box">
          <button type="button" id="btn"><span>업로드</span></button>
        </div>
        </form>
      </div>
      
    </main>
     <footer>
    	<jsp:include page="${pageContext.request.contextPath}/app/footer.jsp"/>
    </footer>
    <script src="https://code.jquery.com/jquery-3.6.4.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/admin/productupload.js"></script>
  </body>
</html>
