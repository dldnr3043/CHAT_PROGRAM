var MSG = {
	SUCCESS_SEND_PERMISSION_REQUEST : '권한 요청을 성공적으로 보냈습니다.',
	FAIL_SEND_PERMISSION_REQUEST    : '권한 요청을 보내지 못했습니다.',
	FAIL_SELECT_CUST_CHANNEL_LIST   : '고객사리스트 조회하는데 실패했습니다.',
	FAIL_SELECT_SESSION_INFO        : '세션정보를 조회하는데 실패했습니다.'
}

//DOM객체 로드 이후에 호출되는 기본기능 정의
window.addEventListener('DOMContentLoaded', function(){
	initSession();		// 세션정보 init - chat-session.js
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
				alert(MSG.FAIL_SELECT_CUST_CHANNEL_LIST);
				fn(result);
			}
		});
	},
};
