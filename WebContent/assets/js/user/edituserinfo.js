$(function(){
	  /*영어, 숫자, 특수문자로 이루어진 비밀번호 8글자 이상
	    영어 대소문자를 구분하지 않음*/
	const regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[a-zA-Z\d!@#$%^&*()_+]{8,}$/;
	
	
	// 비밀번호 조건체크
	$('#userChangePw').on('blur', function(){
	   if(regex.test( $(this).val() )){
	      $('#check-pw-msg').text("사용가능한 비밀번호 입니다.");
	      console.log("ㅎㅇ");
	   }else{
	      $('#check-pw-msg').html("사용 불가능한 비밀번호입니다.<br>영어, 숫자, 특수문자를 포함한 8글자 이상으로 작성해주세요.")
	   }
	      
	});
	
	// 비밀번호 동일확인    
	$('#userChangePwConfirm').on('blur', function(){
	   console.log($('#userChangePw').val());
	   if( $('#userChangePw').val() != $('#userChangePwConfirm').val()){
	      $('#check-pw-msg2').text("비밀번호가 일치하지 않습니다.");
	   }else{
	      $('#check-pw-msg2').html("동일한 비밀번호 입니다.")
	   }
	      
	});
});

function fn_edituser(userId){
	let userChangePw = $("#userChangePw").val();
	let userChangePwConfirm = $("#userChangePwConfirm").val();
	
	if(userChangePw != ""){
		if(userChangePwConfirm == "" 
			|| (userChangePw != userChangePwConfirm) ){
			alert("변경할 비밀번호 확인을 입력해주세요.");
			$("#userChangePwConfirm").focus();
			return false;
		}
		$("#userPw").val(userChangePw);
	}
	
	$.ajax({
		type : 'post',
		data : $("#edituserFrm").serialize(),
		url : '/user/edituserinfoOk.usr',
		success : function(){
			alert("회원정보가 수정되었습니다. 메인페이지로 이동합니다.");
			location.href="/";
		}
	});	
}



