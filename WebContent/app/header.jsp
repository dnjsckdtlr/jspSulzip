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
<c:when test="${userId == 'admin'}">            
				<div class="h-join"><a href="${pageContext.request.contextPath}/admin/user.adm"><c:out value="${userId}"/>&nbsp;님&nbsp;&nbsp;&nbsp;&nbsp;</div>
				<div class="h-cart"><a href="${pageContext.request.contextPath}/cart/cart.car">장바구니</a></div>
</c:when>
<c:when test="${userId !=null}">            
				<div class="h-join"><a href="${pageContext.request.contextPath}/user/mypage.usr"><c:out value="${userId}"/>&nbsp;님&nbsp;&nbsp;&nbsp;&nbsp;</div>
				<div class="h-cart"><a href="${pageContext.request.contextPath}/cart/cart.car">장바구니</a></div>
</c:when>
<c:otherwise>
              	<div class="h-cart"><a href="${pageContext.request.contextPath}/user/login.usr">로그인/회원가입</a></div>
</c:otherwise>
</c:choose>
              
            </div>
          </div>
          <div class="h-bottom-line">
            <ul class="h-ctg">
              <li><a href="${pageContext.request.contextPath}/sulkit/sulkit.suk" class="h-ctg1">술키트</a></li>
              <li><a href="${pageContext.request.contextPath}/product/alcohol.prd" class="h-ctg2">술</a></li>
              <li><a href="${pageContext.request.contextPath}/product/ingredients.prd" class="h-ctg3">재료</a></li>
              <li><a href="${pageContext.request.contextPath}/product/supplies.prd" class="h-ctg4">용품</a></li>
              <li><a href="${pageContext.request.contextPath}/myrecipe/myRecipe.mrb" class="h-ctg5">나만의 레시피</a></li>
              <li><a href="${pageContext.request.contextPath}/partners/partners.ptn" class="h-ctg6">파트너스</a></li>
              <li><a href="${pageContext.request.contextPath}/clientboard/serviceListOk.clb" class="h-ctg7">고객센터</a></li>
            </ul>
          </div>
        </div>
      </div>
    </header>
  </body>
</html>