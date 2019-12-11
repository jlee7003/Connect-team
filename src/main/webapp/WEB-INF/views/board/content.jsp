<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="/Connect-team/resources/main.css?ver=header41">
<title>Insert title here</title>
<style>
html, body {
	margin: 10px;
	height: 97%;
}
</style>
</head>
<body class="flex">
<div style="background: white; height: 100%; border-radius: 5px; width: 80%;">
<table cellspacing=0 width=100% height=100% align="center" style="padding:10px; width:100%; height:100%;" >
<tr  height=62 style="background:black; color:white;">
<td width="15%" style="height:10%; text-align:center; border-radius:5px 0px 0px 0px;" >이름</td>
<td style="text-align:left; border-radius:0px 5px 0px 0px;"> ${dto.username}</td>
</tr>
<tr style="text-align:center;">
<td height=10%>제목</td>
<td style="text-align:left;"> ${dto.title}</td>
</tr>
<tr style="text-align:center;">
<td style="height:60%; background:#e9ecef">내용</td>
<td style=" text-align:left; background:#f1f3f5;"> 
<div style="height:100%; overflow:auto;">${dto.content}</div>
</td>
</tr>
<tr style="text-align:center;">
<td height=10% >작성일</td>
<td style="text-align:left;"> ${dto.writeday }</td>
</tr>


   <tr height=62>
     <td colspan=2 align=center style="overflow: auto; background:black; border-radius:0px 0px 5px 5px;">
<!--      <a style="width:100%; height:100%; background:black; border-radius:0px 0px 5px 5px; color:white;"> -->
     <a style="color:white;" href="list?id=${dto.id}&gid=${gid}&boardid=${bid}&page=${page}">list</a> 

	<c:if test="${writer == user}">
   <a style="color:white; margin-left:20px; margin-right:20px;" href="update?id=${dto.id}&gid=${gid}&boardid=${bid}&page=${page}">update</a> 
   <a style="color:white;" href="delete?id=${dto.id}&gid=${gid}&boardid=${bid}">delete</a>
		</c:if>
   
   </td>
   </tr>
</table>


</div>
<div style="">

	<form method="post" action="list" class="flex center" style="height:90%;">
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
	<div style="height:10%; margin-left:20px;">${grouphost}</div>
	</div>
</body>
</html>