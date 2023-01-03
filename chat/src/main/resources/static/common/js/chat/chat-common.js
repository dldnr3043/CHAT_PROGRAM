//DOM객체 로드 이후에 호출되는 기본기능 정의
window.addEventListener('DOMContentLoaded', function(){
	try{domReady();}catch(E){ console.log("domReady error=", E); }
});

var ChatCommon = {
	// 해당 url로 이동
	moveTo : function(url) {
		window.location.href = url;
	},
	
	// 해당 url iframe 생성
	moveToIframe : function(url) {
		const iframeElement = document.getElementById('iframe');
		iframeElement.setAttribute('src', url);
	},
	
	// ul, li 생성
	createList : function() {
		
	},
}