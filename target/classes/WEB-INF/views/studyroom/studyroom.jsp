<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script>
var stime="";
var etime="";



function submit_check()
{
	if(document.insertform.upstarttime.value >= document.insertform.upstoptime.value) 
	{
		alert("제대로 입력해주십시오");
	return false;
	}
	else if(document.insertform.upstoptime.value - document.insertform.upstarttime.value > 2)
		{
		alert("2시간 이상 예약은 불가합니다.");
		return false;
		}
	else if(document.insertform.upstarttime.value=="no" || document.insertform.upstoptime.value=="no")
	{
	alert("예약시간을 골라주세요");
	return false;
	}
	else 
		{
		return true;
		}
}
/* function onblur123()
{
	$("#aa").append(function(){
		var str = "";
		var str1 = "<option value=";
		var str2 = ">";
		var str3 = "시";
		  for(var i =qq ; i < ww ; i++){
		    str +=  str1+i+str2+i+str3
		    alert(str);
		  }
		  return str +='</option>';
		});
} */


function updatesroom(pp,name,qq,ww)
{
	
	   $("#aa").empty();
	     $("#bb").empty();
	document.getElementsByClassName("uproomname")[0].value=name;
	document.getElementsByClassName("upid")[0].value=pp;
	document.getElementsByClassName("upstarttime")[0].value=qq;
	document.getElementsByClassName("upstoptime")[0].value=ww;
	stime=qq;
	etime=ww;
	switch(qq)
	{
	case "2": qq=2; break;
	case "3": qq=3; break;
	case "4": qq=4; break;
	case "6": qq=6; break;
	case "7": qq=7; break;
	case "8": qq=8; break;
	case "9": qq=9; break;
	}	
	switch(ww)
	{
	case "2": ww=2; break;
	case "3": ww=3; break;
	case "4": ww=4; break;
	case "6": ww=6; break;
	case "7": ww=7; break;
	case "8": ww=8; break;
	case "9": ww=9; break;
	}
	
	$(function(){
		$("#aa").append(function(){
			var str4 ="<option value="
			
			var str5 =">선택</option>"
			var str = str4+"no"+str5;
			var str1 = "<option id="+pp+" value=";
			var str2 = ">";
			var str3 = "시";
			  for(var i = qq ; i < ww ; i++){
			    str += str1+i+str2+i+str3
			  }
			  return str +='</option>';
			});
		
		$("#bb").append(function(){
			var str4 ="<option value="
				
				var str5 =">선택</option>"
				var str = str4+"no"+str5;
			var str1 = "<option id="+pp+" value=";
			var str2 = ">";
			var str3 = "시";
			
			  for(var i = qq ; i < ww ; i++){
			    str +=  str1+i+str2+i+str3
			  }
			  return str +='</option>';
			});
	})
	
	document.getElementsByClassName("invitelayer")[0].style.visibility="visible";
}

function showinvitelayer()
{
	
document.getElementsByClassName("invitelayer")[0].style.visibility="visible";
}


function closeinvitelayer()
{
			     $("#aa").empty();
			     $("#bb").empty();
document.getElementsByClassName("invitelayer")[0].style.visibility="hidden";
}


$(function()/* 드래그 가능하게 해주는 jquery 플러그인 */
		 {
			 $(".invitelayer").draggable(
					 {

					 });
		 });
		 <%
		    
		 %>
		 
/*  alert("${reservationlist.size()-1}");
 <c:set var="num" value="${reservationlist.size()}" scope="request"/>

	<c:forEach items="${reservationlist}" var="dto">
	   alert("${dto.stime}");
</c:forEach> */
	   

function imsi()
{
	<c:forEach items="${reservationlist}" var="dto2">
	<c:set var="start" value="${dto2.stime}" />
	<c:set var="end" value="${dto2.endtime}" />
	<c:set var="roomid" value="${dto2.roomid}" />
	<c:set var="roomname" value="${dto2.roomname}" />
disable(${roomid},${roomname},${start},${end});
</c:forEach>
}
	   
function disable(id,roomname,stime,endtime)
{
	$("select option[value*="+stime+"][id="+id+"]").prop('disabled',true);	
	$("select option[value*="+endtime+"][id="+id+"]").prop('disabled',true);	
}
</script>
<style>
.align_center {
	text-align: center;
}
</style>
<title>Insert title here</title>
</head>
<body class="font_git" >	
	<jsp:include page="../header.jsp" flush="false" />

	<div class="invitelayer ">
		<form name="insertform" onsubmit="return submit_check()"
			action="reservestudyroom" style="width: 100%; height: 100%;">
			<div class="toplayer flex">
				<div class="flex center" style="background: black; width: 90%;">예약하기</div>
				<div align=right style="width: 10%; padding: 5px;"
					onclick="closeinvitelayer()">X</div>
			</div>
			<div class="flex center" style="height: 100%;">
				<div>

					<div>
						사용자 ${user} <br>
						 <input type="hidden" name="reserver" value="${user}">
					방이름<input type="text" class="uproomname" name="uproomname" readonly> <input
							type="hidden" class="upid" name="upid" value="">

					</div>

					<div>
						사용시간 <select name="upstarttime" class="upstarttime" id=aa>
							<option value="no">선택</option>


						</select>
					</div>
					<div>
						마무리시간 <select name="upstoptime" class="upstoptime" id=bb>
							<option value="no">선택</option>

						</select>
						<!-- 선택한 studyroom의 아이디에 맞추어서 예약리스트의 값을 보여준다 -->
						
					</div>
					<input type="submit" value="예약">
				</div>

			</div>
		</form>
	</div>



	<div class="floor_h60 center">
		<div>
			<div class="flex center fontsize_ font_git">STUDY ROOM</div>
			<div class="flex center">
				<div class="flex center"
					style="border: 1px solid black; width: 800px; height: 500px;">
					<table align=center class="align_center" cellspacing="5">

						<tr>
							<td
								style="text-align: center; background: #E3E3E3; height: 70px; border-radius:5px; width: 70px;">studyroom</td>
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
								<td onclick="updatesroom(${dto.id},'${dto.roomname}','${dto.stime}','${dto.endtime}'); imsi();" style="text-align:center; border-radius:5px; background: #B8E7FF; height: 70px; width: 70px;">${dto.roomname}</td>
								<c:if test="${i%6==0}"></tr>
						<tr>
							</c:if>
							</c:forEach>
							
						</tr>
					</table>
				</div>
			</div>


		</div>
	</div>
	<div class="floor_h10"></div>

	<jsp:include page="../footer.jsp" flush="false" />
</body>
</html>