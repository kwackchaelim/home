/**
 * 	@fn			window.onload = function()
 *	@brief		페이지 로딩 후 실행 시 해당되지 않는 버튼 숨김
 *	@details
 *
 *	@author		한예나
 *	@date		2019-12-05
 *
 *	@param		
 *  
 *	@remark		
 */
// window.load는 페이지 로딩 후 실행
window.onload = function() {
	var action = document.form1.action.value;

	if(action=="edit") {
		document.getElementById("insert").style.display="none";
	} else if(action=="add") {
		// document.getElementById("insert").disabled=false;
		document.getElementById("update").style.display="none";
		document.getElementById("delete").style.display="none";
	}
} 

/**
 * 	@fn			function insertcheck()
 *	@brief		입력 버튼 클릭 시 값이 없을 경우 처리
 *	@details
 *
 *	@author		한예나
 *	@date		2019-12-05
 *
 *	@param		
 *  
 *	@remark		
 */
function insertcheck() {
	// post방식
	document.form1.action.value="insert";
	
	if(document.form1.title.value==""){
		alert("제목을 입력하세요");
	} else if(document.form1.name.value==""){
		alert("작성자를 입력하세요");
	} else if(document.form1.memo.value==""){
		alert("내용을 입력하세요");
	} else {
		document.form1.submit();
	}
}

function updatecheck() {
	// post방식
	document.form1.action.value="update";
	document.form1.submit();
}

function deletecheck() {
	result = confirm("정말로 삭제하시겠습니까 ?");

	if(result == true){
		
		// post방식
		document.form1.action.value="delete";
		document.form1.submit();
	}
	else
		return;
}

/**
 * 	@fn			function backcheck()
 *	@brief		뒤로가기 버튼 시 경고
 *	@details
 *
 *	@author		한예나
 *	@date		2019-12-05
 *
 *	@param		
 *  
 *	@remark		
 */
function backcheck() {
	// post방식
	alert("저장하지 않고 나가시겠습니까");
	document.form1.action.value="list";
	document.form1.submit();
	// history.go(-1);
	
}
