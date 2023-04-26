/**
 * 
 */
let $inside = $('.inside');

$inside.on('click', function() {
	let num = $(this).closest('.card').data('num');
	
	window.location.href = "/sulkit/sulkitDetail.suk?num=" + num;
});

function alignItem(){
	let $cardGroup = $('.card-group');
	let lineCount = $cardGroup.length;
	let idx = lineCount - 1;
	
	let $card = $cardGroup.eq(idx).find('.card');
	let needItemCount = 3 - $card.length;
	
	for(let i=0; i<needItemCount; i++){
		$cardGroup.eq(idx).append(`<div class="card"></div>`);
	}
	
}

alignItem();

/* 정렬버튼 */
$('.btn').on('click',function(){
	let order = $(this).data("order");
	window.location.href = `/sulkit/sulkit.suk?order=${order}`
});