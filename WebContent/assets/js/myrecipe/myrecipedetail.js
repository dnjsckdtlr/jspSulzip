/**
 * 
 */
let $bigImg = $(".card-img-top");
let $smallImg = $(".preview");

$smallImg.on("click", function(){
	let src = $(this).find('img').attr('src');
	$bigImg.attr("src", src);
});


$('#deleteBtn').on('click', function(){
	if(confirm('정말 삭제하시겠습니까?')){
		alert('삭제되었습니다.');
		window.location.href="/myrecipe/myRecipeDelete.mrb";
	}else{
		alert('취소되었습니다.');
	}
});