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
    <title>Board</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminboard.css" />
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
      <div class="board-container">
        <!-- 사이드바 -->
        <div class="side-bar">
          <ul>
            <li>
              <a href="${pageContext.request.contextPath}/admin/user.adm">
                <div class="user-icon">
                  <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                    <path
                      d="M224 256A128 128 0 1 0 224 0a128 128 0 1 0 0 256zm-45.7 48C79.8 304 0 383.8 0 482.3C0 498.7 13.3 512 29.7 512H418.3c16.4 0 29.7-13.3 29.7-29.7C448 383.8 368.2 304 269.7 304H178.3z"
                    />
                  </svg>
                </div>
                회원관리</a
              >
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/admin/product.adm"
                ><div class="product-icon">
                  <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512">
                    <path
                      d="M0 24C0 10.7 10.7 0 24 0H69.5c22 0 41.5 12.8 50.6 32h411c26.3 0 45.5 25 38.6 50.4l-41 152.3c-8.5 31.4-37 53.3-69.5 53.3H170.7l5.4 28.5c2.2 11.3 12.1 19.5 23.6 19.5H488c13.3 0 24 10.7 24 24s-10.7 24-24 24H199.7c-34.6 0-64.3-24.6-70.7-58.5L77.4 54.5c-.7-3.8-4-6.5-7.9-6.5H24C10.7 48 0 37.3 0 24zM128 464a48 48 0 1 1 96 0 48 48 0 1 1 -96 0zm336-48a48 48 0 1 1 0 96 48 48 0 1 1 0-96z"
                    />
                  </svg>
                </div>
                상품관리</a
              >
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/admin/order.adm"
                ><div class="order-icon">
                  <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                    <path
                      d="M224 0c-17.7 0-32 14.3-32 32V51.2C119 66 64 130.6 64 208v18.8c0 47-17.3 92.4-48.5 127.6l-7.4 8.3c-8.4 9.4-10.4 22.9-5.3 34.4S19.4 416 32 416H416c12.6 0 24-7.4 29.2-18.9s3.1-25-5.3-34.4l-7.4-8.3C401.3 319.2 384 273.9 384 226.8V208c0-77.4-55-142-128-156.8V32c0-17.7-14.3-32-32-32zm45.3 493.3c12-12 18.7-28.3 18.7-45.3H224 160c0 17 6.7 33.3 18.7 45.3s28.3 18.7 45.3 18.7s33.3-6.7 45.3-18.7z"
                    />
                  </svg>
                </div>
                주문관리</a
              >
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/admin/board.adm"
                ><div class="board-icon">
                  <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 512">
                    <path
                      d="M280 64h40c35.3 0 64 28.7 64 64V448c0 35.3-28.7 64-64 64H64c-35.3 0-64-28.7-64-64V128C0 92.7 28.7 64 64 64h40 9.6C121 27.5 153.3 0 192 0s71 27.5 78.4 64H280zM64 112c-8.8 0-16 7.2-16 16V448c0 8.8 7.2 16 16 16H320c8.8 0 16-7.2 16-16V128c0-8.8-7.2-16-16-16H304v24c0 13.3-10.7 24-24 24H192 104c-13.3 0-24-10.7-24-24V112H64zm128-8a24 24 0 1 0 0-48 24 24 0 1 0 0 48z"
                    />
                  </svg>
                </div>
                게시판관리</a
              >
            </li>
            <li><a href="${pageContext.request.contextPath}/user/logoutOk.usr">로그아웃</a></li>
          </ul>
          <!-- 게시판관리 메인페이지 -->
        </div>
        <div class="board-management">
          <div class="board-title"><span>게시판관리</span></div>
          <div class="board-ctg">
            <div class="ctg-board"><span>게시판 분류</span></div>
            <div class="ctg-board-select">
              <span>나만의 레시피</span><input type="radio" name="category" value="M" class="ctg" checked/>
              <span>고객센터</span><input type="radio" name="category" value="C" class="ctg"/>
            </div>
          </div>
          <div class="board-id">
            <div class="id-title"><span>등록 회원</span></div>
            <div class="id-select">
              <select name="select" id="id">
                <option name="select" value="1">글제목</option>
                <option name="select" value="2">회원ID</option>
              </select>
              <input type="text" id="keyword"/>
            </div>
          </div>
          <div class="search-btn">
            <button class="search">검색</button>
            <button>초기화</button>
          </div>
          <!-- 게시판 목록 -->
          <div class="board-list-title"><span>게시글목록</span></div>
          <div class="board-list-select">
            <div class="delete-box">
              <div class="delete"><button>삭제</button></div>
            </div>
            <div class="list-ctg">
              <div class="ctg-1"><input type="checkbox" id="checkAll"></div>
              <div class="ctg-2"><span>게시판제목</span></div>
              <div class="ctg-3"><span>게시글제목</span></div>
              <div class="ctg-4"><span>게시판ID</span></div>
              <div class="ctg-5"><span>게시물관리</span></div>
            </div>
            <div class="board-list">
            
            
            	<c:forEach var="board" items="${myRecipeList}">
            		<div class="list-ctg-2">
		                <div class="ctg-1"><input type="checkbox" class="cbox"></div>
		                <div class="ctg-2">
		                			<c:out value="나만의 레시피"/>
		                </div>
		                <div class="ctg-3"><span> <c:out value="${board.getTitle()}"/> </span></div>
		                <div class="ctg-4"><span><c:out value="${board.getId()}"/> </span></div>
		                <div class="ctg-5">
		                  <button type="button" class="read" data-num="${board.getNumber()}"> <span>글보기 ></span> 
		                  </button>
		                  <button  id="delete" data-num="${board.getNumber()}"><span>글삭제 ></span>
		                  </button>
		                </div>
	              	</div>
            	</c:forEach>
            
              <!-- <div class="list-ctg-2">
                <div class="ctg-1"><input type="checkbox" class="cbox"></div>
                <div class="ctg-2"><span>게시판제목</span></div>
                <div class="ctg-3"><span>게시글제목</span></div>
                <div class="ctg-4"><span>게시판ID</span></div>
                <div class="ctg-5">
                  <button>글보기 ></button>
                  <button>글삭제 ></button>
                </div>
              </div>
               -->
              
            </div>
          </div>
        </div>
    </main>
    <footer>
      <jsp:include page="${pageContext.request.contextPath}/app/footer.jsp"/>
    </footer>
    <script src="https://code.jquery.com/jquery-3.6.4.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/admin/adminboard.js"></script>
  </body>
</html>
