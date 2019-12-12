function retrivalcheck() {
			
	// post방식 디펄트가 list
	document.form1.action.value="list";
	document.form1.submit();
}

function addcheck() {
			
	// post방식
	document.form1.action.value="add";
	document.form1.submit();
}

function editcheck(id) {
		
	// post방식
	document.form1.action.value="edit";
	document.form1.id.value=id;
	document.form1.submit();
}

