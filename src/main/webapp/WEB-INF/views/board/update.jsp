<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
</head>
<body class="flex">
<div style="background: white; height: 100%; border-radius: 5px; width: 80%;">
<!-- <div style="height:100px; width:100%;"> -->

<form method="post" action="update_ok" style="height:100%; width:100%;">
<input type="hidden" name="gid" value="${gid}">
<input type="hidden" name="page" value="${page}">
<input type="hidden" name="boardid" value="${bid}">
<input type=hidden name="id" value="${dto.id}">
<table cellspacing=0 align="center" style="padding:10px; width:100%; height:100%;">
<tr height="10%" style="background:black; color:white;">
<td width="15%" style="text-align:center; border-radius:5px 0px 0px 0px;">이름</td>
<td style="text-align:left; border-radius:0px 5px 0px 0px;">
<input type="text" name="name" size="10" value="${username}" style="border:none; color:white; background:none; margin-left:50px;" disabled></td>
</tr>
<tr style="text-align:center;">
<td height=10%>제목</td>
<td  style="text-align:left;"><input type="text" name="title" size="50" value="${dto.title}" style="margin-left:50px;"></td>
</tr>
<tr  style="text-align:center;">
<td style="background:#e9ecef">내용</td>
<td style="text-align:center; background:#f1f3f5;">
<textarea cols="90" rows="20" name="content" >
${dto.content}
</textarea></td>
<tr  style="text-align:center;">
<td  style=" background:black; border-radius:0px 0px 5px 5px;" height=10% colspan=2>
<input type="submit" style="border:none; background:none; color:white;" value="저장">
  <a style="margin-left:50px; color:white;" href="list?id=${dto.id}&gid=${gid}&boardid=${bid}&page=${page}">목록</a> 
</td>
</tr>
</table>
</form>
</div>






<!-- </div> -->
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