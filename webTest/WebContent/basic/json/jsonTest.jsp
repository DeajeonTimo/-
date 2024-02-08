<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<script>

//문서를 읽기 ==> 문서를 파싱(분석) ==> DOM객체 생성 ==> $(function) 이벤트 발생 ==> DOM 객체를 차례로 읽어서 렌더링
// ==> 화면 출력 ==> load이벤트 발생
$(function(){
	//문자열 처리
	$('#strBtn').on("click",function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonTest.do",
			type : "post",
			data : "choice=string",
			success : function(resData){
				let htmlCode = "<h3>문자열 응답 결과</h3>";
				htmlCode += resData;
				
				$('#result').html(htmlCode);
			},
			error : function(xhr){
				alert("상태코드 : "+xhr.status)
			},
			dataType : "json"
		});
	});//-------------------------------------
		//배열처리
		$('#arrBtn').on("click",function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonTest.do",
			type : "post",
			data : "choice=array",
			success : function(resData){
				//resData = [10,20,30,40,50]
				let htmlCode = "<h3>배열 응답 결과</h3>";
				$.each(resData,function(i,v){
					htmlCode += i + "번째 자료" + v + "<br>"
				});

				$('#result').html(htmlCode);
			},
			error : function(xhr){
				alert("상태코드 : "+xhr.status)
			},
			dataType : "json"
		});
	});
	//-------------------
		//객체 처리
		$('#objBtn').on("click",function(){
			$.ajax({
				url : "<%=request.getContextPath()%>/jsonTest.do",
				type : "post",
				data : "choice=object",
				success : function(resData){
					//resData = {"mem_id":"z001","mem_pass":"1111","mem_name":"홍길동","mem_tel":"010-1111-1111","mem_addr":"대전"}
					let htmlCode = "<h3>객체 응답 결과</h3>";
					htmlCode += "ID : " + resData.mem_id + "<br>";
					htmlCode += "PASS : " + resData.mem_pass+ "<br>";
					htmlCode += "NAME : " + resData.mem_name+ "<br>";
					htmlCode += "TEL : " + resData.mem_tel+ "<br>";
					htmlCode += "ADDR : " + resData.mem_addr+ "<br>";

					$('#result').html(htmlCode);
				},
				error : function(xhr){
					alert("상태코드 : "+xhr.status)
				},
				dataType : "json"
			});
		});
		//리스트 처리
		$('#listBtn').on("click",function(){
			$.ajax({
				url : "<%=request.getContextPath()%>/jsonTest.do",
				type : "post",
				data : "choice=list",
				success : function(resData){
					//resData = [{"mem_id":"A","mem_pass":"10","mem_name":"홍","mem_tel":"02","mem_addr":"서울"},
					//			 {"mem_id":"B","mem_pass":"20","mem_name":"김","mem_tel":"042","mem_addr":"대전"},
					//			 {"mem_id":"C","mem_pass":"30","mem_name":"이","mem_tel":"041","mem_addr":"충남"},
					//			 {"mem_id":"D","mem_pass":"40","mem_name":"박","mem_tel":"043","mem_addr":"충북"}]
					let htmlCode = "<h3>객체 응답 결과</h3>";
					$.each(resData,function(i,v){
						htmlCode += i+ "번째 자료<br>";
						htmlCode += "ID : " + v.mem_id + "<br>";
						htmlCode += "PASS : " + v.mem_pass+ "<br>";
						htmlCode += "NAME : " + v.mem_name+ "<br>";
						htmlCode += "TEL : " + v.mem_tel+ "<br>";
						htmlCode += "ADDR : " + v.mem_addr+ "<br>";
						htmlCode += "<hr>";
					})
					$('#result').html(htmlCode);
				},
				error : function(xhr){
					alert("상태코드 : "+xhr.status)
				},
				dataType : "json"
			});
		});
		//------------------------------------
		//리스트 처리
		$('#mapBtn').on("click",function(){
			$.ajax({
				url : "<%=request.getContextPath()%>/jsonTest.do",
				type : "post",
				data : "choice=map",
				success : function(resData){
					//resData = {"name":"이순신","tel":"010-1234-5678","addr":"대전 중구"}
					let htmlCode = "<h3>Map 응답 결과</h3>";
					htmlCode += "이름 :" +  resData.name + "<br>"
					htmlCode += "전화번호 :" +  resData.tel + "<br>"
					htmlCode += "주소 :" +  resData.addr + "<br>"
			
					$('#result').html(htmlCode);
				},
				error : function(xhr){
					alert("상태코드 : "+xhr.status)
				},
				dataType : "json"
			});
		});
})
	

</script>
</head>
<body>
<form>
	<input type="button" id="strBtn" value="문자열">
	<input type="button" id="arrBtn" value="배 열">
	<input type="button" id="objBtn" value="객 체">
	<input type="button" id="listBtn" value="리스트">
	<input type="button" id="mapBtn" value="map객체">
</form>
<hr>
<div id="result"></div>
</body>
</html>