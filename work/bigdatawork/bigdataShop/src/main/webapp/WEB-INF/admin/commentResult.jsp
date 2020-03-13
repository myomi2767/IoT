<%@page import="java.util.ArrayList"%>
<%@page import="kr.multi.bigdataShop.product.comment.ProductCommentResultDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="kr.multi.bigdataShop.product.*"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link type="text/css" href="/bigdataShop/common/css/master.css"
		rel="stylesheet" media="screen,print" />
	<link type="text/css" href="/bigdataShop/common/css/print.css"
		rel="stylesheet" media="print" />
	<link type="text/css" href="/bigdataShop/common/css/mall.css"
		rel="stylesheet" media="screen,print" />
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/bigdataShop/common/css/jqcloud.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/bigdataShop/common/js/jqcloud-1.0.4.js"></script>

</head>
<body>
	<h1>상품댓글분석</h1>
	<div class="col-7" style="float: left; margin-right: 50px">
		<table class="table table-bordered" style="border: solid 1px;">
			<tr>
				<th>키워드</th>
				<th>반복횟수</th>
			</tr>
			<c:forEach var="comment" items="${commentlist}" varStatus="status" end="9">
	 			<tr>
	 				<td>${comment.pro_comment}</td>
	 				<td>${comment.count }</td>
	 			</tr>	
			</c:forEach>
		</table>
	</div>
	<div id="jCloud" class="col-5" style="width: 450px; height: 350px; border: 1px solid #ccc;float: left;">
	</div>
	<script type="text/javascript">
		
		var word_list =[
			<c:forEach var="comment" items="${commentlist}">
				{text: "${comment.pro_comment}", weight: '${comment.count}' },
			</c:forEach>
		]
		
		$(function() {
        	$("#jCloud").jQCloud(word_list);
      	});
	</script>
</body>
</html>