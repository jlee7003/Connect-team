<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="upload" name="frm" method="post" enctype="multipart/form-data">
<table border="1" style="text-align: center">
<tr><td>현재프로필이미지</td>
<td>변경이미지</td>
</tr>
<tr>
<td><img alt="logo" class="" width="100" onclick="changeprofile()" style="" src="resources/profile/${imgname}"></td>
<td><input type="file" name="file"></td>
</tr>
<tr><td>프로필메세지</td><td><textarea name="profilemsg">${profilemsg}</textarea></td></tr>
<tr><td colspan="3"><input type="submit" value="변경"></td></tr>
</table>
</form>
</body>
</html>