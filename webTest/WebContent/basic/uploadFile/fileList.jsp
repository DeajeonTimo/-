<%@page import="kr.or.ddit.basic.upload.vo.FileInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	//서블릿(컨트롤러)에서 보낸 자료 받기
	List<FileInfoVO> fileList = (List<FileInfoVO>)request.getAttribute("list");
%>
</head>
<body>
<h2> 전체 파일 목록</h2><br><hr><br>
<a href="<%=request.getContextPath()%>/fileUpload.do">파일 업로드</a>
<table border="1">
<thead>
	<tr>
		<th>번호</th>
		<th>작성자</th>
		<th>저장파일명</th>
		<th>원래의 파일명</th>
		<th>파일 크기</th>
		<th>날짜</th>
		<th>비고</th>
	</tr>
<tbody>
<%
if(fileList==null || fileList.size()==0){
%>
	<tr>
		<td colspan="7" style="text-align:center">Upload한 파일 목록이 하나도 없습니다.</td>
	</tr>
<%}else{
	for(FileInfoVO vo : fileList){
%>
	<tr>
		<td><%=vo.getFile_no() %></td>
		<td><%=vo.getFile_writer() %></td>
		<td><%=vo.getSave_file_name() %></td>
		<td><%=vo.getOrigin_file_name() %></td>
		<td><%=vo.getFile_size() %></td>
		<td><%=vo.getFile_date() %></td>
		<td><a href="<%=request.getContextPath()%>/fileDownload.do?fileno=<%=vo.getFile_no()%>">DownLoad</a></td>
		

	</tr>
<%	
	}
}
%>
</tbody>
</table>

</body>
</html>