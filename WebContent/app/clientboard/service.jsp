<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/clientboard/service.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font/nanumbarungothicsubset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
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
    <div class="tabmenu-black">
        <a href="">
            <img src="${pageContext.request.contextPath}/assets/img/banner/csbanner.jpg" alt="">
        </a>
    </div>

    <div class="write-btn-box">
       <button type="button" onclick="fn_go_to_link('${pageContext.request.contextPath}/clientboard/serviceWrite.clb')"><span>글쓰기</span></button>
    </div>

    <section class="main">
        <h1 class="d-none">게시판</h1>
            <div class="board">
                <table class="table">
                    <thead class="thead">
                        <tr>
                            <td>번호</td>
                            <td>글제목</td>
                            <td>작성자</td>
                            <td>작성일</td>
                        </tr>
                    </thead>

                    <tbody class="tbody">
			  			<c:choose>
			               <c:when test="${not empty boardList}">
			                  <c:forEach var="board" items="${boardList}" varStatus="status">
			                     <tr>
			                     <c:set var="rownum" value="${total-((page-1)*rowCount)}"/>
			                        <td class="no"><c:out value="${rownum-status.index}"/></td>
			                        <td class="title">
			                        	<a href="${pageContext.request.contextPath}/clientboard/serviceReadOk.clb?boardNumber=${board.getBoardNumber()}">
			                        	<c:out value="${board.getBoardTitle()}"/>
			                        	</a>
			                        </td>
			                        <td class="author"><c:out value="${board.getUserId()}"/></td>
			                        <td class="date"><c:out value="${board.getBoardDate()}"/></td>
			                     </tr>
			                  </c:forEach>
			               </c:when>
			               <c:otherwise>
			                  <tr>
			                     <td colspan="4" align="center">등록된 게시물이 없습니다.</td>
			                  </tr>
			               </c:otherwise>
			            </c:choose>

                    </tbody>

                </table>

                <div class="pagination-area ">
                    <style>
                        .page-link {
                          color: #000; 
                          background-color: #fff;
                          border: 1px solid #ccc; 
                        }
                        
                        .page-item.active .page-link {
                         z-index: 1;
                         color: #555;
                         font-weight:bold;
                         background-color: #f1f1f1;
                         border-color: #ccc;
                         
                        }
                        
                        .page-link:focus, .page-link:hover {
                          color: #000;
                          background-color: #fafafa; 
                          border-color: #ccc;
                        }
                        </style>
                    <nav aria-label="...">
                        <ul class="pagination">
                        <c:if test="${prev}">
	                         <li class="page-item">
	                            <a class="page-link" href="?page=<c:out value='${startPage-1}'/>" tabindex="-1"><</a>
	                          </li>
                        </c:if>
<c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
							<c:set var="disabledClass" value="" />
							<c:if test="${page eq pageNum}">
								<c:set var="disabledClass" value="disabled" />
							</c:if>
							
	                        <li class="page-item <c:out value='${disabledClass}' />">
	                        	<a class="page-link" href="?page=<c:out value='${pageNum}'/>"><c:out value="${pageNum}"/></a>
                        	</li>
</c:forEach>
						<c:if test="${next}">
                         	<li class="page-item">
                            	<a class="page-link" href="?page=<c:out value='${endPage+1}'/>">></a>
                          	</li>
                        </c:if>
                        </ul>
                      </nav>
                </div>
            </div>
    </section>
	<footer>
		<jsp:include page="${pageContext.request.contextPath}/app/footer.jsp"/>
	</footer>
</body>
<script type="text/javascript">function fn_go_to_link(link){location.href=link;}</script>
</html>