<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
img{
	width : 200px;
	height : 200px;
}
</style>
</head>
<body>
<img src="../images/카푸치노.jpg"><br><br>
<img src="<%=request.getContextPath()%>/basic/images/카푸치노.jpg"><br><br>
<img src="<%=request.getContextPath()%>/images/imageView.do?fileno=3"><br><br>
</body>
</html>