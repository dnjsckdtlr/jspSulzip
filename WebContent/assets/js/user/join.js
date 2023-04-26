let $checkMsg = $('#check-id-msg');
let $checkPwMsg = $('#check-pw-msg');
let $checkPwMsg2 = $('#check-pw-msg2');

let $idInput = $('#id');
let $pwInput = $('#pw');
let $pwInput2 = $('#pw2');
   
console.log("안녕1");
$idInput.on('blur', function() {
   if ($(this).val() == '') {
      $checkMsg.text('아이디를 입력하세요!');
   } else {
      let id = $(this).val();
         $.ajax({
            url: '/user/checkIdOk.usr',
            type: 'get',
            data: { "userId": id },
            success: function(result) {
               $checkMsg.text(result);
            }
         });
      };
});


/*영어, 숫자, 특수문자로 이루어진 비밀번호 8글자 이상
    영어 대소문자를 구분하지 않음*/
const regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[a-zA-Z\d!@#$%^&*()_+]{8,}$/;


// 비밀번호 조건체크
/*$pwInput.on('blur', function(){
   if(regex.test( $(this).val() )){
      $checkPwMsg.text("사용가능한 비밀번호 입니다.");
   }else{
      $checkPwMsg.html("사용 불가능한 비밀번호입니다.<br>영어, 숫자, 특수문자를 포함한 8글자 이상으로 작성해주세요.")
   }
   if( $('#pw2').val() != "" && $('#pw').val() == $('#pw2').val()){
      $checkPwMsg2.html("동일한 비밀번호 입니다.")
   }else if( $('#pw2').val() != "" && $('#pw').val() != $('#pw2').val()){
      $checkPwMsg2.text("비밀번호가 일치하지 않습니다.");
   }
});

// 비밀번호 동일확인    
$pwInput2.on('blur', function(){
   console.log($('#pw').val());
   if( $('#pw').val() != $('#pw2').val()){
      $checkPwMsg2.text("비밀번호가 일치하지 않습니다.");
   }else{
      $checkPwMsg2.html("동일한 비밀번호 입니다.")
   }
      
});


$('.join-btn-submit').on('click', function(){
   console.log()
   if($checkMsg.text().includes('사용가능') && $checkPwMsg.text().includes('사용가능') && $checkPwMsg2.text().includes('동일')){
      $('.form-sub').submit();
   }
   
});*/

// 이름 확인




// 약관 확인하기
/*let agreeAll = $('#agree_all');
$agreeAll.on('submit', function(e){
   e.preventDefault(); // 기본 이벤트를 막아주는 명령어이다.
   
   console.log( $('#agree').prop('checked') );
   if( $('#agree').prop('checked') ){
      this.submit(); // submit 이벤트를 발생시키는 메소드(당연히 폼 요소에 사용해야한다.)
   }else{
      alert("약관에 동의해주세요!")
   }
   
});
*/



/*약관 전체동의 */
$(".agree-wrap").on("click", "#agree_all", function () {
  var checked = $(this).is(":checked");

  if(checked){
     $(this).parents(".agree-wrap").find('input').prop("checked", true);
  } else {
     $(this).parents(".agree-wrap").find('input').prop("checked", false);
  }
});


/* 확인버튼 */
$('.join-btn-submit').on('click', function(){
   console.log($('#agree_all:checked'));
   if($checkMsg.text().includes('사용가능') && $checkPwMsg.text().includes('사용가능') && $checkPwMsg2.text().includes('동일')){
      $('.form-sub').submit();
     alert('회원가입이 완료되었습니다!');
   } else {
     alert('회원정보를 다시 확인해주세요');
   }
});


//폰
const phoneInput = document.querySelector('.join_contact');
const errorMsg = document.querySelector('.error-msg');
const submitButton = document.querySelector('.join_submit');

phoneInput.addEventListener('blur', function() {
  const regExp = /^\d{3}-\d{3,4}-\d{4}$/;
  if (!regExp.test(this.value)) {
    errorMsg.style.display = 'block';
    phoneInput.focus();   
  } else {
    errorMsg.style.display = 'none';
  }
});



//주민번호

const userRegistrationNumberInput = document.querySelector('.join_userRegistrationNumber');
const userRegistrationNumberErrorMsg = document.querySelector('#join_userRegistrationNumber_error');

userRegistrationNumberInput.addEventListener('blur', function() {
  const userRegistrationNumber = this.value.replace('-', '');
  const userRegistrationNumberRegExp = /^[0-9]{6}[1234][0-9]{6}$/;
  
  if(!userRegistrationNumberRegExp.test(userRegistrationNumber)) {
    userRegistrationNumberErrorMsg.textContent = '올바른 주민등록번호 형식이 아닙니다.';
    this.focus();
  } else {
    userRegistrationNumberErrorMsg.textContent = '';
  }
});




























