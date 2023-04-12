/**
 * 
 */
 
/*체크박스 전체선택*/
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
	let keyword = $('#keyword').val();
	let select = $('#p-info').val();
	let date = $('#date').val();
	let gender = $('.gender:checked').val();
	let resultEa = 0;

	$.ajax({
		url : '/admin/userSearch.adm',
		type : 'get',
		data : {
			keyword : keyword,
			select : select,
			date : date,
			gender : gender
		},
		dataType: 'json',
		success : function(result){
			console.log(result);
			showList(result);
			resultEa = result.length;
			$('.ea').text(resultEa);
		},
		error : function(a,b,c){
			console.error(c);
		}
	});
});

function showList(list){
	let text = "";
	
	list.forEach(content => {
		text += `
		<div class="result-box">
            	<ul class="search-result-box">
	              <li>
	                <div class="search-result-div"><input type="checkbox" class="cbox"/></div>
	              </li>
	              <li>
	                <div class="search-result-div"><span>${content.userName }</span></div>
	              </li>
	              <li>
	                <div class="search-result-div"><span>${content.userId}</span></div>
	              </li>
	              <li>
	                <div class="search-result-div"><span>${content.userPhone }</span></div>
	              </li>
	              <li>
	                <div class="search-result-div"><span>${content.userGender }</span></div>
	              </li>
	              <li>
	                <div class="search-result-div"><span>${content.userRegistrationDate }</span></div>
	              </li>
            	</ul>
            </div>
		`
	});
	
	$('.search-result').html(text);
	
	$('.ea');
}




















