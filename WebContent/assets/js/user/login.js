/**
 * 
 */
// js로 req객체에 직접 접근하는 것은 불가능하다.
// 그러나 브라우저 주소창에 있는 쿼리스트링을 가져와 쓸 수 있다.
// window -> 브라우저
// location -> 주소창
console.log(window.location.search);
console.log(location.search);
let queryString = location.search;


//URLSearchParams 객체는 쿼리스트링을 해석해준다.
let urlParams = new URLSearchParams(queryString);

let result = urlParams.get('result');

if(result == 'false'){
   alert('회원정보가 없거나 일치하지 않습니다.')
}