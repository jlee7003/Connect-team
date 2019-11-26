<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


 <%
 if(session.getAttribute("userid")==null)//세션변수가 없다면
 {
 %>
<a href="Joinus">LOGIN</a><p>
<a href="findid">idforget</a>
<a href="findpwd">pwdforget</a>
<%}
 else
 {
 %>
 <%=session.getAttribute("username")%>
	<div><a href="logout">logout</a></div>
 <%
 }
 %>
		
</body>
</html>