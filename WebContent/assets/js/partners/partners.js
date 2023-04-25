function fn_partners_submit(){
  console.log($('#agree').prop('checked'));
   
   if($('#agree').prop('checked')){
		
		let name = $("#name").val();
		let contact = $("#contact").val();
		let email = $("#email").val();
		let loc1 = $("#loc1").val();
		let loc2 = $("#loc2").val();
		let content = $("#content").val();
		
		if(name == ""){
			alert("상호명을 입력해주세요.");
			$("#name").focus();
			return false;
		}
		
		if(contact == ""){
			alert("연락처를 입력해주세요.");
			$("#contact").focus();
			return false;
		}
		
		if(email == ""){
			alert("이메일을 입력해주세요.");
			$("#email").focus();
			return false;
		}
		
		if(loc1 == ""){
			alert("점포지역(구)를 입력해주세요.");
			$("#loc1").focus();
			return false;
		}
		
		if(loc2 == ""){
			alert("점포지역을 입력해주세요.");
			$("#loc2").focus();
			return false;
		}
		
		if(content == ""){
			alert("문의내용을 입력해주세요.");
			$("content").focus();
			return false;
		}
		
		$.ajax({
			url : '/partners/inquiryOk.ptn',
			type : 'post',
			data : $("#partnersFrm").serialize(),
			success:function(){
				alert("제출되었습니다.");
				location.href="/";
			},
		});
   }else{
      alert('약관에 동의해주세요!');
	  return false;
   }

}
