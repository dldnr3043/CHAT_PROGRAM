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
	
	// 전체 고객사 리스트 조회
	selectAllUsedCustChannel : function(fn) {
		const jsonParams = new Object();
		
		ChatApi.axiosPost("/api/chat/common/selectAllUsedCustChannel", jsonParams, (result) => {
			// success
			if(!result.data.ERROR_FLAG) {
				fn(result);
			}
			// fail
			else {
				alert("고객사리스트 조회하는데 실패했습니다.");
				fn(result);
			}
		});
	},
}