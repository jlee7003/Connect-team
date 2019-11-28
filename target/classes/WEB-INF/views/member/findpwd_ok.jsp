<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
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
function emailcheck(email1, email2)
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
    // 인증을 위해 새창으로 이동
	var url="emailcheck?email1="+email1+"&email2="+email2;
	open(url,"emailwindow", "statusbar=no, scrollbar=no, menubar=no, width=400, height=200" );
}

function alert11()
{
	alert(document.getElementById("hv").value);
}

</script>
<body>
<jsp:include page="../header.jsp" flush="false" />



<!-- 1 -->
<div class="floor_h70 flex center">
		<div class="shadow padding_50 width25 login_minw login_minh font_design_ns">
				<div class="login container" align=center>
				<div>
					<div class="font_design2 container_w5 ">
						<img alt="logo" class="margin_left_10 padding" width=74 height=55
							src="resources/img/logo2.PNG">
					</div>
<!-- 							<input type=text name=email -->
<!-- 								class="input_width100 bd_radius height_20 inputtag"> -->
			<div class="fontsize_115">
			안녕하세요	${Fpwd.username} 고객님<p>
			고객님의 고객정보는 아래와 같습니다.
			</div >						
			<div class="fontsize_1 padding_20">비밀번호 : ${Fpwd.password}</div>
			
			</div>
			<hr>
			<div class="margin_top_100">
			<a href="/connect" class="">메인으로 가기</a>
			</div>
		</div>
		</div>
		</div>
<!--  -->
		<%-- <table border=1>
			<tr>
				<td>전화번호</td>
				<td><input type=text name=phone id=phone> </td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type=text name=username id=username></td>
			</tr>
			<tr>
				<td>아이디(email)</td>
				<td>
					
		<form name=insertform action="checkemail">
			<input type="text" name="email1" maxlength="15" size=10 id=email1>
	<!-- 		<input type=hidden value=> -->
	<!-- 		<input type=hidden value=> -->
			@ <select name="email2" id="email2">
				<option value="0">직접입력</option>
				<option value="naver.com">naver.com</option>
				<option value="daum.net">daum.net</option>
				<option value="nate.com">nate.com</option>
				<option value="gmail.com">gmail.com</option>
			</select> <input type="button" name="emailconfirm_btn" value="인증"
				onclick="emailcheck(insertform.email1.value, insertform.email2.value)">
			<p>
				<span id=aaa></span>
					<span onclick=alert11()>확인하기</span>
		</form>
					
				
				
				</td>
			</tr>
		</table>
		
		
		
		${Fpwd.password} 비밀번호

	
	
	<form method=post action=findpwd name=plusemail
					onsubmit="return checkall()">
					<input type=hidden name=emailval value=0 id=hv>
					<input type=hidden name=email> 
					<input type=hidden name=username> 
					<input type=hidden name=phone>
				    <input type=submit value="확1인" style="color:white"
						id=aa3>
				</form> --%>


<!-- 				<form method=post action=findid_ok.jsp name=plusemail -->
<!-- 					onsubmit="return checkall()"> -->
<!-- 					<input type=hidden name=sel value=0>  -->
<!-- 					<input type=hidden name=hiddenval value=0 id=hv> -->
<!-- 						 <input type=hidden name=val> -->
<!-- 					<input type=hidden name=name> <input type=submit value="확인" style="color:white" -->
<!-- 						id=aa3> -->
<!-- 				</form> -->

<jsp:include page="../footer.jsp" flush="false" />
</body>
</html>
	
