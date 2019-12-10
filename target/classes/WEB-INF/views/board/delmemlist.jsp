<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="/Connect-team/resources/main.css?ver=header41">
<style>
html, body {
	margin: 10px;
	height: 97%
}
</style>
<script>
	function listsee(pp) {
		location.href = "listseeok?listsee=" + pp + "&gid=" + ${gid}+"&boardid=" + ${bid};
		// 	location.href="list?page="+1+"&gid="+${gid}+"&gname="+${gname}+"&boardid="+${bid}+"&listsee="+pp;
	}
	function showhiddel()
	{
		
		var pp=document.getElementsByClassName("hiddel").length;
		 for(i=0;i<pp;i++)
			 {
		document.getElementsByClassName("hiddel")[i].style.display="block";
			 }
	}
	function delgroup()
	{
		 msg = "정말  해당 계시판을 삭제하시겠습니까?";
		    if (confirm(msg)!=0) {
		location.href="delgroup?groupid="+${gid};
		    } else 
		    {
		    	   alert("취소하셨습니다");
		    }
	}
	function delmember()
	{
		location.href="delmemlist?groupid="+${gid};
	}
</script>
<title>Insert title here</title>
</head>
<body class="flex">
	<div
		style="background: white; height: 100%; border-radius: 5px; width: 80%;">
		
	<!-- --------------------------------------------------------------------- -->
<%-- 			${list} --%>
		<table cellspacing=0 width=100% height=100% align=center style="text-align:center; padding:10px;">
			<tr  style="height:10%; max-height:120px; border:1px solid black; background:black; color:white; text-align:center;">
				<td style="border-radius:5px 0px 0px 0px; ">회원</td>
				<td style="border-radius:0px 5px 0px 0px; ">삭제</td>
			</tr>
	
			<c:if test="${list.size() == 0 }">
			<tr>
			<td>
			<div class="flex center">
			작성된 계시글이 없습니다.
			</div>
			</td>
			</tr>
			</c:if>
			<c:forEach items="${list}" var="dto">
				<tr class="btn-3" style="background:white; border-bottom:5px solid black;">
					<td style="border-bottom:1px solid #1187CF;">${dto.email}</td>
					
					<c:if test="${dto.email != user}">
					<td style="border-bottom:1px solid #1187CF;"><a href="delmember?id=${dto.id}">삭제하기</a></td>
					</c:if>
					
					<c:if test="${dto.email == user}">
					<td style="border-bottom:1px solid #1187CF; color:purple; font-weight:900;">그룹장</td>
					</c:if>
				</tr>
			</c:forEach>



			<tr height=10%; style=" border-radius:0px 0px 5px 5px; color:white;">
				<td colspan=4 align=right style=" background:black; border-radius:0px 0px 5px 5px;"><a style="width:100%; height:100%; background:black; border-radius:0px 0px 5px 5px; color:white; margin-right:50px;"
					href="write?gid=${gid}&boardid=${bid}&page=${page}"> 글쓰기 </a></td>
			</tr>
		</table>
	
	
	
	
		<!-- --------------------------------------------------------------------- -->
	
	</div>
	
<div style="width:20%; height:100%;">
<div>
<div>
<input type="button" value="회원 삭제하기" onclick="delmember()">
</div>
<div>
<input type="button" value="그룹 삭제하기" onclick="delgroup()">
</div>
</div>
	<form method="post" action="memlist" class="flex center" style=" height:80%;">
	<input type="hidden" name="gid" value="${gid}">
	<input type="hidden" name="start" value="${start}">
	<input type="hidden" name="manager" value="${manager}">
	<input type="hidden" name="page" value="${page}">
	<input type="hidden" name="email" value="${email}">
<input type="hidden" name="boardid" value="${bid}">
	<div style="width: 20%;" class="flex center">
		<div style="margin-left: 20px;">
			<img alt="" style="margin-left: 20px;" width=150px
				src="resources/img/chatroom.PNG">
			<div style="margin-bottom: 15px;" class="flex center">
			
				<div style="width: 50%; border-radius: 3px;" class=" ">

				</div>

				<div align="right" style="width: 50%; border-radius: 3px;" class=" ">

				</div>
			</div>
			<div style="">	<div> </div></div>
		</div>

	</div>
	
	</form>
	<div style="height:10%; margin-left:20px; color:red; font-size:30px;">${grouphost}</div>
	</div>
</body>
</html>