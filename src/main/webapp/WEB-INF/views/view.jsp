<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<title>Insert title here</title>
</head>

<body>
<body>
<!-- <form action="upload" method="post"	enctype="multipart/form-data">
		file<input type="file" name="file" /><br/>
		<input type="submit" value="send"/>
	</form> -->
	
	
<form action ="upload" name="frm" method="post" enctype="multipart/form-data">
<table border="1" style="text-align: center">

<tr><td>이미지</td><td><input type="file" name="file"></td></tr>

<tr><td colspan="3"><input type="submit" value="업로드"></td></tr>
</table>
</form>

</body>
</html>