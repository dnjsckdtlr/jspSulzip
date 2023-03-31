<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user/join.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font/nanumbarungothicsubset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
    <title>join</title>
<!--     //int userNumber;
//String userStatus;
//String userRegistrationDate;
//String userId;
//String userPw;
//String userName;
//String userPhone;
//String userGender;
//String userEmail;
//String userRegistrationNumber; -->
    
</head>
<body>
    <header>
    	<jsp:include page="${pageContext.request.contextPath}/app/header.jsp"/>
    </header>
    <main class="main">
        <section class="section1">
            <div class="title">회원 가입</div>
        </section>
        <section class="section2">
            <div class="sub-title">회원정보입력</div>
            <form action="/user/joinOk.usr" method="POST">
            <table class="join-table">
                <colgroup class="join-colgroup">
                    <col class="join-col1">
                    <col class="join-col2">
                </colgroup>
                <tbody class="join-tbody">
                    <tr class="join-tr">
                        <th class="join-th">아이디</th>
                        <td class="join-td">
                            <input type="text" name="userId" class="join_id" autofocus><span class="text-details">&nbsp;영문자, 숫자, _만 입력 가능. 최소 3자 이상 입력하세요.</span>
                        </td>
                    </tr>
                    <tr class="join-tr">
                        <th class="join-th">비밀번호</th>
                        <td class="join-td">
                            <input type="text" name="userPw" class="join_pw">
                        </td>
                    </tr>
                    <tr class="join-tr">
                        <th class="join-th">비밀번호 확인</th>
                        <td class="join-td">
                            <input type="text" class="join_pwconfirm">
                        </td>	
                    </tr>
                    <tr class="join-tr">
                        <th class="join-th">이름</th>
                        <td class="join-td">
                            <input type="text" name="userName" class="join_name">
                        </td>
                    </tr>
                    <tr class="join-tr">
                        <th class="join-th">주민등록번호</th>
                        <td class="join-td">
                            <input type="text" name="userRegistrationNumber" class="join_userRegistrationNumber">
                        </td>
                    </tr>
                    <tr class="join-tr">
                        <th class="join-th">성별</th>
                        <td class="join-td">
                            <input type="radio" name="userGender" value="M" class="join_male" checked="checked">남성
                            <input type="radio" name="userGender" value="F" class="join_female">여성
                        </td>
                    </tr>
                    <tr class="join-tr">
                        <th class="join-th">이메일</th>
                        <td class="join-td">
                            <input type="text" name="userEmail" class="join_email">
                        </td>
                    </tr>
                    <tr class="join-tr">
                        <th class="join-th">휴대폰번호</th>
                        <td class="join-td">
                            <input type="text" name="userPhone" class="join_contact">
                        </td>
                    </tr>
                    <!-- <tr class="join-tr">
                        <th class="join-th">주소</th>
                        <td class="join-td">
                            <input type="text" name="join_address1" class="join_address1"><br/>
                            <input type="text" name="join_address2" class="join_address2"><br/>
                            <input type="text" name="join_address3" class="join_address3">
                        </td>
                    </tr>                    -->
                </tbody>
            </table>    
            </section>
  <div class="panelpaneldefault">
    <div class="panel-heading">
            <strong>약관동의</strong>
        </div>
        <div class="panel-body" style="padding: 15px 0; ">
            <div class="register-agree">
                <div class="agree-wrap">
                    <div class="all-check">
                        <input type="checkbox" id="agree_all"><label for="agree_all">전체 동의합니다.</label>
                    </div>
                    <ul class="check-list-agrees">
                        <li class="agree di_flex">
                            <input type="checkbox" name="agree" id="agree" value="1"><label for="agree">회원가입약관 동의</label>
                            <a href="#none" data-toggle="modal" data-target="#decView01" class="view_dec text-right">내용보기</a>
                        </li>
                        <li class="agree di_flex">
                            <input type="checkbox" name="agree2" id="agree2" value="1"><label for="agree2">개인정보처리방침안내 동의</label>
                            <a href="#none" data-toggle="modal" data-target="#decView02" class="view_dec text-right">내용보기</a>
                        </li>
                    </ul>
                    <p class="agree-info">회원가입약관 및 개인정보처리방침안내의 내용에 동의하셔야 회원가입 하실 수 있습니다.</p>
                </div>
        </div>
    </div>
  </div>


        <section class="section3">
            <!-- fewfew-->
                          
            <!--fwrGVWEGWREF-->
            <button type="submit" class="join-btn-cancel" onclick="history.back()">취소</button>
            <button type="submit" class="join-btn-submit" accesskey="s">확인</button>
        </section>
        </form>
        
    </main>
    <footer>
    	<jsp:include page="${pageContext.request.contextPath}/app/footer.jsp"/>
    </footer>
</body>
</html>