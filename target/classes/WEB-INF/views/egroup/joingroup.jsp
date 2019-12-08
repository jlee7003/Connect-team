<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="font_git">
	<jsp:include page="../header.jsp" flush="false" />
	<div class="floor_h40 center" >
	<div>
	<div class="flex center fontsize_ font_git">Groups</div>
	<div><img alt="logo" class="" src="resources/img/group.PNG">
	</div>
	</div>
	</div>
	<div class="floor_h20 center" >
	<div class="width100 height80 flex center">
	<div style="width:400px;">
	<div><h4>현재 내가 속해 있는 그룹들</h4></div>
		<c:forEach items="${glist}" var="dto">
		      <div class="grouplist groupbox" ><a href="chatroom?gid=${dto.groupid}&gname=${dto.groupname}">${dto.groupname}</a></div>
        </c:forEach>
  </div>
  <div>
			<div>
			<div><h4>그룹 만들기</h4></div>
		    <form action="joingroup_ok" method="post">
		    	<input type="hidden" name="email" value=<%=session.getAttribute("userid") %>>
				<input type="text" name="groupname" placeholder="그룹의 이름" />
				<input type="text" name="manager" placeholder="그룹 관리자" />
				<input type="submit" value="그룹 만들기"/>
			</form>
			</div>
  </div>
	</div>
	
	

<!--     <form action="joingroup_ok" method="post"> -->
<%--     	<input type="hidden" name="email" value=<%=session.getAttribute("userid") %>> --%>
<!-- 		<input type="text" name="groupname" placeholder="그룹의 이름" /> -->
<!-- 		<input type="text" name="manager" placeholder="그룹 관리자" /> -->
<!-- 		<input type="submit" value="그룹 만들기"/> -->
<!-- 	</form> -->
	

			
	</div>

<jsp:include page="../footer.jsp" flush="false" />
</body>
</html>