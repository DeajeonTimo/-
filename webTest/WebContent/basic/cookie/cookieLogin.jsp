<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String valueId = "";
String checked = "";
Cookie[] cookieArr= request.getCookies();
for(Cookie cookie : cookieArr) {
	String name = cookie.getName();
	if("id".equals(name)) {
		valueId = cookie.getValue();
		checked = "checked";
	}
}
%>

<form action="<%=request.getContextPath()%>/cookieLoginServlet.do" method="post">
<label for="id">ID : &nbsp;&nbsp;&nbsp;   </label>
<input type="text" name="id" id="id" value="<%=valueId%>"><br>
<label for="pass">PASS : </label>
<input type="password" name="pass" id="pass"><br>
<input type="checkbox" name="check" value="check" <%=checked%> >id 기억하기<br>
<button type="submit">Login</button>
</form>

</body>
</html>