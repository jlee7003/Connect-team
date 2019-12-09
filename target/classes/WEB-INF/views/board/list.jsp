<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="/Connect-team/resources/main.css?ver=header38">
<style>
html, body {
	margin: 10px;
	height: 97%
}
</style>
<script>
	function listsee(pp) {
		location.href = "listseeok?listsee=" + pp + "&gid=" + $
		{
			gid
		}
		+"&boardid=" + $
		{
			bid
		}
		;
		// 	location.href="list?page="+1+"&gid="+${gid}+"&gname="+${gname}+"&boardid="+${bid}+"&listsee="+pp;
	}
</script>
<title>Insert title here</title>
</head>
<body class="flex">
	<div
		style="background: white; height: 100%; border-radius: 5px; width: 80%;">
		<table width=100%>
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.id}</td>
					<td>${dto.username}</td>
					<td><a href="content?id=${dto.id}&gid=${gid}&boardid=${bid}">
							${dto.title} </a></td>
					<td>${dto.writeday}</td>
				</tr>
			</c:forEach>



			<tr>
				<td colspan=4 align=center><a
					href="write?gid=${gid}&boardid=${bid}"> 글쓰기 </a></td>
			</tr>
		</table>
		${cntnumber}cntnumber ${pend}pend ${pstart}pstart
		${pagenumber}pagenumber 
		<a href="list?page=1&gid=${gid}&gname=${gname}&boardid=${bid}">처음으로</a>

		<c:forEach var="i" begin="${pstart}" end="${pend}">
			<c:if test="${page != i}">
				<a href="list?page=${i}&gid=${gid}&gname=${gname}&boardid=${bid}">${i}</a>
			</c:if>

			<c:if test="${page eq i}">
				<a style="color: red"
					href="list?page=${i}&gid=${gid}&gname=${gname}&boardid=${bid}">${i}</a>
			</c:if>
		</c:forEach>


		<c:if test="${page != pagenumber}">
			<a
				href="list?page=${page+1}&gid=${gid}&gname=${gname}&boardid=${bid}">다음페이지</a>
		</c:if>

		<c:if test="${page <= pagenumber - 10}">
			<a
				href="list?page=${page+10}&gid=${gid}&gname=${gname}&boardid=${bid}">+10</a>
		</c:if>


		<a
			href="list?page=${pagenumber}&gid=${gid}&gname=${gname}&boardid=${bid}">맨끝으로</a>
	</div>
	<form method="post" action="search" class="flex center">
	<input type="hidden" name="groupid" value="${gid}">
	<input type="hidden" name="start" value="${start}">
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
			
		</div>

	</div>
	</form>
</body>
</html>