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
.hidden2{
visibility: hidden;
}
.hidden
{
position: absolute;
	left: 0px;
 	width:197.81px;
	top: 640px;
	visibility: hidden;
	background: white;
	border: 1px solid black;
visibility: hidden;
}
.flex{
display:flex;
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
	alert(pp+" "+aa);
	var directoryid=aa;
	 var directoryname=pp;
	 var trueval=1;
	 location.href="opendirok?gid="+${gid}+"&directoryname="+directoryname+"&trueval="+trueval+"&directoryid="+directoryid;
	 
}
function makeboard()
{
	
	 var trueval=1;
	 var pp=document.getElementsByClassName("hidden2").length;
// 	 alert(pp);//2
	 for(i=0;i<pp;i++)
		 {
	 document.getElementsByClassName("hidden2")[i].style.visibility="visible";
		 }
// 	 location.href="makeboard?gid="+${gid}+"&directoryname="+directoryname+"&trueval="+trueval;
}


function showinvitelayer(pp,aa)
{
	confirm();
	alert(pp+" "+aa);
	document.getElementById("directoryname").value=aa;
	document.getElementById("directoryid").value=pp;
alert(document.getElementById("directoryid").value+" "+document.getElementById("directoryname").value);
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
    		alert(pp+" "+aa);
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
   	 alert(directoryid+""+boardname+""+directoryname);
    	   alert("취소하셨습니다");
    		alert(pp+" "+aa);
    }

}


function closeinvitelayer()
{
document.getElementsByClassName("hidden")[0].style.visibility="hidden";
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
자유계시판

	<div  class="hidden">
	<div  class="flex center_j">계시판레이어
	<span  onclick="closeinvitelayer()">X</span>
	</div>
	<form method="post" action="makeboarddir">
	<input type="hidden" name="directoryname" id="directoryname">
	<input type="hidden" value="${gid}" name="gid" id="gid">
	<input type="hidden" name="directoryid" id="directoryid">
	<input type="text" name="boardname" id="boardname">
	<input type="submit" value="만들기">
	</form>
	</div>
	
	
	
	<div onclick="makedir()">디렉토리 만들기</div>
	<div onclick="makeboard()">계시판 만들기</div>
	<input type="text" name="directorynameon" id="directorynameon">
	<c:forEach items="${list}" var="dto">
		<div>
<!-- 		document.getElementsByClassName('directoryname')[0].value --> 
                                     <!-- onclick="makeboard()" -->
			<input type="button" value="${dto.directoryname}" onclick="opendir(this.value,${dto.directoryid})">
<%-- 			<input type="button" value="${dto.directoryname}" onclick="showinvitelayer(${dto.directoryid},this.value)"> --%>
			<span class="hidden2" onclick="showinvitelayer(${dto.directoryid},'${dto.directoryname}')">○</span>
			<span class="hiddenfx" onclick="deletefolderdir(${dto.directoryid},'${dto.directoryname}',${dto2.boardname})">X</span>
			 <!-- 왜 폴더네임은 오류가 날까? -->
			<div>
				<c:forEach items="${list2}" var="dto2">
					<div>
				<c:set var="name4" value="${dto2.groupid}" />	
				<c:set var="name5" value="${dto.groupid}" />	
				<c:set var="name1" value="${dirname}" />
				<c:set var="name2" value="${dto2.directoryname}" />
				<c:set var="name3" value="${dto.directoryname}" />
				<c:if test="${name1 eq name2 && name2 eq name3 && name4 eq name5}"><!-- 내가 클릭한 디렉토리 이름을 비교해야함 -->
				    <div class="flex center">&nbsp;<div onclick="opendir2()">${dto2.boardname} </div><span class="hiddenx" onclick="deleteboarddir(${dto.directoryid},'${dto2.boardname}')">X</span></div>
				   
				</c:if>


<%-- 						&nbsp;<div onclick="opendir2()">${dto2.boardname}</div> --%>
					</div>
				</c:forEach>
			</div>
		</div>
	</c:forEach>
</body>
</html>