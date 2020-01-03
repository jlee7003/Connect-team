<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="/Connect-team/resources/main.css?ver=header43">
<script>
var roomnum=1;
function all_submit()
{
	var reserver_q="";
	var roomname_q="";
	var starttime_q="";
	var stoptime_q="";
var reserver=document.getElementsByClassName("reserver");	
var roomname=document.getElementsByClassName("roomname");	
var starttime=document.getElementsByClassName("starttime");	
var stoptime=document.getElementsByClassName("stoptime");	
for(i=0;i<roomnum;i++)
{
	reserver_q=reserver_q+reserver[i].value+",";
	roomname_q=roomname_q+roomname[i].value+",";
	starttime_q=starttime_q+starttime[i].value+",";
	stoptime_q=stoptime_q+stoptime[i].value+","; 
}
document.getElementsByClassName("reserver");	
document.getElementsByClassName("roomname_a")[0].value=roomname_q;	
document.getElementsByClassName("starttime_a")[0].value=starttime_q;	
document.getElementsByClassName("stoptime_a")[0].value=stoptime_q;	

}

	$(function() {
		$("#minus").click(function() {
			$("#bb").eq(0).remove();
			roomnum=roomnum-1;
		});
		$("#plus").click(function() {
			roomnum=roomnum+1;
			alert(roomnum);
			$("#aa").append("<div id='bb'>"
				+"<div>"
				+"<input type=hidden name='reserver' class='reserver' value=none>" 
				+"방이름<input type=text name='roomname' class='roomname'>"
				+"</div>"
				+"<div>"
				+"시작시간 <select class='starttime' name='starttime'>"
						+"<option value='0'>0시</option>"
						+"<option value='1'>1시</option>"
						+"<option value='2'>2시</option>"
						+"<option value='3'>3시</option>"
						+"<option value='4'>4시</option>"
						+"<option value='5'>5시</option>"
						+"<option value='6'>6시</option>"
						+"<option value='7'>7시</option>"
						+"<option value='8'>8시</option>"
						+"<option value='9'>9시</option>"
						+"<option value='10'>10시</option>"
						+"<option value='11'>11시</option>"
						+"<option value='12'>12시</option>"
						+"<option value='13'>13시</option>"
						+"<option value='14'>14시</option>"
						+"<option value='15'>15시</option>"
						+"<option value='16'>16시</option>"
						+"<option value='17'>17시</option>"
						+"<option value='18'>18시</option>"
						+"<option value='19'>19시</option>"
						+"<option value='20'>20시</option>"
						+"<option value='21'>21시</option>"
						+"<option value='22'>22시</option>"
						+"<option value='23'>23시</option>"
						+"</select> "
						+"</div>"
						+"<div>"
					+"마무리시간 <select class='stoptime' name='stoptime'>"
					+"<option value='0'>0시</option>"
					+"<option value='1'>1시</option>"
					+"<option value='2'>2시</option>"
					+"<option value='3'>3시</option>"
					+"<option value='4'>4시</option>"
					+"<option value='5'>5시</option>"
					+"<option value='6'>6시</option>"
					+"<option value='7'>7시</option>"
					+"<option value='8'>8시</option>"
					+"<option value='9'>9시</option>"
					+"<option value='10'>10시</option>"
					+"<option value='11'>11시</option>"
					+"<option value='12'>12시</option>"
					+"<option value='13'>13시</option>"
					+"<option value='14'>14시</option>"
					+"<option value='15'>15시</option>"
					+"<option value='16'>16시</option>"
					+"<option value='17'>17시</option>"
					+"<option value='18'>18시</option>"
					+"<option value='19'>19시</option>"
					+"<option value='20'>20시</option>"
					+"<option value='21'>21시</option>"
					+"<option value='22'>22시</option>"
					+"<option value='23'>23시</option>"
			
						+"</select>"
						+"</div>"
						+"</div>");
		});
	});
function updatesroom(pp,name,qq,ww)
{
	document.getElementsByClassName("uproomname")[0].value=name;
	document.getElementsByClassName("upid")[0].value=pp;
	document.getElementsByClassName("upstarttime")[0].value=qq;
	document.getElementsByClassName("upstoptime")[0].value=ww;
	document.getElementsByClassName("invitelayer")[0].style.visibility="visible";
}

function showinvitelayer()
{
document.getElementsByClassName("invitelayer")[0].style.visibility="visible";
}


