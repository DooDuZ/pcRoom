blist();
function blist() {
	$.ajax({
		url: "/jsptest/list",
		success: function(result) {
			let memberlist = JSON.parse(result);
			let table = document.querySelector("#blist");

			let tag = '<tr>' +
				'<td> 번호 </td>' +
				'<td> 제목 </td>' +
				'<td> 내용 </td>' +
				'<td> 작성자 </td>' +
				'<td> 작성일 </td>' +
				'<td> 조회수 </td>' +
				'</tr>';

			for (let i = 0; i < memberlist.length; i++) {
				let m = memberlist[i]
				tag += '<tr>' +
					'<td>' + m.bno + '</td>' +
					'<td >' + m.btitle + '</td>' +
					'<td onclick="viewload(' + m.bno + ')"' + m.btitle + '</td>' +
					'<td>' + m.bcontent + '</td>' +
					'<td>' + m.bwriter + '</td>' +
					'<td>' + m.bdate + '</td>' +
					'<td>' + m.bview + '</td>' +
					'</tr>';
			}
			table.innerHTML = tag;
		}
	})
}
function viewload(bno){
	$.ajax({
		url:"/jsptest/view",
		data:{"bno" : bno , "type" : "load"},
		success : function(re){location.href="View.html"}		
		})
}


