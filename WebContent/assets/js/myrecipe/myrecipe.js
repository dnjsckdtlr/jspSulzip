/**
 * 
 */
console.log("aaa");

let $inside = $('.inside');


$inside.on('click', function() {
	let mrbNum = $(this).closest('.card').data('num');
	
	window.location.href = "/myrecipe/myRecipeDetail.mrb?num=" + mrbNum;
	console.log(mrbNum);
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
	console.log($card);
}

alignItem();