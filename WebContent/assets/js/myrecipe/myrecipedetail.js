/**
 * 
 */
let $bigImg = $(".card-img-top");
let $smallImg = $(".preview");

$smallImg.on("click", function(){
	let src = $(this).find('img').attr('src');
	$bigImg.attr("src", src);
});
