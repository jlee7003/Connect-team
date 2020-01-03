<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
function deletereserve(pp)
{
	location.href="delreserve?id="+pp;
}

</script>
<body>
<body class="font_git">
	<jsp:include page="../header.jsp" flush="false" />
	
	
	
	<div class="floor_h60 center" >
	<div>
		<div class="flex center fontsize_ font_git">reservation</div>
	<div class="flex center">
	<div class="flex center" style="border: 1px solid black; width: 800px; height: 500px;">

<div class="flex center">
				<c:forEach items="${reserlist}" var="dto">
				
				<div style="width:100%; border:1px solid black; border-radius:10px; padding:10px;">
				<div>${dto.reserver}님  </div>
				<div>${dto.roomname} 스터디룸 </div>
				<div>${dto.stime}시</div>
				<div>${dto.endtime}시 까지 예약하셨습니다.</div>
				&nbsp;<input type="button" onclick="deletereserve(${dto.id})" value="예약취소">
				</div>
							</c:forEach>
</div>
							
	</div>
	</div>
	
	
	</div>
	</div>
  
  
	<div class="floor_h10"></div>

<jsp:include page="../footer.jsp" flush="false" />
</body>
</body>
</html>