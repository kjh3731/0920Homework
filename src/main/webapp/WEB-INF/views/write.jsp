<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글쓰기</title>
	<link rel="stylesheet" href="/resources/css/index.css">
</head>
<body>
	<div class="container">
		<h1>글쓰기</h1>
		<form action="/write/insert" method="post">
			<div>
				<input type="text" name="title" placeholder="제목"  class="titleBox">
				<textarea name="contents" placeholder="내용"  class="contentsBox"></textarea>
			</div>
			<div>
				<a href="/"><button >목록</button></a>
				<button type="submit">확인</button>
			</div>
		</form>
	</div>
</body>
</html>