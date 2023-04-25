/**
 * 
 */


$('#checkAll').on('click', function(){
	
	if($(this).is(':checked')){
		$('.cbox').prop('checked', true);	
	}else{
		$('.cbox').prop('checked', false);	
	}
});

$('.ctg-list').on('click', '.cbox' , function(){
	$('#checkAll').prop('checked', false);
});



$('#search-btn').on('click', function(){
	let keyword = $('#search-keyword').val();
	let category = $('input[name=product]:checked').val();
	let language = $('#product-name').val();
	let resultEa = 0;

	$.ajax({
		url : '/admin/search.adm',
		type : 'get',
		data : {
			keyword : keyword,
			category : category,
			language : language	
		},
		dataType: 'json',
		success : function(result){
			showList(result);
			resultEa = result.length;
			$('.ea').text(resultEa);
		/*	console.log(resultEa);*/
		},
		error : function(a,b,c){
			console.error(c);
		}
	});
});

function showReply(replies){
	  let text = "";
	  replies.forEach(reply => {
      text += `
      `
})};

function showList(list){
	let text = "";
	
	list.forEach(content => {
		text += `
			<div class="ctg-list-box">
               	 <div class="list-check"><input type="checkbox" class="cbox"/></div>
                	<div class="list-code"> ${content.number}</div>
                	<div class="list-ctg">`

		if(content.category == 0){
			text+= '칵테일 키트';
		}else if(content.category == 2){
			text += '술';
		}else if(content.category == 3){
			text += '재료';
		}else if(content.category == 4){
			text += '용품';
		}
		text +=	`</div>
                	<div class="list-name">${content.nameKor} <br/> ${content.nameEng}</div>
              	  <div class="list-price">${content.price}</div>
              </div>
		`;
	});
	
	
	$('.ctg-list').html(text);
}

$('.ea')


/* 게시글 삭제 */

let $delete = $('#board-delete');

$delete.on('click', function(){
	let productAr = [];
	$('.cbox:checked').each(function(i, item){
		
		productAr.push($(this).closest('.ctg-list-box').find('.list-code').text().trim());
	});
	
	console.log(productAr)
	/*let $sulkitNumber = $(this).data('num');*/
	alert("정말 삭제하시겠습니까?")
	
	$.ajax({
		url : '/admin/productDelete.adm',
		type : 'get',
		traditional : true,
		data : {
			productNumber : productAr
		},
		success : function(){
			location.reload();
			alert("삭제되었습니다.")
		},
		error : function(a,b,c){
			console.error(c);
		}
	});
});
















