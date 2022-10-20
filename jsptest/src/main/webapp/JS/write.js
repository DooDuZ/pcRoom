function board(){
	let input = document.querySelectorAll('input')
	let info ={
		btitle : input[0].value,
		bcontent : input[1].value,
		bwrite : input[2].value,
		bpassword : input[3].value
	}
	$.ajax({
		url: "http://localhost:8080/jsptest/board",
		data: info,
		type: "POST",
		success:function(re){
			alert(re)
		if(re=='true'){location.href="list.html"}
		else{alert('글쓰기실패 ')}
		}
	})
}