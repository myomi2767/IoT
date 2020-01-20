<%@page import="dept.DeptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>forward를 통한 결과</h1>
	<%
		ArrayList<DeptDTO> deptlist = (ArrayList<DeptDTO>)request.getAttribute("list");
		int size = deptlist.size();
	%>
	<table border="1">
		<tr>
			<th>부서코드</th><th>부서명</th><th>부서위치</th><th>전화번호</th><th>관리자</th><th>삭제</th>
		</tr>
	<% 	for(int i=0;i<size;i++){
			DeptDTO dept = deptlist.get(i);%>
			<tr>
				<td><%= dept.getDeptNo() %></td>
				<td><a href="/serverweb/dept/read.do?deptNo=<%= dept.getDeptNo() %>&info=한글데이터"><%= dept.getDeptName() %></a></td>
				<td><%= dept.getLoc() %></td>
				<td><%= dept.getTel() %></td>
				<td><%= dept.getMgr() %></td>
				<td><a href="/serverweb/dept/delete.do?deptno=<%= dept.getDeptNo() %>">삭제</a></td>
			</tr>
	<%	}
	%>
	</table>
</body>
</html>