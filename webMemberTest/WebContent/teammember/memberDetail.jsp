<%@page import="kr.or.ddit.member.vo.TeamMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/webMemberTest/js/jquery-3.7.1.min.js"></script>


<script>

<%
request.setCharacterEncoding("utf-8");

TeamMemberVO vo =  (TeamMemberVO)request.getAttribute("vo");

%>
$(function(){
	
	
	$('#btn1').on('click',function(){
		location.href="<%=request.getContextPath()%>/teammember/updateMember.jsp?id=<%=vo.getMem_id() %>"
		
	})
	
	
	$('#btn2').on('click',function(){
		location.href="<%=request.getContextPath()%>/deleteMember.do?id=<%=vo.getMem_id() %>"
		
	})
	
	$('#btn3').on('click',function(){
		location.href="<%=request.getContextPath()%>/teammember/memberList.jsp"
	})
})
</script>
</head>
<body>


	<table border=1>
		<tr>
			<td colspan="2"><img src="<%=request.getContextPath()%>/imageView.do?id=<%=vo.getMem_id() %>" height="100px"></td>
		</tr>
		<tr>
			<td>회원ID</td>
			<td><%=vo.getMem_id() %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%=vo.getMem_pass() %></td>
		</tr>
		<tr>
			<td>회원이름</td>
			<td><%=vo.getMem_name() %></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%=vo.getMem_tel() %></td>
		</tr>
		<tr>
			<td>회원주소</td>
			<td><%=vo.getMem_addr() %></td>
		</tr>
		<tr>
			<td colspan="2">
			<button type="button" id="btn1">수정</button>
			<button type="button" id="btn2">삭제</button>
			<button type="button" id="btn3">회원목록</button>
			</td>
		</tr>
	</table>

</body>
</html>