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
<div>
		   <table width=500>  
        <tr>
           <td> 번호 </td>
           <td> 작성자 </td>
           <td> 제목 </td>
           <td> 작성일 </td>
        </tr>
        <c:forEach items="${list}" var="dto">
            <tr>
               <td> ${dto.id} </td>
               <td> ${dto.username} </td>
               <td> <a href="content?id=${dto.id}&gid=${gid}"> ${dto.title} </a> </td>
               <td> ${dto.writeday} </td>
            </tr>
        </c:forEach>
        <tr>
          <td colspan=4 align=center> <a href="write?gid=${gid}"> 글쓰기 </a> </td>
        </tr>
     </table>
</div>
</body>
</html>