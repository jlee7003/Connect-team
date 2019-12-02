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
<div class="width75 center border_black">
		
		mainboard.page
		아이디 로그인 -> 자신이 속해 있는 그룹 표시 -> 해당 그룹의 계시판으로 이동

  <c:forEach items="${list}" var="dto">
  <div> </div>
  </c:forEach>
		
		</div>
</body>
</html>