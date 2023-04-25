/* 카테고리 선택 시 술과 재료 목록 나오기 */

console.log("aaa");

$('.all').on('change', '.category', function(){
	var v = $(this).val();
		if (v == 2) {
			$(this).siblings('.alcohol').show();
			$(this).siblings('.ingre').hide();
			$(this).siblings('.vol').show();
		} else if (v == 3) {
			$(this).siblings('.alcohol').hide();
			$(this).siblings('.ingre').show();
			$(this).siblings('.vol').show();
		} else if (v == 1) {
			$(this).siblings('.alcohol').hide();
			$(this).siblings('.ingre').hide();
			$(this).siblings('.vol').hide();
		}
});


/* 재료정보 개수 추가 */
let $plusBtn = $(".bi-plus-circle-fill");
let $minusBtn = $(".bi-dash-circle-fill");
let $sample = $(".ingre-sample");

$plusBtn.on("click", function(){
	plus();
});

$minusBtn.on("click", function(){
	minus();
})

function plus() {
	let cnt = $(".ingre-box").length;
	if(cnt<11){
		$(".all").append($sample.html());
		$('.ingre-box').last().find('div').text(cnt+'.');
		$('.ingre-cnt').text(cnt);
	}
}

function minus(){
	let cnt = $(".ingre-box").length;
	if(cnt>2){
		$('.ingre-box').last().remove();
		$('.ingre-cnt').text(cnt-2);
	}
}

/*===============================================*/
/* 이미지 업로드 시 미리보기 나오기 */


let $imgPreview = $('.img-preview');

$('#ex-file').on('change', function() {
	removePreview();

	let files = checkLength(this.files, 1);

	console.log("1");
	addPreview(files);
	console.log("3");
	addFile(files);

});
function checkLength(files, length) {

	if (files.length > length) {
		alert(`파일은 최대 ${length}개까지만 가능합니다.`);
		return new DataTransfer().files;
	}
	return files;
}

function addPreview(files) {
	for (let i = 0; i < files.length; i++) {
	let src = URL.createObjectURL(files[i]);
	$imgPreview.html(
		`<li class="preview-li">
			<div class="preview-img-box">
                <img src="${src}" class="preview-img" />
              </div>
              <div class="preview-cancel-box">
                <button type="button" class="img-cancel-btn" data-name="${files[i].name}">
                  삭제
                </button>
              </div>
			</li>`
	).css('background-color', 'white');
	}
}

/* 미리보기 이미지 삭제버튼 구현 */
$imgPreview.on('click', '.img-cancel-btn', function() {
	/* 화면에서 삭제 */
	$(this).parent().parent().remove();

	/* 파일배열에서 삭제 */
	let files = $("#ex-file").files;
	let dt = new DataTransfer();

	$("#ex-file")[0].files = dt.files;

	/* 미리보기 삭제 */
	removePreview();
});

/* 미리보기 삭제 */
function removePreview() {
	$imgPreview.html(``).css('background-color', '#f5f5f5');
}

/* 파일 처리 */
function addFile(files){
	let  $fileInput = $('.myRecipeFileInput');
	
	$fileInput[0].files = files;
	
	console.log($fileInput[0].files);
}








