/**
 * 
 */


$('.inside').on('click', function() {
	let num = $(this).closest('.card').data('num');
	let address = window.location.href
	
	if(address.includes("/alcohol.prd")){
		window.location.href = `/product/alcoholDetail.prd?num=${num}`
	}else if(address.includes("/ingredients.prd")){
		window.location.href = `/product/ingredientsDetail.prd?num=${num}`
	}else if(address.includes("/supplies.prd")){
		window.location.href = `/product/suppliesDetail.prd?num=${num}`
	}
	
});

$('.btn').on('click',function(){
	let order = $(this).data("order");
	let address = window.location.href
	
	if(address.includes("/alcohol.prd")){
		window.location.href = `/product/alcohol.prd?order=${order}`
	}else if(address.includes("/ingredients.prd")){
		window.location.href = `/product/ingredients.prd?order=${order}`
	}else if(address.includes("/supplies.prd")){
		window.location.href = `/product/supplies.prd?order=${order}`
	}
	
});