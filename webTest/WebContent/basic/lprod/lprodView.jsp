<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% 
//컨트롤러에서 보낸 데이터를 받는다.
List<LprodVO> list =  (List<LprodVO>)request.getAttribute("list");


%>
</head>
<body>
<h3>동기 방식의 LPROD 목록 출력</h3>
<table border='1'>
	<tr>
		<th>LPROD_ID</th>
		<th>LPROD_GU</th>
		<th>LPROD_NM</th>
	</tr>
	<%
	for(LprodVO vo : list){
	%>	
	<tr>
		<td><%=vo.getLprod_id() %></td>
		<td><%=vo.getLprod_gu() %></td>
		<td><%=vo.getLprod_nm() %></td>
	</tr>	
	<%	
	}
	%>
</table>
</body>
</html>

