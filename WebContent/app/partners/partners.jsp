<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>partners</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/partners/partners.css">
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
    <script type="text/javascript">
    function fn_access_check(){
    	let userId = '${userId}';
    	console.log(userId);
    	if(userId == null || userId == ""){
    		alert("로그인 회원전용 페이지입니다. 메인으로 이동합니다.");
    		location.href="/";
    	}
    }
    </script>
    <style>
        .h-ctg6{
			color: black !important;
		}
    </style>
</head>
<body onload="fn_access_check()">
    <header>
    	<jsp:include page="${pageContext.request.contextPath}/app/header.jsp"/>
    </header>
    <div class="container-fluid">
        <div class="img-content">
            <a href="javascript:alert('준비중인 페이지입니다.');">
                <img class="banner-img" src="${pageContext.request.contextPath}/assets/img/banner/partnersbanner.jpg" alt="파트너스이미지">
            </a>
        </div>
    </div>
    <div class="container">
        <div class="content">
            <div class="asidebar">
                <div class="list-nav">
                    <span class="text-muted1">홈 >
                            <span class="text-muted2">파트너스</span>
                    </span>
                </div>
            </div>
            <section class="partners-section">
                <ul>
                    <li>술.zip 회원이 아니거나 로그인이 불가능하면 문의할 수 없습니다.</li>
                    <li>답변은 메일로 받을 수 있으며, 문의 내역에서 조회할 수 없습니다.</li>
                    <li>제휴 문의는 전문가와 상담해 보세요.</li>
                    <li>모든 항목은 *필수 기재사항입니다.</li>
                </ul>
            </section>
            <form id="partnersFrm" action="/partners/inquiryOk.ptn" method="POST">
                <table class="parteners-table">
                    <colgroup class="partners-colgroup">
                        <col class="partners-col1">
                        <col class="partners-col2">
                    </colgroup>
                    <tbody class="partners-tbody">
                        <tr class="partners-tr">
                            <th class="partners-th">*상호명</th>
                            <td class="partners-td">
                                <input type="text" name="partnersName" id="name" class="partners_name" required>
                            </td>
                        </tr>
                        <tr class="partners-tr">
                            <th class="partners-th">*연락처</th>
                            <td class="partners-td">
                                <input type="text" name="partnersContact" id="contact" class="partners_number" required>
                            </td>
                        </tr>
                        <tr class="partners-tr">
                            <th class="partners-th">*이메일</th>
                            <td class="partners-td">
                                <input type="text" name="partnersEmail" id="email" class="partners_email"> <span class="text-details" required>답변은 이메일로 발송드립니다.</span>
                            </td>
                        </tr>
                        <tr class="partners-tr">
                            <th class="partners-th">*점포지역(구)</th>
                            <td class="partners-td">
                                <input type="text" name="partnersLoc" id="loc1" class="partners_loc"> <span class="text-details" required>점포가 위치한 지역구를 기재해주시면 됩니다.</span>
                            </td>
                        </tr>
                        <tr class="partners-tr">
                            <th class="partners-th">*점포지역</th>
                            <td class="partners-td">
                                <input type="text" name="partnersLocation" id="loc2" class="partners_location"> <span class="text-details" required>점포가 위치한 상세주소를 기재해주시면 됩니다.</span>
                            </td>
                        </tr>
                        <tr class="partners-tr">
                            <th class="partners-th">*문의내용</th>
                            <td class="partners-td">
                                <textarea name="partnersContent" id="content" class="partners_inquiry" id="" cols="100" rows="10" placeholder="문의해 주시면 1시간 내에 신속히 답변해 드립니다. (주말과 공휴일에는 답변이 늦어질 수 있습니다.) 이름, 전화번호, 이메일 주소 등은 개인 정보 노출의 위험이 있으므로, 문의 내용에는 입력하지 않는 것이 좋습니다. 또한, 문의 내용에 xml 소스를 입력하는 경우 답변에 제한이 있을 수 있습니다." required></textarea>
                            </td>
                        </tr>
                    </tbody>
                </table>
            
                <div class="agree-area">
                    <div class="chk-box">
                        <input type="checkbox" name="" id="agree" class="chk-box" value="1">
                        <label for="agree-privacy">(아래)개인정보 수집·이용에 동의합니다.</label>
                        <div class="agree-text">
                            <p>수집하는 개인정보의 항목</p>
                            <ul><li>이메일, 휴대전화</li></ul>
                            <br/>
                            <p>개인정보의 수집·이용목적</p>
                            <ul><li>이메일, 휴대전화: 문의 사항에 대한 답변을 전달하기 위한 의사소통 경로의 확보</li></ul>
                            <br/>
                            <p>개인정보의 보유 및 이용기간</p>
                            <ul><li>원칙적으로 개인정보의 수집·이용 목적 달성 시 바로 파기합니다.</li></ul>
                            <ul><li>수집·이용 목적을 달성한 경우에도 법률의 규정에 따라 보존할 필요가 있다면 고객의 개인정보를 보유할 수 있습니다.</li></ul>
                            <ul class="agree-details">
                                <li>- 계약 또는 청약철회 등에 관한 기록: 5년</li>
                                <li>- 대금결제 및 재화등의 공급에 관한 기록: 5년</li>
                                <li>- 소비자의 불만 또는 분쟁처리에 관한 기록: 3년 등</li>
                            </ul>
                        </div>
                    </div> 
                </div>
                <div class="submit-div"><button onclick="fn_partners_submit();" class="submit-btn">상담신청</button></div>
            </form>
        </div>
    </div>
    <footer>
    	<jsp:include page="${pageContext.request.contextPath}/app/footer.jsp"/>
    </footer>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/partners/partners.js"></script>
  
</body>
</html>