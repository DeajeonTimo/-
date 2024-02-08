<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//controller에서 저장한 테이터 꺼내기
int res = (Integer)request.getAttribute("res");
if(res>0){
%>
	{
		"flag" : "사용불가능 id"
	}
	
<%}else{%>

	{
		"flag" : "사용가능 id"
	}


<%	
}
%>