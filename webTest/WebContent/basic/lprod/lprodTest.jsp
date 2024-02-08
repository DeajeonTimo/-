<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/js/jquery-3.7.1.min.js"></script>
<script>
$(function(){
	$('#btn').on("click",function(){
		$.ajax({
			
			url : "<%=request.getContextPath()%>/lprod.do",
			type : "post",
			success : function(res){
				let code = "<table border=1>";
				code += "<tr><td>LPROD_ID</td><td>LPROD_GU</td><td>LPROD_NM</td></tr>"
				$.each(res,function(i,v){
					code += "<tr><td>"+v.lprod_id+"</td><td>"+v.lprod_gu+"</td><td>"+v.lprod_nm+"</td></tr>";
				})
				code += "</table>"
				console.log(code);
				$('#result').html(code);
			},
			error : function(xhr){
				alert(xhr.status)
			},
			dataType : "json"
		})
	})
	
	$('#btn2').on('click',function(){
		location.href = "<%=request.getContextPath()%>/lprod2.do";
	})
})
</script>
</head>
<body>

<button id="btn">Lprod자료 가져오기(비동기방식)</button>
<button id="btn2">Lprod자료 가져오기 (동기방식)</button>

<h2>Lprod 자료 목록</h2>

<div id ="result"></div>
</body>
</html>