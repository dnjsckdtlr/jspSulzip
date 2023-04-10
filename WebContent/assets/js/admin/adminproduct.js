/**
 * 
 */


$('#checkAll').on('click', function(){
	
	if($(this).is(':checked')){
		$('.cbox').attr('checked', true);	
	}else{
		$('.cbox').attr('checked', false);	
	}
});

$('.ctg-list').on('click', '.cbox' , function(){
	$('#checkAll').prop('checked', false);
});



$('#search-btn').on('click', function(){
	let keyword = $('#search-keyword').val();
	let category = $('input[name=product]:checked').val();
	
	console.log(category);
	console.log(keyword);

	$.ajax({
		url : '/admin/search.adm',
		type : 'get',
		data : {
			keyword : keyword,
			category : category	
		},
		dataType: 'json',
		success : function(result){
			showList(result);
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
                	<div class="list-name">${content.nameKor}</div>
              	  <div class="list-price">${content.price}</div>
              </div>
		`;
	});
	
	
	$('.ctg-list').html(text);
}




