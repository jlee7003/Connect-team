<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="update_ok"> 
<input type="hidden" name="boardid" value="${bid}">
<input type="hidden" name="gid" value="${gid}">
<input type=hidden name="id" value="${dto.id}">
이름<input type="text" name="name" value="${dto.username}" disabled ><p>
제목<input type="text" name="title" value="${dto.title}"><p>
내용<input type="text" name="content" value=" ${dto.content}"><p>
<input type="submit" value="저장하기">
</form>
</body>
</html>