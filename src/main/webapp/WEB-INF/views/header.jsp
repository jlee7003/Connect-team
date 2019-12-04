<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Connect-team/resources/main.css?ver=header28">
<script src="/Connect-team/resources/main.js?ver=main"></script>
</head>
<body>
<div class="floor_h7 shadow container_w100 ">
<!--  -->
<div class="font_design2 container_w5">
<a href="/Connect-team"><img alt="logo" class="margin_left_10 padding" width=74 height=55 src="resources/img/logo2.PNG">
</a>
</div>
<div class="container_w30 flex center">
<div class="input_search flex center height_20 input_width_210">
<div>
<input type="text" class="border_none input_width" placeholder="go to connect or search!">
</div>
<img alt="" height=20 src="resources/img/search.PNG">
</div>
</div>
<div class="container_w25 flex center">
</div>
<div class="container_w30 flex center font_design3">
<div class="margin_left_20 width33"><a href="joingroup">GROUPS</a></div>
 <div class="margin_left_20 width33"><a href="Joinus">JOINUS</a></div> 
 <div class="margin_left_20 width33">



			<%
				if (session.getAttribute("userid") == null)//세션변수가 없다면
				{
			%>
			<a href="login">LOGIN</a>
			<%
				} else
				{
			%>
			<a href="logout">LOGOUT</a>
			<%
			} 
			%>
			<!--  -->




</div>
<!--  -->
</div>
<div class="container_w10 flex center ">
	
	<a href="invited" class="flex center">${messege}<span class="messege flex center fontweight900" onclick=""> ${invitenum}</span></a>
	
	
</div>
</div>

<div class="floor_h10">

</div>
</body>
</html>