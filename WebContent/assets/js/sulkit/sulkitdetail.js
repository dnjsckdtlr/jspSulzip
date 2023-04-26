/**
 * 
 */
/* 장바구니 담기 버튼 */
$('.cartBtn').on('click', function(){
	addCart();
});

function addCart(){
	var url_href = window.location.href;
	var url = new URL(url_href);
	
	let productNumber = url.searchParams.get("num");
	let productPrice = $('#unit_price').text();
	let productEa = $('#total_num').text();
	
	let ajaxResult = '';
	
	$.ajax({
      type: 'get',
      url: '/cart/cartAddOk.car',
	  async : false, // 비동기 통신을 동기 통신으로 사용한다.
      data: { 
		productNumber : productNumber,
		productPrice : productPrice,
		productEa : productEa
	  },
	  dataType: 'json',
      success: function(result) {
		if(result == "login"){
			alert('로그인이 필요합니다.');
			window.location.href='/user/login.usr';
			ajaxResult = 'login';
		}else if(result == "fail"){
			alert('이미 장바구니에 담긴 상품입니다.');
		}else{
			alert('장바구니에 담겼습니다.');
			
		}
      },
      error: function(a, b, c) {
        alert('장바구니 담기에 실패했습니다. 다시 시도해주세요.');
        console.error(c);
      }
    });

	return ajaxResult;
}

/* 바로 구매하기 버튼  */
$('.orderBtn').on('click', function(){
	if(addCart()){
		window.location.href='/user/login.usr';
		return;
	}
	window.location.href='/cart/cart.car';
});