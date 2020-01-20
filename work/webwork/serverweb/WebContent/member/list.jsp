<%@page import="member.MemberDTO"%>
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
		ArrayList<MemberDTO> memblist = (ArrayList<MemberDTO>)request.getAttribute("memblist");
		int size = memblist.size();
	%>
	<table border="1">
		<tr>
			<th>부서코드</th><th>성명</th><th>사번</th><th>패스워드</th><th>주소</th><th>포인트</th><th>등급</th><th>삭제</th>
		</tr>
	<% 	for(int i=0;i<size;i++){
			MemberDTO memb = memblist.get(i);%>
			<tr>
				<td><%= memb.getDeptNo() %></td>
				<td><a href="/serverweb/member/read.do?id=<%= memb.getId() %>"><%= memb.getName() %></a></td>
				<td><%= memb.getId() %></td>
				<td><%= memb.getPass() %></td>
				<td><%= memb.getAddr() %></td>
				<td><%= memb.getPoint() %></td>
				<td><%= memb.getGrade() %></td>
				<td><a href="/serverweb/member/delete.do?id=<%= memb.getId() %>">삭제</a></td>
			</tr>
	<%	}
	%>
	</table>
</body>
</html>