/**
 * 
 */

console.log("aaa");

let $inside = $('.inside');


$inside.on('click', function() {
	let num = $(this).closest('.card').data('num');
	
	window.location.href = "/product/ingredientsDetail.prd?num=" + num;
	console.log(num);
});