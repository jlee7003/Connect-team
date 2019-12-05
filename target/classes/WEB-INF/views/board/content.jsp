<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="margin-top:20%;">
<table border=1 align=center>
<tr>
<td>이름</td>
<td>제목</td>
<td>내용</td>
<td>주소</td>
</tr>


<tr>
<td> ${dto.username}</td>
<td> ${dto.title}</td>
<td> ${dto.content}</td>
<td> ${dto.writeday }</td>
</tr>
   <tr>
     <td colspan=3 align=center><a href="list?id=${dto.id}&gid=${gid}">list</a> 
   <a href="update?id=${dto.id}&gid=${gid}">update</a> 
   <a href="delete?id=${dto.id}&gid=${gid}">delete</a></td>
   </tr>
</table>


</div>
</body>
</html>