view();
function view(){
		alert('ss');
		$.ajax({
		url:"http://localhost:8080/jsptest/view",
		data:{"type":"get"},
		success:function(re){
		
			let list = JSON.parse(re)
			let col=document.querySelectorAll(".col")
			col[0].innerHTML = list.bno;
			col[1].innerHTML = list.btitle;
			col[2].innerHTML = list.bcontent;
			col[3].innerHTML = list.bwrite;
			col[4].innerHTML = list.bdate;
			col[5].innerHTML = list.bview;
		}
	})
}