<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/cart/cart.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font/nanumbarungothicsubset.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
  </head>
  <body>
  <header>
  	<jsp:include page="${pageContext.request.contextPath}/app/header.jsp"/>
  </header>
    <div class="cart-header">장바구니</div>
    <div class="cart-content-title">
      
      	<c:choose>
           	<c:when test="${cartList.size() == 0}">
				<span class="cart-user-name"><c:out value="${userInfo.getUserName()}"/></span>님이 장바구니에 담은 상품이 없습니다.
			</c:when>
			<c:otherwise>
				<span class="cart-user-name"><c:out value="${userInfo.getUserName()}"/></span>님이 장바구니에 담아놓은 상품입니다.
			</c:otherwise>
		</c:choose>
    </div>

    <form action="${pageContext.request.contextPath}/order/order.ord" class="cart-form">
      <table class="cart-table">
        <colgroup>
          <col width="5%" />
          <col width="10%" />
          <col width="60%" />
          <col width="10%" />
          <col width="15%" />
        </colgroup>
        <thead>
          <tr class="cart-tr1">
            <th>
              <input
                type="checkbox"
                name="cart_check_all"
                value="1"
                id="cart_check_all"
                checked
              />
            </th>
            <th>사진</th>
            <th>상품명</th>
            <th>수량</th>
            <th>가격</th>
          </tr>
        </thead>
        <tbody>
        	<c:forEach var="cart" items="${cartList}">
	          <tr class="cart-tr2">
	            <td>
	              <input
	                type="checkbox"
	                name="cart_check"
	                class="cart_check"
	                value="${cart.getProductNumber()}"
	                checked
	              />
	              <label for="cart_check"></label>
	            </td>
	            <td>
	              <div class="item-img">
	                <c:choose>
	                	<c:when test="${cart.getCategoryNumber() == 0}">
							<img src="${pageContext.request.contextPath}/assets/img/sulkit/${cart.getProductSystemName()}" width="100" height="100"/>
						</c:when>
						<c:when test="${cart.getCategoryNumber() == 2}">
							<img src="${pageContext.request.contextPath}/assets/img/alcohol/${cart.getProductSystemName()}" width="100" height="100"/>
						</c:when>
						<c:when test="${cart.getCategoryNumber() == 3}">
							<img src="${pageContext.request.contextPath}/assets/img/ingredients/${cart.getProductSystemName()}" width="100" height="100"/>
						</c:when>
						<c:when test="${cart.getCategoryNumber() == 4}">
							<img src="${pageContext.request.contextPath}/assets/img/supplies/${cart.getProductSystemName()}" width="100" height="100"/>
						</c:when>
						<c:otherwise>
							<img src="" alt="이미지 없음" width="100" height="100"/>
						</c:otherwise>
					</c:choose>
	              </div>
	            </td>
	            <td class="product_name">
	              <a href="" class="item-name-links">
	                ${cart.getProductNameKor()}
	              </a>
	            </td>
	            <td>
	              <div class="options">
	                <div>
	                  <div class="quantity">
	                  	<span class="quantity--in">${cart.getProductEa()}</span>개
	                  	<input type="hidden" name="productEa" value="${cart.getProductEa()}" class="productEa" disabled>
	                  </div>
	                  <div>
	                    <i class="bi bi-arrow-up-square" data-price="${cart.getProductPrice()}"></i>
	                    <i class="bi bi-arrow-down-square" data-price="${cart.getProductPrice()}"></i>
	                  </div>
	                </div>
	              </div>
	            </td>
	            <td>
	              <span class="sell-price">
	              	<span class="sell-price--in">
	              		<c:out value="${cart.getProductPrice()}"/>
	              	</span>
	              	원
	              	<input type="hidden" name="productPrice" value="${cart.getProductPrice()}" class="productPrice" disabled>
	              </span>
	            </td>
	          </tr>
        	</c:forEach>
        </tbody>

        <tfoot class="cart-tfoot">
          <tr>
            <td colspan="5">
              <div class="cart-sum-price-notice">
                결제 금액&nbsp;:&nbsp;<span class="cart-sum-price"></span>원
              </div>
            </td>
          </tr>
        </tfoot>
      </table>
      <div class="cart-select-delete-wrap">
        <button type="button" class="cart-select-delete">선택삭제</button>
      </div>
      <div class="cart-buy-btn-wrap">
        <button type="button" class="cart-buy-btn">주문하기</button>
      </div>
    </form>
	<footer>
		<jsp:include page="${pageContext.request.contextPath}/app/footer.jsp"/>
	</footer>
    <script
      src="https://code.jquery.com/jquery-3.6.3.js"
      integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
      crossorigin="anonymous"
    ></script>
    <script src="/assets/js/cart/cart.js"></script>
    <script type="text/javascript">function fn_go_to_link(link){location.href=link;}</script>
  </body>
</html>