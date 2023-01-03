/********************************************************************************
* @classDescription 채팅화면
* @author LDU.
* @version 1.0
* -------------------------------------------------------------------------------
* Modification Information
* Date              Developer           Content
* ----------        -------------       -------------------------
* 2022.12.27                  이동욱           			신규생성 
* -------------------------------------------------------------------------------
* Copyright (C) 2022 by LDU. All rights reserved.
*********************************************************************************/

/********************************************************************************
 * Global constiable : 스크립트 영역에서 모두 접근할 수 있는 전역변수를 해당 영역에 모두 정의한다.
 ********************************************************************************/
var globalconstiable = "";

/********************************************************************************
 * Document Ready : jquery에서 제공하는 함수를 이용하여 화면이 로드될 때 처리할 함수를 정의한다.
 ********************************************************************************/
function domReady()
{
	//페이지 초기화 처리
	Chat.initPage();
	//이벤트 정의	
	Chat.defineEvent();
};

/**
 * 클래스 구조의 스크립트 구조체 오브젝트 명을 정의한다.
 * 스크립트를 클래스 기반의 구조체로 정의하기 위해 해당 JavaScript의 클래스명은 파일명으로 정의한다.
 * @classDescription : 
 */
var Chat={
/********************************************************************************
 * InitPage Function : 화면이 초기 로드 시점에 처리할 사항을 정의한다.
 ********************************************************************************/
	initPage: function(){
		//그리드 디자인
		this.defineGrid();
		//레이어 폼 화면 디자인
		this.defineForm();
		//탭화면 디자인
		this.makeTab();
		//트리뷰 디자인
		this.makeTreeView();
		//콤보박스 디자인
		this.makeComboBox();
		//초기데이터설정
		this.initData();
	},

//-------------------------------------------------------------------------------
// GRID: 그리드 구성을 위한 함수 정의 [기본함수명:defineGrid + (구분단어)]
//-------------------------------------------------------------------------------
	defineGrid: function(){
	},	
//-------------------------------------------------------------------------------
// LAYER FORM PAGE: 단위 폼 구성을 위한 함수 정의  [기본함수명:defineForm + (구분단어)]
//-------------------------------------------------------------------------------
	defineForm: function(){
	},
//-------------------------------------------------------------------------------
// TAB: 탭버튼 구성을 위한 함수 정의 [기본함수명:makeTab + (구분단어)]
//-------------------------------------------------------------------------------
	makeTab: function(){
	},	
//-------------------------------------------------------------------------------
// TREE VIEW: 트리뷰 구성을 위한 함수 정의 [기본함수명:makeTreeView + (구분단어)]
//-------------------------------------------------------------------------------
	makeTreeView: function(){
	},
//-------------------------------------------------------------------------------
// COMBO BOX: 콤보박스 구성을 위한 함수 정의 [기본함수명:makeComboBox + (구분단어)]
//-------------------------------------------------------------------------------
	makeComboBox: function(){
	},	
//-------------------------------------------------------------------------------
// LOAD_DATA: 초기데이터 로드를 위한 함수 정의 [기본함수명:initData + (구분단어)]
//-------------------------------------------------------------------------------
	initData: function(){
		Chat.selectRtnChatListByUserId();
	},	
	
/********************************************************************************
 * Event Object : 화면에 디자인 된 버튼 및 오브젝트 이벤트와 호출할 함수를 정의한다.
 ********************************************************************************/
	defineEvent: function(){
	},
/********************************************************************************
 * Main Functions: 화면상에 주요 기능을 처리하는 함수를 정의한다.
 ********************************************************************************/
//-------------------------------------------------------------------------------
// NEW: 신규 데이터 처리에 대한 함수 정의 [기본함수명:newRtn + (구분단어)]
//-------------------------------------------------------------------------------
	newRtn: function(){
	},
//--------------------------------------------------------------------------------
// SELECT: 조회 데이터 처리에 대한 함수 정의 [기본함수명:selectRtn + (구분단어)]
//--------------------------------------------------------------------------------
	selectRtnChatListByUserId: function(){
		const jsonParams = new Object();
		
		//jsonParams.USER_EMAIL = document.getElementById("inputEmail").value;
		jsonParams.USER_EMAIL = 'dldnr3043@naver.com';
		
		ChatApi.axiosPost("/api/chat/chat/selectRtnChatListByUserId", jsonParams, (result) => {
			// success
			if(!result.data.ERROR_FLAG) {
				Chat.initChatList(result.data);
			}
			// fail
			else {
				Chat.initChatList(result.data);
			}
		});
	},
//-------------------------------------------------------------------------------
// PROCESS: 처리 데이터 (데이터 신규, 데이터 수정)에 대한 함수 정의 [기본함수명:processRtn + (구분단어), insertRtn + (구분단어),updateRtn + (구분단어)]
//-------------------------------------------------------------------------------
	processRtn: function() {
	},
		
//-------------------------------------------------------------------------------
// DELETE: 삭제 데이터 처리에 대한 함수 정의 [기본함수명:deleteRtn + (구분단어)]
//-------------------------------------------------------------------------------
	deleteRtn: function(){
	},
//-------------------------------------------------------------------------------
// PRINT: 출력 및 레포트 데이터 처리에 대한 함수 정의 [기본함수명:printRtn + (구분단어)]
//-------------------------------------------------------------------------------
	printRtn: function(){
	},
//-------------------------------------------------------------------------------
// EXCEL: 엑셀 데이터 처리에 대한 함수 정의 [기본함수명:excelRtn + (구분단어)]
//-------------------------------------------------------------------------------
	excelRtn: function(){
	},
	
/********************************************************************************
 * User Functions: 별도 화면 처리를 위해 필요한 함수를 정의한다. 
 ********************************************************************************/
	initChatList : function(jsonData) {
		// 조회된 데이터가 있을 경우
		if(!jsonData.ERROR_FLAG) {
			const ul = document.getElementById('ul');
			
			for(let i=0;i<jsonData.DATA.length;i++) {
				const li   		   = document.createElement('li');
				const frameDiv     = document.createElement('div');
				const imageDiv     = document.createElement('div');
				const infoDiv 	   = document.createElement('div');
				
				frameDiv.setAttribute('class', 'd-flex bd-highlight');
				imageDiv.setAttribute('class', 'img_cont');
				infoDiv.setAttribute('class', 'user_info');
				
				imageDiv.innerHTML += '<img src="https://2.bp.blogspot.com/-8ytYF7cfPkQ/WkPe1-rtrcI/AAAAAAAAGqU/FGfTDVgkcIwmOTtjLka51vineFBExJuSACLcBGAs/s320/31.jpg" class="rounded-circle user_img">';
				imageDiv.innerHTML += '<span class="online_icon"></span>';
				infoDiv.innerHTML += '<span>' + jsonData.DATA[i].chatRoomName + '</span>';
				infoDiv.innerHTML += '<p>Taherah left 7 mins ago</p>';
				
				frameDiv.appendChild(imageDiv);
				frameDiv.appendChild(infoDiv);
				
				li.appendChild(frameDiv);
				
				ul.appendChild(li);
			}
		}
		// 조회된 데이터가 없을 경우
	    else {
		
		}
	},
/********************************************************************************
 * function Sample
 ********************************************************************************/
	/**
	 * Sample(해당 함수는 삭제하지 말고 그대로)
	 */
	sample: function(){
		/*
		switch(strValue){
			case "caseA"	: ; break;
			case "caseB"	: ; break;
		}
		*/
	}
};
