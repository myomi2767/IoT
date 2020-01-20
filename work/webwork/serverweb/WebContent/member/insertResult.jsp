<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>forward를 이용한 응답화면분리</h1>
	<hr/><hr/><hr/><hr/><hr/>
	<%	
		//서블릿이 공유한 데이터 꺼내기
		int result = (int)request.getAttribute("membData");
	%>
	<h2><%= result %>개행 삽입성공!!</h2>
</body>
</html>