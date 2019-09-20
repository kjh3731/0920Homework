<%@page import="com.java.web.MainBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/resources/css/index.css">
	<script type="text/javascript">
			
	</script>
</head>
<body>
	<div class="container">
		<div class="margin">
			<a href="/login" class="float-l"><img src="/resources/img/account_login.png"></a>
			<a href="/write"><button class="writeBtn">글쓰기</button></a>
		</div>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th class="title">제목</th>
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
					<td><a href="/viewDetail/<%= list.get(i).getNo()%>"><%=list.get(i).getTitle() %></a></td>
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