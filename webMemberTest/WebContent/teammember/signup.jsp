<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/webMemberTest/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	
	$('#b1').on('click',function(){
		id= $('#memid').val();
		$.ajax({
			url : "<%=request.getContextPath()%>/checkMemberId.do?id="+id,
			type : 'get',
			success : function(res){
				alert("이 아이디는 "+res.flag+"입니다");
			},
			error : function(xhr){
				alert("실패");
			},
			dataType : 'json'
		})
	})
	
	
	
	$('#b3').on('click',function(){
		location.href="<%=request.getContextPath()%>/teammember/memberList.jsp"
	})
	
	
})
</script>
</head>
<body>
<form action="<%=request.getContextPath()%>/insertMember.do" method="post" enctype="multipart/form-data">
<table border ="1">
	<tr>
		<td>회원 ID</td>
		<td><input type="text" name="memid" id="memid"> <button type="button" id="b1">중복확인</button> </td>
	</tr>
	
	<tr>
		<td>비밀번호</td>
		<td><input type="text" name="mempass"></td>
	</tr>
	
	<tr>
		<td>비밀번호 확인</td>
		<td><input type="text" name="mempass2"></td>
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
		<td colspan="2"><input type="submit" value="저장"> <input type="reset" value="취소"> <button type="button" id="b3">회원 목록</button> </td>
	</tr>
</table>
</form>
</body>
</html>