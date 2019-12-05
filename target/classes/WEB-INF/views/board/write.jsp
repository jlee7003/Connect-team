<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="write_ok">
<input type="hidden" name="groupid" value="${gid}">
<table width="500">
<tr>
<td>이름</td>
<td><input type="text" name="name" size="10" value="${username}" disabled></td>
</tr>
<tr>
<td>제목</td>
<td><input type="text" name="title" size="50"></td>
</tr>
<tr>
<td>내용</td>
<td><textarea cols="50" rows="5" name="content"></textarea></td>
</tr>
<tr>
<td></td>
</tr>
<tr>
<td></td>
<td colspan=2><input type="submit" value="입력"></td>
</tr>
</table>
</form>
</body>
</html>