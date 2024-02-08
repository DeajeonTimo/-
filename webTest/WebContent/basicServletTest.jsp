<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
window.onload = function(){
	document.getElementById("getBtn").addEventListener("click",function(){
		location.href = "http://localhost/webTest/servletTest03.do";
	})
}
</script>
</head>
<body>
	<h2>Servlet 요청 연습</h2><br><hr><br>
	
	<h3>GET방식 요청하기 1==> 링크 방식</h3>
	<a href="http://localhost/webTest/servletTest03.do">Get방식 요청</a>
	<hr>
	
	<h3>GET방식 요청하기2 ==> FORM태그의 METHOD속성 이용</h3>
	<!--  <form>태그의 method속성이 생략되거나 method='get'으로 설정하면 get방식으로 요청된다.   -->
	<form action="http://localhost/webTest/servletTest03.do">
		<input type="submit" value="get방식 요청2">
	</form>
	<hr>
	<h3>GET방식 요청하기3 ==> JavaScript의 location.href속성 이용하기</h3>
	<form>
		<input type="button" value="Get방식 요청3" id="getBtn"> 
	</form>
	
	<hr>
	<h3>POST방식 요청하기 ==> from태그의 method속성에 속성값을 post로 설정</h3>
	<form action="http://localhost/webTest/servletTest03.do" method="POST">
		<input type="submit" value="POST 방식 요청">
	</form>

</body>
</html>