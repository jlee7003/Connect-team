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
<div style="background:white; height:620px; border-radius:5px;"> 
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
          <td colspan=4 align=center> <a href="write?gid=${gid}&boardid=${bid}"> 글쓰기 </a> </td>
        </tr>
     </table>
               <a href="list?page=1&gid=${gid}&gname=${gname}&boardid=${bid}">처음으로</a>
          
       <c:forEach var="i" begin="${pstart}" end="${pend}">
			 <c:if test="${page != i}">
               <a href="list?page=${i}&gid=${gid}&gname=${gname}&boardid=${bid}">${i}</a>
           </c:if>
           
            <c:if test="${page eq i}">
               <a style="color:red" href="list?page=${i}&gid=${gid}&gname=${gname}&boardid=${bid}">${i}</a>
           </c:if>
        </c:forEach>
        
        
              <c:if test="${page != pagenumber}">
               <a href="list?page=${page+1}&gid=${gid}&gname=${gname}&boardid=${bid}">다음페이지</a>
           </c:if>
           
             <c:if test="${page <= pagenumber - 10}">
               <a href="list?page=${page+10}&gid=${gid}&gname=${gname}&boardid=${bid}">+10</a>
           </c:if>
        
        
        <a href="list?page=${pagenumber}&gid=${gid}&gname=${gname}&boardid=${bid}">맨끝으로</a>
</div>
</body>
</html>