<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>suppliesdetail</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/product/alcoholdetail.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font/nanumbarungothicsubset.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
  <style>
  	.h-ctg4{
		color: black !important;
	}
  </style>
</head>

<body>
<header>
	<jsp:include page="${pageContext.request.contextPath}/app/header.jsp"/>
</header>
  <div class="container">
    <div class="asidebar">
      <div class="list-nav">
        <span class="text-muted1">홈 >
          <span class="text-muted2">용품</span>
        </span>
      </div>
    </div>
    <div class="content">
      <div class="card mb-3">
        <div class="row g-0">
          <div class="col-md-4">
            <img src="${pageContext.request.contextPath}/assets/img/supplies/${supplies.getProductSystemName()}" class="img-fluid rounded-start">
          </div>
          <div class="col-md-6">
            <div class="card-body">
              <h5 class="card-title">
              	<c:out value="${supplies.getProductNameKor()}"/>
              </h5>
              <p class="card-text"><small class="text-muted">
              	<c:out value="${supplies.getProductNameEng()}"/>
              </small></p>
              <div class="row price-area1">
                <div class="col-3">
                  <span id="unit_price">
                  <fmt:formatNumber value="${supplies.getProductPrice()}" pattern="#,###"/>
                  </span>
        		<span class="won1">원</span>
                </div>
 				<div class="col-9" style="text-align: right;">
                  <button type="button" class="btn btn-outline-secondary" onclick="fn_price_cal('-');">-</button>
                  <input type="text" class="select-num" value="1" size="3" readonly="readonly"/>
                  <button type="button" class="btn btn-outline-secondary" onclick="fn_price_cal('+');">+</button>
                </div>
              </div>
              <div class="row price-area2">
                <div class="col-12" style="text-align: right;">
                  <span>총 수량</span>&nbsp;<span id="total_num">1</span><span>&nbsp;개&nbsp;&nbsp;|&nbsp;&nbsp;</span><span id="price"><fmt:formatNumber value="${supplies.getProductPrice()}" pattern="#,###"/></span>
                  <span class="won2">원</span>
                </div>
              </div>
              <div class="row mt-3">
                <div class="col-3"></div>
                <div class="col-9">
                  <button class="btn btn-outline-secondary btn-sm cartBtn">장바구니 담기</button>
                  <button class="btn btn-danger btn-sm orderBtn">바로 구매하기</button>
                </div>
              </div>
              <div class="col-md-2"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<footer>
	<jsp:include page="${pageContext.request.contextPath}/app/footer.jsp"/>
</footer>
<script src="${pageContext.request.contextPath}/assets/js/sulkit/sulkitdetail.js"></script>
</body>

<script type="text/javascript">
  function fn_price_cal(sign){
    let unit_price = $("#unit_price").text();
    unit_price = unit_price.replace(/\,/g,"");
    unit_price *= 1;

    let total_num  = $("#total_num").text();
    total_num *= 1;
    if(sign == "+"){    
      $("#total_num").text(total_num+1);
      $(".select-num").val(total_num+1);
    }else if(sign == "-"){ 
      if(total_num == 1){
         alert("최소 1개이상 선택 가능합니다.");
         return false; 
      }
      $("#total_num").text(total_num-1);
      $(".select-num").val(total_num-1);
    }

    let cal_price = $(".select-num").val()*unit_price;
    cal_price += "";
    cal_price = cal_price.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
    console.log(cal_price);
    $("#price").text(cal_price);
  }
  </script>
  <script type="text/javascript">function fn_go_to_link(link){location.href=link;}</script>
</html>