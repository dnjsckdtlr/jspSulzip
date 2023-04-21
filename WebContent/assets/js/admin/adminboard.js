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


$('.search').on('click', function(){
	let keyword = $('#keyword').val();
	let select = $('#id').val();
	let category = $('.ctg:checked').val();
	/*let resultEa = 0;*/
	
	console.log(select);
	
	console.log("aaa");

	$.ajax({
		url : '/admin/boardSearch.adm',
		type : 'get',
		data : {
			category : category,
			keyword : keyword,
			select : select
		},
		dataType: 'json',
		success : function(result){
			console.log(result);
			showList(result, category);
		},
		error : function(a,b,c){
			console.error(c);
		}
	});
});

function showList(list, category){
	let text="";
	let cate = category == 'M' ? '나만의 레시피' : '고객센터'; 
	
	list.forEach(content =>{
		text += `
			<div class="list-ctg-2">
		                <div class="ctg-1"><input type="checkbox" class="cbox"></div>
		                <div class="ctg-2">
								${cate}
		                </div>
		                <div class="ctg-3"><span>${content.title}</span></div>
		                <div class="ctg-4"><span>${content.id}</span></div>
		                <div class="ctg-5">
		                  <button>글보기 ></button>
		                  <button>글삭제 ></button>
		                </div>
	              	</div>
						
						`
	});
	$('.board-list').html(text);
}


let $read = $('.read');


$read.on('click', function() {
	console.log("안뇽");
	let mrbNum = $(this).data('num');
	
	window.location.href = "/myrecipe/myRecipeDetail.mrb?num=" + mrbNum;
	console.log(mrbNum);
});

let $delete = $('.delete-2');

$delete.on('click', function(){
let $boardNumber = $(this).data('num');

console.log($boardNumber);
	
	alert("정말 삭제하시겠습니까?")
	console.log("gg");
	
	$.ajax({
		url : '/admin/boardDelete.adm',
		type : 'get',
		data : {
			myRecipeNumber : $boardNumber
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


















