//DOM객체 로드 이후에 호출되는 기본기능 정의
window.addEventListener('DOMContentLoaded', function(){
	try{domReady();}catch(E){ console.log("domReady error=", E); }
});

var ChatCommon = {
	moveTo : function(url) {
		window.location.href = url;
	},
}