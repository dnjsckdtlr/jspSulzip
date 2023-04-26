<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user/edituserinfo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font/nanumbarungothicsubset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <title>edituserinfo</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.4.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/user/edituserinfo.js"></script>
</head>
<body>
    <header>
    	<jsp:include page="${pageContext.request.contextPath}/app/header.jsp"/>
    </header>
    <main class="main">
        <section class="section1">
            <div class="title">회원 정보 수정</div>
        </section>
        <form action="/user/edituserinfoOk.usr" id="edituserFrm" method="POST">
	        <section class="section2">
	            <div class="sub-title">회원정보입력</div>
	            <table class="edit-table">
	                <colgroup class="edit-colgroup">
	                    <col class="edit-col1">
	                    <col class="edit-col2">
	                </colgroup>
	                <tbody class="edit-tbody">
	                    <tr class="edit-tr">
	                        <th class="edit-th">아이디</th>
	                        <td class="edit-td">
	                            <input type="text" name="userId" value="${userDTO.userId}" class="edit_id" readonly>
	                        </td>
	                    </tr>
	                    <tr class="edit-tr">
	                        <th class="edit-th">변경 할 비밀번호</th>
	                        <td class="edit-td">
	                        	<input type="hidden" id="userPw" name="userPw" />
	                            <input type="password" id="userChangePw" class="edit_pw" autofocus>
	                            <br/><span class="check-msg" id="check-pw-msg"></span>
	                        </td>
	                    </tr>
	                    <tr class="edit-tr">
	                        <th class="edit-th">변경 할 비밀번호 확인</th>
	                        <td class="edit-td">
	                            <input type="password" id="userChangePwConfirm" class="edit_pwconfirm">
	                            <br/><span class="check-msg" id="check-pw-msg2"></span>
	                        </td>
	                    </tr>
	                    <tr class="edit-tr">
	                        <th class="edit-th">이름</th>
	                        <td class="edit-td">
	                            <input type="text" name="userName" value="${userDTO.userName}" class="edit_name" readonly>
	                        </td>
	                    </tr>
	                    <tr class="edit-tr">
	                        <th class="edit-th">주민등록번호</th>
	                        <td class="edit-td">
	                            <input type="text" name="userRegistrationNumber" value="${userDTO.userRegistrationNumber}" class="edit_registrationNumber" readonly>
	                        	<br/>
	                        	<span class="edit-error-msg" id="edit_userRegistrationNumber_error"></span>
	                        </td>
	                    </tr>
	                    <tr class="edit-tr">
	                        <th class="edit-th">성별</th>
	                        <td class="edit-td">
	                            <input type="radio" name="userGender" value="M" ${userDTO.userGender eq 'M'?'checked':''} class="edit_male" checked="checked" onclick="javascript:return false;">남성
	                            <input type="radio" name="userGender" value="F" ${userDTO.userGender eq 'F'?'checked':''} class="edit_female" onclick="javascript:return false;">여성
	                        </td>
	                    </tr>
	                    <tr class="edit-tr">
	                        <th class="edit-th">이메일</th>
	                        <td class="edit-td">
	                            <input type="text" name="userEmail" value="${userDTO.userEmail}" class="edit_email">
	                        </td>
	                    </tr>
	                    <tr class="edit-tr">
	                        <th class="edit-th">휴대폰번호</th>
	                        <td class="edit-td">
	                            <input type="text" id="userPhone" name="userPhone" value="${userDTO.userPhone}" class="edit_contact">
	                        	<p class="error-msg" style="display: none;">휴대폰번호를 정확히 입력해주세요.ex)000-0000-0000</p>
	                        </td>
	                    </tr>
	                </tbody>
	            </table>
	        </section>
	        <section class="section3">
	            <button type="button" class="edit-btn-cancel" onclick="history.back()">취소</button>
	            <button type="button" onclick="fn_edituser('${userDTO.userId}');" class="edit-btn-submit" >정보수정</button>
	        </section>
        </form>
    </main>
    <footer>
    	<jsp:include page="${pageContext.request.contextPath}/app/footer.jsp"/>
    </footer>
</body>
</html>