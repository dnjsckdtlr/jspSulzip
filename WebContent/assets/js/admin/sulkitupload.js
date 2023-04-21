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

/* 이미지 업로드 시 미리보기 나오기 */
let $imgPreview = $('.img-preview');

$('#ex-file').on('change', function() {
	removePreview();

	let files = checkLength(this.files, 3);

	fileInput(files);

	addPreview(files);

});

/* 업로드한 파일 3개 이상이면 알림창 */
function checkLength(files, length) {

	if (files.length > length) {
		alert(`파일은 최대 ${length}개까지만 가능합니다.`);
		return files;
	}
	return files;
}

/* 미리보기 이미지와 삭제버튼 만들기*/
function addPreview(files) {
	for (let i = 0; i < files.length; i++) {
		let src = URL.createObjectURL(files[i]);
		$imgPreview.eq(i).html(
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
	let files = $("#ex-file")[0].files;
	let fileName = $(this).data('name');
	let dt = new DataTransfer();

	for (let i = 0; i < files.length; i++) {
		if (files[i].name !== fileName) {
			dt.items.add(files[i]);
		}
	}

	$("#ex-file")[0].files = dt.files;

	/* 파일인풋 수정 */
	fileInput($("#ex-file")[0].files);

	/* 취소버튼 누르면 사진 앞으로 정렬 */
	removePreview();
	addPreview($("#ex-file")[0].files);
});

/* 미리보기 전체 삭제 */
function removePreview() {
	for (let i = 0; i < $imgPreview.length; i++) {
		$imgPreview.eq(i).html(``).css('background-color', '#f5f5f5');
	}
}

/* 인풋파일 리스트 쪼개서 인풋에 하나씩 담기*/
function fileInput(files) {
	let $input = $(".myRecipeFileInput");

	for (let i = 0; i < 3; i++) {
		/* 넣은거 초과는 비어있게끔 */
		if (i >= files.length) {
			let dt = new DataTransfer();

			$input[i].files = dt.files;
		} else {
			/* 넣은거 이하는 순서대로 파일 넣기 */
			let dt = new DataTransfer();
			dt.items.add(files[i]);

			$input[i].files = dt.files;
		}
	}
}

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










