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
			
			'<div class="flex">' +
			'<span style="font-weight:900; width:50%;">' +
			username +" "+
			'</span>' +
			
			
			'<div class="alignright" style="width:50%;">' +
			chattime +
			'</div>' +
			'</div>' +
			
		
			'<p>' +
			content + 
			'</p>' +
			'</div>' +
			'</div>' +
			'</div>' +
			'</div>'); 
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

function checkall()
{
	var one=document.getElementById("email1").value;
	var two=document.getElementById("email2").value;
	document.plusemail.username.value=document.getElementById("username").value;
	document.plusemail.phone.value=document.getElementById("phone").value;
	document.plusemail.email.value=one+"@"+two;
	if(document.getElementById("username").value == "")
	{
	alert("이름을 입력 해주세요");
	return false;
	}
	else if(document.getElementById("hv").value != 1)
		{
		document.getElementById("aaa").innerHTML="<b style='color:red'>이메일 인증코드를 입력하세요</b>";
	    alert(document.getElementById("hv").value);
	    alert("wrongvalue");
		return false;
		}
	else
		alert();
		return true;
}
function emailcheck(email1, email2 ,groups,groupname)
{
	if(!insertform.email1.value || !insertform.email2.value){ 
		alert("emailerror");
		insertform.email1.focus();
		return;
	}else{
		if(insertform.email1.value){
			if(insertform.email2.value==0){
				// 직접입력
				if(insertform.email1.value.indexOf("@")==-1){
					alert("emailerror");
					insertform.email1.focus();
					return false;
				}
			}else{
				// 선택입력
				if(insertform.email1.value.indexOf("@")!=-1){
					alert("emailerror");
					insertform.email1.focus();
					return false;
				}
			}
		}
	}
// 	alert("회원님을 초대하였습니다.");
    // 인증을 위해 새창으로 이동
	var url="invitecheck?email1="+email1+"&email2="+email2+"&groups="+groups+"&groupname="+groupname;
	open(url,"emailwindow", "statusbar=no, scrollbar=no, menubar=no, width=400, height=200" );
}



</script>
</head>
<style>
#border {
	height: 500px;
	width: 500px;
	border: 1px solid black;
}
#content{
			width: 70%;
			height: 70px;
			padding: 10px;
			box-sizing: border-box;
			border: solid 2px initial;
			border-radius: 5px;
			font-size: 16px;
			resize: none;
}


#chatList {
	background:#E0EEFA;
	overflow: auto;
	height:72%;
}

.chatsection {
/* 	border: 2px solid black; */
	border-radius:5px;
}

.alignright {
	text-align: right;
}
.media
{
height:auto;
}
.mediabody
{
background:white;
border:10px solid #E0EEFA;
padding:10px;
}
.chatwritesection{
height:20%;
/* border:1px solid red; */
}
</style>

 <script>  
 $(function()/* 드래그 가능하게 해주는 jquery 플러그인 */
 {
	 $(".invitelayer").draggable(
			 {

			 });
 });

</script>
  
 



<body>
	<jsp:include page="../header.jsp" flush="false" />

  
  
	<div class="invitelayer ">
		<form name="insertform" action="checkemail" style="width:100%; height:100%;" >
		<div class="toplayer flex">
		<div  class="flex center" style="background:black; width:90%;">그룹원 초대</div>
		<div align=right style="width:10%; padding:5px;" onclick="closeinvitelayer()">X</div>	
		</div>
<!-- 		<div> -->
<!-- 			<div  class="flex center_j">초대하기<div align=right onclick="closeinvitelayer()">X</div>	</div> -->
<!-- 		</div> -->
		<div class="flex center" style="height:100%;">
			<input type="text" name="email1" maxlength="15"
				class="input_width45 bd_radius height_20 inputtag" size=10 id=email1>
			@ <select name="email2" id="email2"
				class="input_width40 bd_radius height_35 inputtag">
				<option value="0">직접입력</option>
				<option value="naver.com">naver.com</option>
				<option value="daum.net">daum.net</option>
				<option value="nate.com">nate.com</option>
				<option value="gmail.com">gmail.com</option>
			</select> <input type="button" name="emailconfirm_btn" style="margin-left:20px;" value="초대하기"
				class="button_submit"
				onclick="emailcheck(insertform.email1.value, insertform.email2.value,document.getElementById('groups').value,document.getElementById('groupname').value)">
			<p>
				<span id=aaa></span>
				</div>
		</form>
	</div>
    <div style="font-size:40px; width:15.5%; background:#1388CF; color:white;">${gname}</div>
	<div class="floor_h73 bd_radius">
	
	<!-- include 되는 부분 -->
	<div class="width15 navi shadow2" style="background:white; border-radius:5px;">
	<!--------------- -디렉토리부분- -------------------->
	 <iframe src="http://localhost:8080/Connect-team/makedir?gid=${gid}&gname=${gname}" name="dir" width="1340" height="746" class="border_none" scrolling="no"></iframe>

	

	<!--------------- -디렉토리부분- -------------------->
	</div>
	
	 <iframe src="http://localhost:8080/Connect-team/list?gid=${gid}&gname=${gname}&boardid=0&page=1" style=" margin-left:10px; margin-right:10px; background:#1187CF;" name="iframe" width="1340" height="100%" class="border_none" scrolling="no"></iframe>
		<div class="chatsection width25">
			<div class="flex center_a" style="border-radius: 5px 5px 0px 0px; height:8%; border:0px solid black; color:white; font-size:25px; background:#1388CF;"> 
			
			<span style="margin-left:20px; ">${gname}의 채팅창</span>
			</div>
			<div id=chatList></div>
			<div id="chatwritesection" class="chatwritesection" style="background:#E0EEFA; border-radius:0px 0px 5px 5px;">
			
			<div id=grouplist>


			</div>
			<div>
				<br>
				<input type="hidden" name="groupname" id=groupname value="${gname}">
				<input type="hidden" name="username" id=username value="${user}">
				<input type="hidden" name="groups" id=groups value="${groups}">
				<div>
				
				</div>
				<div class="flex">
				<textarea class="margin_left_30" name=content id=content></textarea>
				<div align="right" style="width:30%;">
						<input type=submit value="전송하기" class="margin_right_30 button_transfer flex center" style="width:60px; height:40px;" id=""
						onclick=submitFunction();>
				</div>
				</div>
			
			</div>
				
			
			
			<input type="button" onclick="showinvitelayer()" class="margin_top_10 button_transfer margin_left_30 flex center" style="width:60px; height:25px;" value="초대하기">
			
				
				
				</div>
		</div>
		
		
	</div>
<div class="floor_h10">

</div>



	<jsp:include page="../footer.jsp" flush="false" />


</body>



	<script type="text/javascript">
	
	function showinvitelayer()
	{
	document.getElementsByClassName("invitelayer")[0].style.visibility="visible";
	}
	

	function closeinvitelayer()
	{
	document.getElementsByClassName("invitelayer")[0].style.visibility="hidden";
	}
	
 $(document).ready(function(){
	chatListFunction('ten');
	getInfiniteChat();
	changeroom(${gid});
});
 
 
 $('.grouplist').click(function(){
		$('#chatList').empty();
		chatListFunction('ten');
		getInfiniteChat();
	});

</script>
<script>
function alert1()
{
alert();	
}
</script>

</html>