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
		
		<table cellspacing=0 width=100% height=100% align=center style="text-align:center; padding:10px;">
			<tr  style="height:10%; max-height:120px; border:1px solid black; background:black; color:white; text-align:center;">
				<td style="border-radius:5px 0px 0px 0px; ">번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
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
				<tr  class="btn-3" style="background:white; border-bottom:5px solid black;">
					<td style="border-bottom:1px solid #1187CF;">${dto.id}</td>
					<td style="border-bottom:1px solid #1187CF;">${dto.username}</td>
					<td style="border-bottom:1px solid #1187CF;"><a href="content?id=${dto.id}&gid=${gid}&boardid=${bid}&page=${page}">
							${dto.title} </a></td>
					<td style="border-bottom:1px solid #1187CF;">${dto.writeday}</td>
					<td style="border-bottom:1px solid #1187CF;">
					<div class="hiddel" style="display:none; background:red; border:1px solid black;" >
					<a href="delete?id=${dto.id}&gid=${gid}&boardid=${bid}">
					삭제
					</a>
					</div></td>
				</tr>
			</c:forEach>



			<tr height=10%; style="max-height:120px; border-radius:0px 0px 5px 5px; color:white;">
				<td colspan=5 align=right style=" background:black; border-radius:0px 0px 5px 5px;"><a style="width:100%; height:100%; background:black; border-radius:0px 0px 5px 5px; color:white; margin-right:50px;"
					href="write?gid=${gid}&boardid=${bid}&page=${page}"> 글쓰기 </a></td>
			</tr>
		</table>
<%-- 		${cntnumber}cntnumber ${pend}pend ${pstart}pstart --%>
<%-- 		${pagenumber}pagenumber  --%>
<div align=center>

		<a href="list?page=1&gid=${gid}&gname=${gname}&boardid=${bid}&selvalue=${selvalue}&searchtext=${searchtext}">처음으로</a>

	<c:if test="${page > 10}">
			<a
				href="list?page=${page-10}&gid=${gid}&gname=${gname}&boardid=${bid}&selvalue=${selvalue}&searchtext=${searchtext}">-10</a>
		</c:if>


	<c:if test="${page != 1}">
			<a
				href="list?page=${page-1}&gid=${gid}&gname=${gname}&boardid=${bid}&selvalue=${selvalue}&searchtext=${searchtext}">이전페이지</a>
		</c:if>


		<c:forEach var="i" begin="${pstart}" end="${pend}">
			<c:if test="${page != i}">
				<a href="list?page=${i}&gid=${gid}&gname=${gname}&boardid=${bid}&selvalue=${selvalue}&searchtext=${searchtext}">${i}</a>
			</c:if>

			<c:if test="${page eq i}">
				<a style="color: red"
					href="list?page=${i}&gid=${gid}&gname=${gname}&boardid=${bid}&selvalue=${selvalue}&searchtext=${searchtext}">${i}</a>
			</c:if>
		</c:forEach>


		<c:if test="${page != pagenumber}">
			<a
				href="list?page=${page+1}&gid=${gid}&gname=${gname}&boardid=${bid}&selvalue=${selvalue}&searchtext=${searchtext}">다음페이지</a>
		</c:if>

		<c:if test="${page <= pagenumber - 10}">
			<a
				href="list?page=${page+10}&gid=${gid}&gname=${gname}&boardid=${bid}&selvalue=${selvalue}&searchtext=${searchtext}">+10</a>
		</c:if>


		<a href="list?page=${pagenumber}&gid=${gid}&gname=${gname}&boardid=${bid}&selvalue=${selvalue}&searchtext=${searchtext}">맨끝으로</a>
	</div>
	</div>
	<!-- --------------------------------------------------------------------- -->
	
	
	
<div style="width:20%; height:100%;">
<div>
<div>
<input type="button" value="계시글 삭제하기" onclick="showhiddel()">
</div>
<div>
<input type="button" value="회원 목록" onclick="delmember()">
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

					<select style="border-radius: 3px;" name="selvalue">
						<option value="0">제목</option>
						<option value="1">작성자</option>
					</select>
				</div>

				<div align="right" style="width: 50%; border-radius: 3px;" class=" ">

					<select style="border-radius: 3px;" onchange="listsee(this.value)">
						<option value="10">선택하기</option>
						<option value="10">10줄 보기</option>
						<option value="15">15줄 보기</option>
						<option value="20">20줄 보기</option>
					</select>
				</div>
			</div>
			<div class="input_search flex center height_20" style="width: 180px;">
				<div>
					<input type="text" name="searchtext" class="border_none"
						style="width: 150px;" placeholder="go to connect or search!">
				</div>
				

				<button style="border:none; background:none;">
					<img alt="" height=20 src="resources/img/search.PNG">
				</button>
				
				
				
			</div>
			<div style="">	<div> </div></div>
		</div>

	</div>
	
	</form>
	<div style="height:10%; margin-left:20px; color:red; font-size:30px;">${grouphost}</div>
	</div>
</body>
</html>