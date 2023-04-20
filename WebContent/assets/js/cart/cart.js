/** 체크된 항목들 가격 합산 */
function totalPrice(){
	let totalPrice = 	0;
	let checkBox = $('.cart_check:checked');
	
	checkBox.each(function(){
		totalPrice += parseInt($(this).closest('.cart-tr2').find('.sell-price--in').text());
	});
	
	$('.cart-sum-price').text(totalPrice);
}

/* 장바구니 페이지 로딩 시 총금액 출력*/
window.onload = totalPrice();
$('.cart-sum-price').text(totalPrice);

/* 개수 업다운 버튼 클릭 시 우측 가격 변동 */
let $add = $(".bi-arrow-up-square");
let $minus = $(".bi-arrow-down-square");

$add.on('click', function(){
	let ea = parseInt($(this).closest('.options').find('.quantity--in').text());
	let price = $(this).data('price');
	
	$(this).closest('.options').find('.quantity--in').text(ea+1);
	$(this).closest('.cart-tr2').find('.sell-price--in').text(price*(ea+1));
	
	$(this).closest('.options').find('.productEa').val(ea+1);
	$(this).closest('.cart-tr2').find('.productPrice').val(price*(ea+1));
	
	totalPrice();
});

$minus.on('click', function(){
	let ea = parseInt($(this).closest('.options').find('.quantity').text());
	let price = $(this).data('price');
	
	if(ea>1){
		$(this).closest('.options').find('.quantity--in').text(ea-1);
		$(this).closest('.cart-tr2').find('.sell-price--in').text(price*(ea-1));
		
		$(this).closest('.options').find('.productEa').val(ea-1);
		$(this).closest('.cart-tr2').find('.productPrice').val(price*(ea-1));
		
		totalPrice();
	}
});


/* 전체선택버튼 클릭 시 체크박스 전부 체크 */ 
$('#cart_check_all').on('click', function () {
  var checked = $(this).is(":checked");

  if(checked){
     $(this).parents('.cart-form').find('.cart_check').prop("checked", true);
  } else {
     $(this).parents('.cart-form').find('.cart_check').prop("checked", false);
  }

  totalPrice();
});


$('.cart-form').on('click', '.cart_check', function () {
/* 체크박스 하나라도 체크 해제 시 전체선택버튼도 해제 */ 
  var checked = $(this).is(":checked");

  if(!checked){
     $('#cart_check_all').prop("checked", false);
  }

/* 체크박스 전부 체크 시 전체선택버튼도 체크*/
  let selected = $('.cart_check').filter(':checked').length;
  let total = $('.cart_check').length;

  if(selected === total){
    $('#cart_check_all').prop("checked", true);
  } else {
	$('#cart_check_all').prop("checked", false);
  }

  totalPrice();
});

/* 선택삭제 버튼 구현 */
$('.cart-select-delete').on('click', function(){
	selDel();
})

function selDel(){
	let selBox = $('.cart_check').filter(':checked');

	if(selBox.length == 0){
		alert('선택된 상품이 없습니다.');
		return;
	} 

	let selProductNum = [];
	selBox.each(function(){
		selProductNum.push($(this).val());
	});
	
	$.ajax({
      type: 'get',
      url: '/cart/cartDelOk.car',
      data: { productNum : selProductNum },
	  traditional : true,
      success: function(result) {
		alert('상품이 삭제되었습니다.');
		location.reload();
      },
      error: function(a, b, c) {
        alert('상품 삭제에 실패했습니다. 다시 시도해주세요.');
        console.error(c);
      }
    });
	
}

/* 체크된거 제외 hidden으로 하려고 했던거에 disabled 적용, 폼태그를 가져온다음 .submit() */
let $submitBtn = $('.cart-buy-btn');
$submitBtn.on('click', function(){
	$('.cart_check:checked').each(function(i, e){
		$(this).closest('.cart-tr2').find('.productEa').attr("disabled", false);
		$(this).closest('.cart-tr2').find('.productPrice').attr("disabled", false);
	});
	
	$('.cart-form').submit();
})









