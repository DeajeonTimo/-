<%@page import="kr.or.ddit.sessionlogin.vo.MemberVO"%>
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

MemberVO LoginMember = (MemberVO)session.getAttribute("LoginMember");

if(LoginMember == null){
%>
<form action="<%=request.getContextPath()%>/sessionDBLogin.do">
<table border=1>
	<tr>
		<td>ID  :</td>
		<td><input type="text" placeholder="ID를 입력하세요." name="id"></td>		
	</tr>
	
	<tr>
		<td>PASS : </td>
		<td><input type="password" placeholder="PASSWORD를 입력하세요." name="pass"></td>		
	</tr>
	<tr>
	<td colspan="2"><input type="submit" value="Login"></td>
	</tr>
</table>
</form>
<% 
}else{
%>
<h2> <%=LoginMember.getMem_name() %>님 반갑습니다.</h2>
<a href="<%=request.getContextPath()%>/sessionDBLogout.do">로그아웃</a>
<%
 }
 %>

</body>
</html>