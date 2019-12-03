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
	<jsp:include page="../header.jsp" flush="false" />
	<div class="floor_h100" >
	<div>
	그룹 초대하기
	</div>
	
	<div>
	그룹 들어가기
	</div>
	
		<c:forEach items="${glist}" var="dto">
		      <div class="grouplist" ><a href="chatroom">${dto.groupname}</a></div>
		      <div>${dto.groupid}</div>
        </c:forEach>
	
	

    <form action="joingroup_ok" method="post">
    	<input type="hidden" name="email" value=<%=session.getAttribute("userid") %>>
		<input type="text" name="groupname" placeholder="그룹의 이름" />
		<input type="text" name="manager" placeholder="그룹 관리자" />
		<input type="button" value="초대하기">
		<input type="submit" value="그룹 만들기"/>
	</form>
	</div>

<jsp:include page="../footer.jsp" flush="false" />
</body>
</html>