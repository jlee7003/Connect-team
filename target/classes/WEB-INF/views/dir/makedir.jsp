<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
width:20%;
height:740.09px;
padding:2px;
margin:0px;
}
.hidden2{
visibility: hidden;
}
.hidden222{
visibility: hidden;
}
.center {
	align-items: center;
	justify-content: center;
}
 .hidden 
{
position: absolute;
	left: 20px;
 	width:197.81px;
	top: 440px;
	visibility: hidden;
	background: white;
	border: 1px solid black;
visibility: hidden;
}
.flex{
display:flex;
}

.hiddenx{
display:none;
}
.hiddenfx{
display:none;
}
	.dropdown-button {
	margin-top:10px;
			padding: 5px;
			font-size: 20px;
			border: none;
			width:100%;
			color: #1388CF;
			background-color: white;
		}
		.dropdown {
			position: relative;
			display: inline-block;
		}
		.dropdown-content {
			display: none;
			position: absolute;
			background-color: white;
			min-width: 75px;
			padding: 5px;
		}
		.dropdown-content a {
			color: black;
			padding: 8px;
			text-decoration: none;
			display: block;
		}
		.filelayer {
			position: absolute;
			left: 0px;
			top: 300px;
			visibility: hidden;
			background: white;
			border: 1px solid black;
		}
		.dropdown-content div:hover { background-color: #ced4da; color: black; }
		.dropdown:hover .dropdown-content { display: block; }
		.dropdown:hover .dropdown-button { background-color: #1388CF; color:white; }
.button_submit {
	width: 100px;
	background: black;
	border: none;
 	color: white; 
	border-radius: 3px;
	height: 20px;
}
.toplayer
{
background:black;
color:white;
border:1px solid black;
}
.btn-5:hover {
  border: 0px solid;
  box-shadow: inset 0 0 20px rgba(255, 255, 255, .5), 0 0 20px rgba(255, 255, 255, .2);
  outline-color: rgba(255, 255, 255, 0);
  outline-offset: 15px;
  text-shadow: 1px 1px 2px #427388; 
}
a:link {
	text-decoration: none;
}

a:visited {
	color: black;
	text-decoration: none;
}

a:hover {
	color: black;
	text-decoration: none;
}
</style>
<script>
function makedir()
{
	 var directoryname=document.getElementById("directorynameon").value;
	 if(directoryname=="")
		 {
		 alert("값이 비었습니다.");
		 }
		 else
		 {
		 var trueval=1;
		 location.href="makedirok?gid="+${gid}+"&directoryname="+directoryname+"&trueval="+trueval;
		 }
}

function makedir2()
{
	 var directoryname=document.getElementById("directoryname").value;
	 var trueval=1;
	 location.href="makedirok2?gid="+${gid}+"&directoryname="+directoryname+"&trueval="+trueval;
}
function opendir(pp,aa)
{	
	var directoryid=aa;
	 var directoryname=pp;
	 var trueval=1;
	 location.href="opendirok?gid="+${gid}+"&directoryname="+directoryname+"&trueval="+trueval+"&directoryid="+directoryid;
	 
}
function makeboard()
{
	
	 var trueval=1;
	 var pp=document.getElementsByClassName("hidden2").length;
	 for(i=0;i<pp;i++)
		 {
	 document.getElementsByClassName("hidden2")[i].style.visibility="visible";
		 }
// 	 location.href="makeboard?gid="+${gid}+"&directoryname="+directoryname+"&trueval="+trueval;
}


function showinvitelayer(pp,aa)
{
	document.getElementById("directoryname").value=aa;
	document.getElementById("directoryid").value=pp;
document.getElementsByClassName("hidden")[0].style.visibility="visible";
}

function deleteboarddir(pp,aa)
{
    msg = "계시판을 삭제하시겠습니까?";
    if (confirm(msg)!=0) {
     var directoryid=pp;
   	 var boardname=aa;
	 var directoryname=aa;
	location.href="deletedirok?gid="+${gid}+"&boardname="+boardname+"&directoryid="+directoryid+"&directoryname="+directoryname;
    } else 
    {
    	   alert("취소하셨습니다");
    }

}
function deletefolderdir(pp,aa,bb)
{
    msg = "폴더를 삭제하시겠습니까? 계시물도 함께 사라집니다.";
    var directoryid=pp;
 	 var boardname=bb;
	 var directoryname=aa;
    if (confirm(msg)!=0) {
   

	location.href="deletefolderok?gid="+${gid}+"&boardname="+boardname+"&directoryid="+directoryid+"&directoryname="+directoryname;
    } else 
    {
    	   alert("취소하셨습니다");
    }

}


function closeinvitelayer()
{
document.getElementsByClassName("hidden")[0].style.visibility="hidden";
}

function showfx()
{
	var pp=document.getElementsByClassName("hiddenfx").length;
	 for(i=0;i<pp;i++)
	 {
 document.getElementsByClassName("hiddenfx")[i].style.display="block";
	 }
}

function showx()
{
	 var pp=document.getElementsByClassName("hiddenx").length;
	 for(i=0;i<pp;i++)
	 {
 document.getElementsByClassName("hiddenx")[i].style.display="block";
	 }
}




// $(function()/* 드래그 가능하게 해주는 jquery 플러그인 */
// 		 {
// 			 $(".hidden").draggable(
// 					 {

// 					 });
// 		 });
</script>

</head>
<body>
<div class="flex center" style="width:100%;">
<div style="width:80%;">
	<div  class="hidden boardlayer">
		<div class="toplayer flex">
		<div  class="flex center" style="background:black; width:90%;">계시판만들기</div>
		<div align=right style="width:10%; padding:5px;" onclick="closeinvitelayer()">X</div>	
		</div>
	<form method="post" action="makeboarddir">
<!-- 	<input type="hidden" name="directoryname" id="directoryname"> -->
	<input type="hidden" value="${gid}" name="gid" id="gid">
	<input type="hidden" name="directoryid" id="directoryid">
	<input type="hidden" name="directoryname" id="directoryname">
	<input type="text" name="boardname" id="boardname">
	<input type="submit" value="만들기">
	</form>
	</div>
	
	<div class="flex center" style="width:100%;">
<!-- 	onclick="makedir()" -->
	<!-- ----------menu------------ -->
	<c:if test="${manager == user}">
					
	<div class="dropdown" style="width:100%;">
		<button class="dropdown-button">Menu</button>
		<div class="dropdown-content">
		<div style="padding:5px;" onclick="showfx()">파일 삭제하기</div>
	<div style="padding:5px;" onclick="showx()">계시판 삭제하기</div>
	<div style="padding:5px;" onclick="showfilelayer()">디렉토리 만들기</div>
	<div style="padding:5px;" onclick="makeboard()">계시판 만들기</div>
		</div>
		<hr style="color:black;">
	</div>
	</c:if>
		<c:if test="${manager != user}">
					
	<div class="dropdown" style="width:100%;">
		<button class="dropdown-button">Category</button>
		<div class="dropdown-content">
		</div>
		<hr style="color:black;">
	</div>
	</c:if>
	
	
    <!-- ----------menu------------ -->
	
	</div>
	
	<input type="text" class="hidden222" name="f" id="s">
	<div style="background:#1388CF; border-radius:5px; min-height:300px; max-height:500px;">
	<c:forEach items="${list}" var="dto">
		<div class="">
<!-- 		document.getElementsByClassName('directoryname')[0].value --> 
                                     <!-- onclick="makeboard()" -->
                                     <div class="">
                                     <div class="flex" style="padding:5px;">
                                     <div name="inner" style="width:100%;" class="btn-5 flex">
			<img style="width:20px; margin-left:10px;" src="resources/img/file.PNG">
			<input type="button" style="margin:3px; border:none; background:none;" value="${dto.directoryname}" onclick="opendir(this.value,${dto.directoryid})">
                                  
                                     
<%-- 			<input type="button" value="${dto.directoryname}" onclick="showinvitelayer(${dto.directoryid},this.value)"> --%>
			<span class="hidden2" onclick="showinvitelayer(${dto.directoryid},'${dto.directoryname}')">○</span>
			<span class="hiddenfx" onclick="deletefolderdir(${dto.directoryid},'${dto.directoryname}',${dto2.boardname})">X</span>
<!-- 			 왜 폴더네임은 오류가 날까? -->
			 </div>
			 </div>
			   </div>
			<div>
				<c:forEach items="${list2}" var="dto2">
					<div>
				<c:set var="name4" value="${dto2.groupid}" />	
				<c:set var="name5" value="${dto.groupid}" />	
				<c:set var="name1" value="${dirname}" />
				<c:set var="name2" value="${dto2.directoryname}" />
				<c:set var="name3" value="${dto.directoryname}" />
				<c:if test="${name1 eq name2 && name2 eq name3 && name4 eq name5}"><!-- 내가 클릭한 디렉토리 이름을 비교해야함 -->
				    <div class="flex">
<%-- 				    <iframe src="http://localhost:8080/Connect-team/list?gid=${gid}&gname=${gname}" name="board" width="1340" height="746" class="border_none" scrolling="no"></iframe> --%>
				  <a class="btn-5" style="width:90%; padding:5px; margin-right:5px; margin-left:55px; color:white; font-size:13px;" href="list?gid=${gid}&gname=${gname}&boardid=${dto2.id}&page=1" target=iframe>
				   ${dto2.boardname}
				    </a>
				    <span class="hiddenx" onclick="deleteboarddir(${dto.directoryid},'${dto2.boardname}')">X</span>
				    </div>
				</c:if>


<%-- 						&nbsp;<div onclick="opendir2()">${dto2.boardname}</div> --%>
					</div>
				</c:forEach>
			</div>
		</div>
	</c:forEach>
	</div>
	</div>
	</div>
	
	<div class="filelayer">
	
		<div class="">
		<div class="toplayer flex">
		<div  class="flex center" style="width:90%;">파일 만들기</div>
		<div align=right style="width:10%; padding:5px;" onclick="closefilelayer()">X</div>	
		</div>
		<div style="padding:10px;">
			파일명 <br>
			 	<input type="text" class="" name="directorynameon" id="directorynameon">
		</div>
			 	<div class="flex center">
			 <div onclick="makedir()" class="button_submit flex center" style="margin-bottom:10px;">확인</div>
			 	</div>
		
		</div>
	</div>
</body>
<script>  
 $(function()/* 드래그 가능하게 해주는 jquery 플러그인 */
 {
	 $(".filelayer").draggable(
			 {

			 });
 });
 
 
 $(function()/* 드래그 가능하게 해주는 jquery 플러그인 */
		 {
			 $(".boardlayer").draggable(
					 {

					 });
		 });
 
 

 
	function showfilelayer()
	{
	document.getElementsByClassName("filelayer")[0].style.visibility="visible";
	}
	

	function closefilelayer()
	{
	document.getElementsByClassName("filelayer")[0].style.visibility="hidden";
	}
	
</script>
</html>