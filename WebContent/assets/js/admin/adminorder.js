/**
 * 
 */

$('.search').on('click', function(){
	let date = $('#date').val();
	let keyword = $('#keyword').val();
	let select = $('#order-ctg').val();
	/*let resultEa = 0;*/
	
	console.log(select);
	console.log(keyword);
	
	

	$.ajax({
		url : '/admin/orderSearch.adm',
		type : 'get',
		data : {
			date : date,
			keyword : keyword,
			select : select
		},
		dataType: 'json',
		success : function(result){
			console.log(result);
			showList(result);
		},
		error : function(a,b,c){
			console.error(c);
		}
	});
});

function showList(list){
	let text="";
	
	list.forEach(content =>{
		text += `
			<div class="ctg-list-2">
	                <div class="list-date">${content.orderDate}</div>
	                <div class="list-num">${content.orderNumber}</div>
	                <div class="list-name">${content.userName}</div>
	                <div class="list-product-name">${content.productNameKor}</div>
	                <div class="list-price">${content.productTotalPrice}</div>

	                <div class="list-pay">
						`
					if(content.orderPay == 1){
						text+= '무통장입금';
					}else if(content.orderPay == 2){
						text += '카드';
					}

					text += `
					</div>
	        </div>
					`;
	});
	$('.ctg-list-select').html(text);
}








