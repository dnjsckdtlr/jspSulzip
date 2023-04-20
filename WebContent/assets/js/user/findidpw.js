let $findIdBtn = $(".find-id-btn");
$findIdBtn.click(() => {
  $(".find-id").show();
  $(".find-pw").hide();
  $(".find-id-btn").css("background-color", "#D61C6A");
  $(".find-id-btn").css("color", "white");
  $(".find-pw-btn").css("background-color", "white");
  $(".find-pw-btn").css("color", "black");
});

let $findPwBtn = $(".find-pw-btn");
$findPwBtn.click(() => {
  $(".find-id").hide();
  $(".find-pw").show();
  $(".find-id-btn").css("background-color", "white");
  $(".find-id-btn").css("color", "black");
  $(".find-pw-btn").css("background-color", "#D61C6A");
  $(".find-pw-btn").css("color", "white");
});

/* 아이디 비밀번호 찾기 확인버튼 구현 */
let $idBtn = $('.idBtn');
let $pwBtn = $('.pwBtn');

$idBtn.on('click', function(){
   findId();
})

$pwBtn.on('click', function(){
   findPw();
})

function findId(){
   let userName = $idBtn.closest('.find-id').find('.nameId').val();
   let userPhone = $idBtn.closest('.find-id').find('.phoneId').val();
   
   $.ajax({
      type: 'get',
      url: '/user/findidOk.usr',
      data: { 
      userName : userName,
      userPhone : userPhone
     },
     dataType: 'json',
      success: function(result) {
   if(result == null){
         alert('아이디를 찾을 수 없습니다. 회원정보를 다시 입력해주세요.');
      }else{
         $('.resultId').text("찾으시는 아이디는 : " + result + "입니다.");
      }
      },
      error: function(a, b, c) {
        console.error(c);
      }
    });
}

function findPw(){
   let userId = $pwBtn.closest('.find-pw').find('.idPw').val();
   let userName = $pwBtn.closest('.find-pw').find('.namePw').val();
   let userPhone = $pwBtn.closest('.find-pw').find('.phonePw').val();
   
   $.ajax({
      type: 'get',
      url: '/user/findpwOk.usr',
      data: { 
      userId : userId,
      userName : userName,
      userPhone : userPhone
     },
     dataType: 'json',
      success: function(result) {
      if(result == null){
         alert('비밀번호를 찾을 수 없습니다. 회원정보를 다시 입력해주세요.');
      }else{
         $('.resultPw').text("찾으시는 비밀번호는 : " + result + "입니다.");
      }
      },
      error: function(a, b, c) {
        console.error(c);
      }
    });
}













