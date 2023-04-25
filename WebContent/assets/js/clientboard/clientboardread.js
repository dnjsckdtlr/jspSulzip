/**
 * 
 */

/*<!-- 	private int replyNumber;
	private String replyContent;
	private String replyDate;
	private int boardNumber;
	private int userNumber; -->*/


let href = window.location.href;
let url = new URL(href);

console.log(url)
let search = url.searchParams;
let boardNumber = search.get('boardNumber');

replyAjax();

function replyAjax(){
   $.ajax({
      url : '/reply/replyListOk.rep',
      type : 'get',
      data : {boardNumber : boardNumber},
      dataType : 'json',
      success : showReply,
      error : function(a,b,c){
         console.log(c);
      }
   });
}


function showReply(replies){
   let text = "";
   
   replies.forEach(reply => {
      text += `
         <ul id="comment-list">
                  <li>
                     <div class="comment-info">
                        <span class="writer">${reply.userId}</span> <span class="date">${reply.replyDate}</span>
                     </div>
                     <div class="comment-content-wrap">
                        <div class="comment-content">
                           <p>${reply.replyContent}</p>
                        </div>`
                        
      if(userNumber == reply.userNumber){                  
      text +=         `<div class="comment-btn-group">
                           <button type=button class="comment-modify-ready">수정</button>
                           <button type=button class="comment-delete" data-number="${reply.replyNumber}">삭제</button>
                        </div>
                        <div class="comment-btn-group none">
                           <button type=button class="comment-modify" data-number="${reply.replyNumber}">수정 완료</button>
                        </div>`
      }
      
      text +=         `</div>
                  </li>
            </ul>
      `;
      
   });
   
   $('.comment-list').html(text);
}


// 댓글 작성
$('.submit-btn').on('click', function () {
   $.ajax({
      url : "/reply/replyWriteOk.rep",
      type : "post",
      data : {
         boardNumber : boardNumber,
         userNumber : userNumber,
         replyContent : $('#content').val()
      },   
      success : function(){
         replyAjax();
         $('#content').val('');
      }
   });
});


$('.comment-list').on('click', '.comment-delete', function(){
   let replyNumber  = $(this).data('number');
   console.log(replyNumber);
   
   $.ajax({
      url : "/reply/replyDeleteOk.rep",
      type : "get",
      data : {replyNumber : replyNumber},
      success : function() {
		 alert("삭제하시겠습니까?");
         replyAjax();
      },
      error : function(a,b,c){
         console.log(c);
      }
   });
});

//수정 버튼
$('.comment-list').on('click', '.comment-modify-ready', function() {
   // closest()는 조상 요소 중에서 찾는다.
   // find()는 자손 요소 중에서 찾는다.
   let $parent = $(this).closest('#comment-list');
   //console.log($parent);
   
   let $children = $parent.find('.comment-btn-group');
   //console.log($children);
   
   $children.eq(0).hide();
   $children.eq(1).show();
   
   let $content = $(this).parent().prev().children();
   console.log($content);
   
   //기존 요소를 교체
   $content.replaceWith(`<textarea class='modify-content' >${$content.text()}</textarea>`);
});

// 수정 완료 버튼
$('.comment-list').on('click', '.comment-modify', function(){
      console.log('modify~~~~');
      console.log( $('.modify-content').val());
      let replyNumber = $(this).data('number');
      console.log(replyNumber);
      
      $.ajax({
         url : '/reply/replyUpdateOk.rep',
         type : 'get',
         data : {
            replyNumber : replyNumber,
            replyContent : $('.modify-content').val()
         },
         success : function(){
            replyAjax();
         }
      });
});



















