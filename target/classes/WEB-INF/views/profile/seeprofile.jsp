<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
function changeprofile()
{
var url="changeprofile";
open(url,"emailwindow", "statusbar=no, scrollbar=no, menubar=no, width=600, height=600" );
}
</script>
<body>
<div align=center>
<table border="1" width=600 style="text-align: center">
<tr><td>프로필이미지</td></tr>
<tr><td><img alt="logo" class="" style="" src="resources/profile/${imgname}"></td>
</tr>
<tr><td>프로필메세지</td></tr>
<tr><td height=500>${profilemsg}</td></tr>
<tr><td colspan=""><input type="button" onclick="changeprofile()" value="변경하기"></td></tr>
</table>
</div>
</body>
</html>