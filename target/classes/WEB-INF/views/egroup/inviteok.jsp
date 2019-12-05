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
			
			
			그룹에 가입되셨습니다.
			${overlap}
			
			
		</div>
	<jsp:include page="../footer.jsp" flush="false" />
</body>
</html>