<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<title>Insert title here</title>
</head>
<script>
$(document).ready(function(){
	  $("p").hide();
	  // $("ul > li:first-child a").next().show();
	  $("ul li a").click(function(){
	    $(this).next().slideToggle(300);
	    // $(this).next().slideDown(300);
	    $("ul li a").not(this).next().slideUp(300);
	    return false;
	  });
	  $("ul li a").eq(0).trigger("click");
	});
</script>
<style>
.500{

}
</style>
<body>
<!-- test1 -->
		<c:set var="name" value="홍길동" />
					<c:if test="${name eq '홍길동'}">
    				<c:out value="${str}" />
					</c:if>

</body>
</html>