function closeinvitelayer()
{
document.getElementsByClassName("invitelayer")[0].style.visibility="hidden";
}


$(function()/* 드래그 가능하게 해주는 jquery 플러그인 */
		 {
			 $(".invitelayer").draggable(
					 {

					 });
		 });

function deletestudyroom()
{
    var id=$(".upid").val();
    location.href="deletestudyroom?id="+id;
}
</script>
<style>
.invitelayer {
	/* display:none; */
	position: absolute;
	left: 300px;
	top: 300px;
	visibility: hidden;
	background: white;
	border: 1px solid black;
}
</style>
</head>
<body>
	<jsp:include page="../header.jsp" flush="false" />


<div class="invitelayer ">
		<form name="insertform" action="updatestudyroom" style="width:100%; height:100%;" >
		<div class="toplayer flex">
		<div  class="flex center" style="background:black; width:90%;">수정하기</div>
		<div align=right style="width:10%; padding:5px;" onclick="closeinvitelayer()">X</div>	
		</div>
		<div class="flex center" style="height:100%;">
		<div>

	    <div>
	    방이름<input type="text" class="uproomname" name="uproomname" value="">
	    <input type="hidden" class="upid" name="upid" value="">
	    </div>
			<div>
			시작시간 <select name="upstarttime" class="upstarttime">
				<%
					for (int i = 0; i < 24; i++) {
				%>
				<option value=<%=i%>><%=i%>시
				</option>
				<%
					}
				%>
			</select>
		</div>
		<div>
			마무리시간 <select name="upstoptime" class="upstoptime">
				<%
					for (int i = 0; i < 24; i++) {
				%>
				<option value=<%=i%>><%=i%>시
				</option>
				<%
					}
				%>
			</select>
		</div>
			    <input type="submit" value="수정">
			    <input onclick="deletestudyroom()" type="button" value="삭제">
	    </div>		

	    </div>
		</form>
	</div>


	<div class="flex center fontsize_ font_git">STUDY ROOM</div>
	<div class="flex center">
	<div class="flex center" style="border: 1px solid black; width: 800px; height: 500px;">
		<table align=center class="align_center" cellspacing="5">

			<tr>
			<td style="text-align:center; background: gray; height: 70px; width: 70px;">studyroom</td>
			
				<!-- 스터디룸이 하나도 없을 경우 -->
				<c:if test="${studylist.size() == 0 }">
					<td>
						<div class="flex center" style="margin-top: 100px;">스터디룸
							준비중입니다.</div>
					</td>
				</c:if>

				<!-- 스터디룸이 한개 이상일 경우 -->
				<c:set var="i" value="1" />
				<c:forEach items="${studylist}" var="dto">
					<c:set var="i" value="${i+1}" />
					<td onclick="updatesroom(${dto.id},'${dto.roomname}','${dto.stime}','${dto.endtime}')" style="text-align:center; border-radius:5px; background: #B8E7FF; height: 70px; width: 70px;">${dto.roomname}</td>
					<c:if test="${i%6==0}">
			</tr>
			<tr>
				</c:if>
				</c:forEach>
			</tr>
		</table>
	</div>
	</div>
	
	<div class="flex center">
	
<div>
	<div>
<div>
	방 추가하기
</div>
	<input type="button" name="plusroom" value="+" id="plus">
	<input type="button" name="plusroom" value="-" id="minus">
</div>

	<form method="post" action="makestudyroom_ok">
	<div>
		<input type=hidden name="stoptime_a" class="stoptime_a" >
		<input type=hidden name="roomname_a" class="roomname_a">
		<input type=hidden name="starttime_a" class="starttime_a">
		<input type=hidden name="reserver" class="reserver" value="${username}">
		 방이름<input type=text name="roomname" class="roomname">
	</div>
		<div>
			시작시간 <select name="starttime" class="starttime">
				<%
					for (int i = 0; i < 24; i++) {
				%>
				<option value=<%=i%>><%=i%>시
				</option>
				<%
					}
				%>
			</select>
		</div>

		<div>
			마무리시간 <select name="stoptime" class="stoptime">
				<%
					for (int i = 0; i < 24; i++) {
				%>
				<option value=<%=i%>><%=i%>시
				</option>
				<%
					}
				%>
			</select>
		</div>
		<div id="aa"></div>
		<input type="submit" value="스터디룸 만들기" onclick="all_submit()">
	</form>
</div>
	</div>

</body>
</html>