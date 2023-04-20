/**
 * 
 */
 $('.cartBtn').on('click', function(){
	addCart();
}) 

function addCart(){
	var url_href = window.location.href;
	var url = new URL(url_href);
	
	let productNumber = url.searchParams.get("num");
	let productPrice = $('#unit_price').text();
	let productEa = $('#total_num').text();
	
	$.ajax({
      type: 'get',
      url: '/cart/cartAddOk.car',
      data: { 
		productNumber : productNumber,
		productPrice : productPrice,
		productEa : productEa
	  },
	  dataType: 'json',
      success: function(result) {
		if(result == "fail"){
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
}