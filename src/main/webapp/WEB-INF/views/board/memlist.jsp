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