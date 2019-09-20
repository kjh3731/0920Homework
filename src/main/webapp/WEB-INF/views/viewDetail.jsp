<%@page import="com.java.web.MainBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상세보기</title>
</head>
<body>
	<div>
		<%
		List<MainBean> list = (List<MainBean>) request.getAttribute("list");
		if(list == null) {
			System.out.println("list에 내용이 없습니다");
		} else {
			for(int i = 0; i < list.size(); i++) {
		%>
		<h1><%=list.get(i).getTitle() %></h1>
		
		<div>
			<p><%=list.get(i).getContents() %></p>
		</div>
		
		<%
			}
		}
		%>
	</div>
</body>
</html>