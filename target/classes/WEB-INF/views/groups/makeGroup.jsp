<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/connect/group/makeGroupOk" method="post">
<<<<<<< Updated upstream
		<input type="hidden" name="email" value="${email}" />
		<input type="text" name="groupname" placeholder="그룹의 이름" />
		<input type="text" name="manager" value="${email}" />
=======
		<input type="text" name="groupname" placeholder="그룹의 이름" />
		<input type="text" name="manager" placeholder="그룹 관리자" />
>>>>>>> Stashed changes
		<input type="submit" value="그룹 만들기" />
	</form>
</body>
</html>