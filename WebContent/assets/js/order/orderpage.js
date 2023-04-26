//주문정보
$(".order-info-title").click(() => {
  $(".togle1-img").toggleClass("toggle-arrow");
  $(".info-content").toggleClass("toggle-info-content");
  $(".info-content-box").toggleClass("toggle-box");
});

//결제정보
$(".payment-title").click(() => {
  $(".togle2-img").toggleClass("toggle-arrow");
  $(".payment-all").toggleClass("toggle-payment-all");
  $(".payment-all-box").toggleClass("toggle-box");
});

//무통장입금
$(".paying-type1").click(() => {
  $(".paying-content").toggleClass("toggle-paying-content");
  $(".paying-content-box").toggleClass("toggle-box-open");
  $(".bi-check-circle").toggleClass("check-circle-none");
  $(".bi-check-circle-fill").toggleClass("check-circle-none");
  if ($(".bi-check-circle").hasClass("check-circle-none")) {
    $("#radio-bank").prop("checked", true);
  } else {
    $("#radio-bank").prop("checked", false);
  }
  if ($(".bi-check-circle2").hasClass("check-circle-none")) {
    $(".bi-check-circle2").toggleClass("check-circle-none");
    $(".bi-check-circle-fill2").toggleClass("check-circle-none");
  }
});

//신용카드
$(".paying-type2").click(() => {
  $(".bi-check-circle2").toggleClass("check-circle-none");
  $(".bi-check-circle-fill2").toggleClass("check-circle-none");
  if ($(".bi-check-circle2").hasClass("check-circle-none")) {
    $("#radio-card").prop("checked", true);
  } else {
    $("#radio-card").prop("checked", false);
  }
  if ($(".bi-check-circle").hasClass("check-circle-none")) {
    $(".paying-content").toggleClass("toggle-paying-content");
    $(".paying-content-box").toggleClass("toggle-box-open");
    $(".bi-check-circle").toggleClass("check-circle-none");
    $(".bi-check-circle-fill").toggleClass("check-circle-none");
  }
});

/* 장바구니 페이지 로딩 시 총금액 출력*/
window.onload = totalPrice();

/** 체크된 항목들 가격 합산 */
function totalPrice(){
	let totalPrice = 0;
	let prices = $('.unitPrice');
	
	prices.each(function(){
		totalPrice += parseInt($(this).text().replace(/\,/g,""));
	});
	
	$('.productTotalPrice').val(totalPrice);
	$('.final-price').text(totalPrice.toLocaleString()+"원");
}


$('.order-btn-box').on('click', function(){
   if($('#radio-card').is(":checked")){
      payModule();
   }else if( $('#radio-bank').is(":checked") )	{
		if( $('.pickupbtn').val() == null ){
			alert('픽업장소를 선택해주세요.');
		}else if( $('.accountName').val() == '' ){
			alert('입금자명을 입력해주세요.');
		}else{
			$('.cart-form').submit();
			alert('입금이 확인되면 안내 문자가 발송됩니다.');
		}
	}else{
		alert('결제수단을 선택해주세요.');
	}
   
});

  function payModule(){	
    const IMP = window.IMP;
    IMP.init("imp24463063"); // 가맹점 식별 코드를 넣어 모듈을 초기화해주세요.

    IMP.request_pay({
        pg : 'html5_inicis.INIBillTst',  // 실제 계약 후에는 실제 상점아이디로 변경
        pay_method : 'card', // 'card'만 지원됩니다.
        /* merchant_uid: "order_monthly_00012", // 상점에서 관리하는 주문 번호 */
        merchant_uid: "order_" + new Date().getTime(), // 상점에서 관리하는 주문 번호
        name : "SUL.ZIP결제",
   		amount : $("#final_price").text().replace(",","").replace("원","").trim(), // 결제창에 표시될 금액. 실제 승인이 이뤄지지는 않습니다.
	/* customer_uid : 'your-customer-unique-id2'+new Date().getTime(), // 필수 입력. */
        customer_uid : $('.userId')+new Date().getTime(), // 필수 입력.
        buyer_email : $('.userEmail').text(),
        buyer_name : $('.userName').text(),
        buyer_tel : $('.userPhone').text(),
	// 	m_redirect_url : '{모바일에서 결제 완료 후 리디렉션 될 URL}'
    }, function(rsp) {
        if ( rsp.success ) {
           $('.cart-form').submit();
        	alert('정상 결제 되었습니다.');
        	console.log(rsp);
        } else {
        	 alert(`결제에 실패하였습니다. 에러 내용: ${rsp.error_msg}`);
        }
    });
  }














