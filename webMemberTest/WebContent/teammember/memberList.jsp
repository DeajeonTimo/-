<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#p1{
	color: blue;
}
</style>
<script src="../js/jquery-3.7.1.min.js"></script>
<script>
$(function(){
	
	$('#p1').on('click',function(){
		
		$.ajax({
			url : "<%=request.getContextPath()%>/memberList.do",
			type : 'get',
			success : function(res){
				code = '<table border=1><tr><td colspan="5"><button type="button" id="add">회원추가</button></td></tr><tr style="text-align:center"><td>ID</td><td>비밀번호</td><td>이 름</td><td>전 화</td><td>주 소</td></tr>'
			
				$.each(res,function(i,v){
					code += "<tr><td><a href='<%=request.getContextPath()%>/memberDetail.do?id="+v.mem_id+"'>" + v.mem_id + "</a></td>";
					code += "<td>"+ v.mem_pass +"</td>"
					code += "<td>"+v.mem_name +"</td>"
					code += "<td>"+v.mem_tel  +"</td>"
					code += "<td>"+v.mem_addr +"</td></tr>"
				})
				code += "</table>"
				$('#f1').empty();
				$('#f1').append($(code));
			},
			error : function(xhr){
				alert("실패");
			},
			dataType : 'json'
		})
	})
	
	$(document).on('click','#add',function(){
		
		location.href="<%=request.getContextPath()%>/teammember/signup.jsp"
	})
	
})
</script>
</head>
<body>
<p id ="p1"><u>회원목록보기</u></p>
<h3>회원 목록 보기</h3>
<form action="" method="get" id="f1">
	
	
</form>
</body>
</html>