<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font/nanumbarungothicsubset.css" />
    <style>
      * {
        font-family: "NanumBarunGothic", sans-serif;
      }
    </style>
  <body>
    <header>
      <div class="h-header">
        <div class="h-title-page">
          <div class="h-top-line">
            <div class="h-logo">
              <a href="/"><img src="${pageContext.request.contextPath}/assets/img/logo/mainlogo.jpg" /></a>
            </div>
            <div class="h-line-right">
<c:choose>
<c:when test="${userId !=null}">            
				<div class="h-join"><a href="${pageContext.request.contextPath}/user/mypage.usr"><c:out value="${userId}"/></div>
				<div class="h-cart"><a href="${pageContext.request.contextPath}/app/cart/cart.jsp">장바구니</a></div>
</c:when>
<c:otherwise>
              	<div class="h-cart"><a href="${pageContext.request.contextPath}/user/login.usr">로그인/회원가입</a></div>
</c:otherwise>
</c:choose>
              
            </div>
          </div>
          <div class="h-bottom-line">
            <ul class="h-ctg">
              <li><a href="${pageContext.request.contextPath}/sulkit/productSulkit1.suk">술키트</a></li>
              <li><a href="${pageContext.request.contextPath}/product/productAlcohol1.prd">술</a></li>
              <li><a href="${pageContext.request.contextPath}/product/productIngredients1.prd">재료</a></li>
              <li><a href="${pageContext.request.contextPath}/product/productSupplies1.prd">용품</a></li>
              <li><a href="${pageContext.request.contextPath}/myrecipe/myRecipe.mrb">나만의 레시피</a></li>
              <li><a href="${pageContext.request.contextPath}/partners/partners.ptn">파트너스</a></li>
              <li><a href="${pageContext.request.contextPath}/clientboard/serviceListOk.clb">고객센터</a></li>
            </ul>
          </div>
        </div>
      </div>
    </header>
  </body>
</html>