<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>service-page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/clientboard/servicepage.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font/nanumbarungothicsubset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
        <style>
        	.h-ctg7{
				color: black !important;
			}
        </style>
  </head>
  <body>
    <header>
    	<jsp:include page="${pageContext.request.contextPath}/app/header.jsp"/>
    </header>
    <main>
      <div class="tabmenu-black">
        <a href="">
          <img src="${pageContext.request.contextPath}/assets/img/banner/csbanner.jpg" alt="" />
        </a>
      </div>
      <div class="container">
        <div class="wrap">
          <div class="title-box">
            <h3><c:out value="${boardRow.getBoardTitle()}"/></h3>
            <div class="text">
              <div class="info">
                <div class="date">
                  <span><strong>날짜 : </strong></span>
                  <span><c:out value="${boardRow.getBoardDate()}"/></span>
                </div>
                <div class="id">
                  <span><strong>작성자 : </strong></span>
                  <span><c:out value="${boardRow.getUserId()}"/></span>
                </div>
              </div>
            </div>
          </div>
          <div class="content"> <pre><c:out value="${boardRow.getBoardContent()}" /></pre></div>
          </div>
          
      </div>
      <div class="btn-box">
        <div class="button">
          <button type="button" class="list-btn" onclick="fn_go_to_link('${pageContext.request.contextPath}/clientboard/serviceListOk.clb')">목록</button>
 <c:if test="${boardRow.getUserId() == userId }">
          <button type="button" class="modify-btn" onclick="location.href='${pageContext.request.contextPath}/clientboard/serviceUpdate.clb?boardNumber=${boardRow.getBoardNumber()}'" >수정</button>
          <button type="button" class="delete-btn" onclick="location.href='${pageContext.request.contextPath}/clientboard/serviceDeleteOk.clb?boardNumber=${boardRow.getBoardNumber()}'">삭제</button>
</c:if>
        </div>
      </div>
      
      <div class="comment-form">
	      <form id="comment-form">
	      	<input type="hidden" name="boardNumber" value="${clientBoard.getBoardNumber()}">
	      	<div class="form-group">
	      		<textarea name="content" id="content" placeholder="댓글 내용을 입력하세요."></textarea>
	      	</div>
	      		<button type="button" class="submit-btn">댓글 작성</button>
	      </form>
      </div>
      
      <div class="comment-list">
      	<ul id="comment-list">
      		<li>
      			<div class="comment-info">
      				<span class="writer">홍길동</span>   <!-- 작성자 데이터 --> 
      				<span class="date">2023-04-05</span>	<!-- 현재날짜 시간 데이터 -->
      			</div>
      			<div class="comment-content-wrap">
      				<div class="comment-content">
      					<p>안녕!!!!</p>	<!-- 댓글내용 -->
      				</div>
	      			<div class="comment-btn-group">
	      				<button type=button class="comment-modify-ready" data-number="${reply.replyNumber}">수정</button>
	      				<button type=button class="comment-delete" data-number="${reply.replyNumber}" >삭제</button>
	      			</div>
	      			<div class="comment-btn-group none">
	      				<button type=button class="comment-modify">수정완료</button>
	      			</div>
      			</div>
      		</li>
      	</ul>
      </div>
    </main>
    <footer>
    	<jsp:include page="${pageContext.request.contextPath}/app/footer.jsp"/>
    </footer>
  </body>
  <script type="text/javascript"> function fn_go_to_link(link){location.href=link;}</script>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script> let userNumber = "${sessionScope.userNumber}"; </script>
  <script src="${pageContext.request.contextPath}/assets/js/clientboard/clientboardread.js"></script>
  
</html>
