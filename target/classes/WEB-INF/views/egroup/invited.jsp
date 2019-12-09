<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

</script>
</head>
<body>
	<jsp:include page="../header.jsp" flush="false" />

	<div class="floor_h100 center">
		<div class="shadow padding_50 width25 login_minw login_minh">
		
		
			<div class="login container" align=center>
				<div>
					<div class="font_design2 container_w5">
						<img alt="logo" class="margin_left_10 padding margin_bottom_50" width=74 height=55
							src="resources/img/logo2.PNG">
					</div>
				</div>
			</div>
			<c:if test="${invitelist.size() == 0 }">
			<div class="flex center">
			초대 받은 그룹이 없습니다.
			</div>
			</c:if>
			<c:forEach items="${invitelist}" var="dto">
	        
			
	<c:if test="${dto.groupname != '' || dto.groupname ne null}">
		      <div class="grouplist groupbox padding_10" >
		        <div>
		        ${dto.username}님이 ${dto.groupname} 그룹으로 초대하셨습니다. 
		        </div>
		        <div class="width100 flex center margin_top_20">
		        <form method="post" action="oksign">
		        <input type="hidden" name="groupname" id="groupname" value="${dto.groupname}">
		        <input type="hidden" name="username" id="username" value="${dto.username}">
		        <input type="hidden" name="groupid" id="groupid" value="${dto.groupid}">
		        <input type="submit" value="수락" class="button_submit">
		        </form>
		        &nbsp;
		        <form method="post" action="sorry">
		        <input type="hidden" name="groupname" id="groupname" value="${dto.groupname}">
		        <input type="hidden" name="username" id="username" value="${dto.username}">
		        <input type="hidden" name="groupid" id="groupid" value="${dto.groupid}">
		        <input type="submit" value="거절" class="button_submit">
		        </form>
		        </div>
		        
		      </div>
		      </c:if>
        </c:forEach>
			
		 
			
			
			
			
		</div>
	</div>
	<jsp:include page="../footer.jsp" flush="false" />
</body>
</html>