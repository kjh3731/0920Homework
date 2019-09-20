<%@page import="com.java.web.MainBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		html, body {margin: 0; padding: 0;}
		.container {width: 90%; margin: 0 auto;}
		
		table, tr, th, td {border: 1px solid #CCCCCC;}
		table {width: 100%;border-collapse: collapse;}
		
		.margin {margin: 20px 0;}
	</style>
</head>
<body>
	<div class="container">
		<div class="margin">
			<a href="/login"><img src="/resources/img/account_login.png"></a>
		</div>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성날짜</th>
				</tr>
			</thead>
			<tbody>
			<%
				List<MainBean> list = (List<MainBean>) request.getAttribute("list");
				if(list == null) {
					System.out.println("내용이 없습니다");
				} else {
					for(int i = 0; i < list.size(); i++) {
			%>
				<tr>
					<td><%=list.get(i).getNo() %></td>	
					<td><%=list.get(i).getTitle() %></td>
					<td><%=list.get(i).getWriter() %></td>
					<td><%=list.get(i).getDate() %></td>
				</tr>
			<%
					}
				}
			%>	
			</tbody>
		</table>
	</div>
</body>
</html>