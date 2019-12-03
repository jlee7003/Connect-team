<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript">
var lastID = 0;
function submitFunction() {
	var username= $('#username').val();
	var content= $('#content').val();
	var groups= $('#groups').val();
	$.ajax({
		type:"POST",
		url: "./chatSubmitServlet",
		data: {
			username: encodeURIComponent(username),
			content: encodeURIComponent(content),
			groups: encodeURIComponent(groups)
		},
	success: function(result){
		if(result == 1)
		{
		}	
		else if (result == 0)
		{
				alert('내용을 정확히 입력하세요');
		}
		else
		{
				alert('데이터베이스 오류 발생');
				
		}
	  }
	});
	$('#content').val('');//전송 다음 전송창 비우기
}

function chatListFunction(type)
{	
	var groups= $('#groups').val();
	$.ajax({
		type:"POST",
		url: "./chatListServlet",
		data: {
				listType: type,
				groups: groups
		},
	success: function(data){
  		//console.log(data);
		if(data == "") return; //오류가 발생하면 그냥 바로 return 하여 종료하겠다는 뜻
		var parsed = JSON.parse(data); //제이슨 형태로 데이터를 파싱하는 것
		var result = parsed.result; 
		//여기의 result는 아까 chatListservlet에서 만든 result 함수에 있는 메세지들을 말한다.
		for(var i = 0; i < result.length;i++)
			{
			addChat(result[i][0].value, result[i][1].value, result[i][2].value);
			//0,1,2는 username,content,chattime
			}
			lastID = Number(parsed.last);
		}
	});
	
}

function addChat(username, content, chattime)
{
	
	$('#chatList').append('<div class="row">' +
			'<div class="">' +
			'<div class=media>' +
			'<a class="" href="#">' +
			'<img class="" src="">' +
			'</a>' +
			'<div class="mediabody">' +
			
			username +" "+
			'<div class="alignright">' +
			chattime +
			'</div>' +
		
			'<p>' +
			content + 
			'</p>' +
			'</div>' +
			'</div>' +
			'</div>' +
			'</div>' +
			'<hr>'); 
	$('#chatList').scrollTop($('#chatList')[0].scrollHeight);
}
function getInfiniteChat(){
	setInterval(function(){
		chatListFunction(lastID);
	},1000);
}
</script>
<script>
function changeroom(pp)
{
	document.getElementById("groups").value=pp;
}
</script>
<script type="text/javascript">

$(document).ready(function(){
chatListFunction('ten');
getInfiniteChat();
});


$('.grouplist').click(function(){
	$('#chatList').empty();
	chatListFunction('ten');
	getInfiniteChat();
});
</script>
</head>
<style>
#border {
	height: 500px;
	width: 500px;
	border: 1px solid black;
}

#chatList {
	overflow: auto;
	height:75%;
	border: 1px solid blue;
}

.chatsection {
	border: 1px solid black;
}

.alignright {
	text-align: right;
}
.media
{
height:100px;
}
.chatwritesection{
height:25%;
border:1px solid red;
}

</style>

<body>
	<jsp:include page="../header.jsp" flush="false" />

	<!-- 	<div class=""> -->
	<!-- 		<div class=media> -->
	<!-- 			<a class="" href="#"> <img class="" src=""> -->
<!-- 				</a> -->
	<!-- 			<div class="mediabody"> -->
	<!-- 				<h4 class="mediaheading"> -->
	<!-- 					username -->
	<!-- 			    <div class="alignright"> 2019-04-42 </div> -->
	<!-- 				</h4> -->
	<!-- 				<p>안녕</p> -->
	<!-- 		ddd	</div> -->
	<!-- 		</div> -->
	<!-- 	</div> -->
	<!-- 	<hr> -->
	<!-- f	<div id=border> -->
	<!-- 		<div>채팅창</div> -->
	<!-- 
<input type=text maxlength=8>
이렇게 length 길이를 제한해두면 8글자 밖에 못쓴다
 -->
	<div class="floor_h73 ">
	
	<!-- include 되는 부분 -->
		<jsp:include page="../board/mainboard.jsp" flush="false" />
		<c:forEach items="${glist}" var="dto">
		      <div>출력</div>
		      
		      <div class="grouplist" onclick="changeroom(${dto.groupid})">${dto.groupname}</div>
		      <div>${dto.groupid}</div>
        </c:forEach>
		
<!--  -->
		<div class="chatsection width25">
			<div id=chatList></div>
			<div id=chatwritesection class=chatwritesection>
			
			<div id=grouplist>
				<span>group 선택창</span>


			</div>
			<div>
				<%=session.getAttribute("userid") %>
				${user}
				<input type="hidden" name="username" id=username value="${user}">
				<input type="hidden" name="groups" id=username value="${groups}">
				<input type="text" name="groups" id=groups value="${groups}">
				<textarea name=content id=content></textarea>
				<br>
					<input type=submit value="전송" id=citizenRegistration
						onclick=submitFunction();>
			</div>
			<button onclick="chatListFunction(type)">추가</button>
				
				</div>
		</div>
		
	</div>
<div class="floor_h10">

</div>
	<jsp:include page="../footer.jsp" flush="false" />





<script>
// function alert1()
// {
// alert();	
// }
</script>
</body>
</html>