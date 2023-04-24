/**
 * 
 */

let $imgPreview = $('.img-preview');

$('#ex-file').on('change', function() {
	removePreview();

	let files = checkLength(this.files, 1);

	console.log("1");
	addPreview(files);
	console.log("3");

});
function checkLength(files, length) {

	if (files.length > length) {
		alert(`파일은 최대 ${length}개까지만 가능합니다.`);
		return files;
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