<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/webMemberTest/js/jquery-3.7.1.min.js"></script>
<script>
$(function(){
	$('#btn').on('click',function(){
		location.href="<%=request.getContextPath()%>/teammember/memberList.jsp"
	})
})
</script>

</head>
<body>
<form action="<%=request.getContextPath()%>/updateMember.do" method="post" enctype="multipart/form-data">
	<table border=1>
		<tr>
			<td colspan="2"><img src="<%=request.getContextPath()%>/imageView.do?id=<%=request.getParameter("id") %>" height="100px"><br><br></td>
		</tr>
		<tr>
			<td>회원ID</td>
			<td><%=request.getParameter("id") %> <input type="hidden" name="memid" value="<%=request.getParameter("id") %>"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="mempass"></td>
		</tr>
		<tr>
			<td>회원이름</td>
			<td><input type="text" name="memname"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="memtel"></td>
		</tr>
		<tr>
			<td>회원주소</td>
			<td><input type="text" name="memaddr"></td>
		</tr>
		<tr>
		<td>프로필사진</td>
		<td><input type="file" name="memfile"></td>
	</tr>
	
	<tr style="text-align:center">
		<td colspan="2"><input type="submit" value="저장"> <input type="reset" value="취소"> <button type="button" id="btn">회원 목록</button> </td>
	</tr>
	</table>
</form>
</body>
</html>