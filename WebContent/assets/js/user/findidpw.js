let $findIdBtn = $(".find-id-btn");
$findIdBtn.click(() => {
  $(".find-id").show();
  $(".find-pw").hide();
  $(".find-id-btn").css("background-color", "lightcyan");
  $(".find-pw-btn").css("background-color", "white");
});

let $findPwBtn = $(".find-pw-btn");
$findPwBtn.click(() => {
  $(".find-id").hide();
  $(".find-pw").show();
  $(".find-id-btn").css("background-color", "white");
  $(".find-pw-btn").css("background-color", "lightcyan");
});



