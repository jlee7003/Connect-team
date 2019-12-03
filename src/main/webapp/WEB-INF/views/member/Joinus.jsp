<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
</style>
<!-- body 시작부 -->

<body>
	<jsp:include page="../header.jsp" flush="false" />
	<div class="floor_h83 center shadow">
		<!-- floor 에서의 높이는 전부 일정해야함 -->

		<!-- joinus -->
		<div class="width40" align=center>
			<img alt=""  src="resources/img/join.PNG" class="border_logo">
			<a href="chatroom">chat</a>
		</div>
		<div class="width40" align=center>
			<!-- width, height:auto -->

			<div>
				<h1 class="margin_10">
					Join to <span class="color_connect fontsize_">Connect</span>
				</h1>
			</div>
			<form method=post action="Joinus_ok" name=joinform
				onsubmit="return submit_check()">
				<table>
					<tr>
						<td onclick=alert();>이름</td>
						<td><input type="text" name="username"
							class="input_width bd_radius height_20" onblur=alertout()></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<div id=innertext1 class="height_20 font_size_14"></div>
						</td>
					</tr>
					<tr>
						<td>핸드폰번호</td>
						<td><input type="text" name="phone"
							class="input_width bd_radius height_20" onclick=phonealert()
							onblur=alertout()></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<div id=innertext2 class="height_20 font_size_14"></div>
						</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" name="email"
							class="input_width bd_radius height_20" onblur=alertout()></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<div id="innertext3" class="height_20 font_size_14"></div>
						</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="password"
							class="input_width bd_radius height_20" onblur=alertout()></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<div id=innertext4 class="height_20 font_size_14"></div>
						</td>
					</tr>
					<tr>
						<td>생일</td>
						<td>
							<div class=display_flex>
								<select name=year class="select_width bd_radius ">
									<c:forEach var="i" begin="1905" end="2020" step="1">
										<option value="${2020 - i + 1905}">${2020 - i + 1905}</option>
									</c:forEach>
								</select> <select name=month class="select_width bd_radius">
									<option>월</option>
									<c:forEach begin="1" end="12" var="i" step="1">
										<option value=${i} >${i}월</option>
									</c:forEach>
								</select> <select name=day class="select_width bd_radius">
									<option>일</option>
									<c:forEach begin="1" end="31" var="i" step="1">
										<option value=${i}>${i}일</option>
									</c:forEach>
								</select> <input type="hidden" name="birth">
							</div>

						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<div id=innertext5 class="height_20 font_size_14"></div>
						</td>
					</tr>
					<tr>
						<td>성별</td>
						<td align=center>남자<input type=radio name=sex value=0>
							여자<input type=radio name=sex value=1></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<div id=innertext6 class="height_20 font_size_14"></div>
						</td>
					</tr>
					<tr align=center>
						<td></td>
						<td align=center><input type=submit value="join"></td>
					</tr>
				</table>



			</form>

		</div>




	</div>
	<jsp:include page="../footer.jsp" flush="false" />
</body>

<script>
/* joinus1 */
 	function phonealert()
 	{
 		document.all.innertext2.innerHTML = "<b style='color:#828282'> '-' 표시 없이 입력해주세요</b>";
 	}
 	function alertout()
 	{
 		document.all.innertext1.innerHTML = "";
 		document.all.innertext2.innerHTML = "";
 		document.all.innertext3.innerHTML = "";
 		document.all.innertext4.innerHTML = "";
 		document.all.innertext5.innerHTML = "";
 		document.all.innertext6.innerHTML = "";
 	}
	function submit_check() 
	{
		
	if(document.joinform.username.value == "") 
		{
		document.all.innertext1.innerHTML = "<b style='color:#828282'>이름을 입력해주세요</b>";
		document.joinform.name.focus();
		return false;
		}
	else if(document.joinform.phone.value == "" )
	{
		document.all.innertext2.innerHTML = "<b style='color:#828282'>전화번호를 입력하세요</b>";
		document.joinform.phone.focus();
		return false;
	}
		else if (document.joinform.email.value == "") 
		{
			document.all.innertext3.innerHTML = "<b style='color:#828282'>아이디를 입력해주세요</b>";
			document.joinform.email.focus();
			return false;
		} 
		else if (document.joinform.email.value.length <= 5)
		{
			document.all.innertext3.innerHTML = "<b style='color:#828282'>아이디를 6자 이상으로 만들어주세요</b>";
			document.joinform.email.focus();
			return false;
		}
		else if (document.joinform.password.value == "")
		{
			document.all.innertext4.innerHTML = "<b style='color:#828282'>비밀번호를 입력 해주세요</b>";
			document.joinform.password.focus();
			return false;
		}
	
		else if (document.joinform.password.value.length <= 5)
		{
			document.all.innertext4.innerHTML = "<b style='color:#828282'>비밀번호를 6자 이상으로 만들어주세요</b>";
			document.joinform.password.focus();
			return false;
			
		}
		else if (document.joinform.month.value == "월" || document.joinform.day.value == "일")
		{
			document.all.innertext5.innerHTML = "<b style='color:#828282'>생년월일을 확인해주세요</b>";
			return false;
		}
	
   	 	else if(document.joinform.sex[0].checked == false && document.joinform.sex[1].checked == false  )
	 		{
   	 	document.all.innertext6.innerHTML = "<b style='color:#828282'>성별을 선택해주세요</b>";
	 	return false;
	 		}
			
		else
			{
			var birth=document.joinform.year.value+document.joinform.month.value+document.joinform.day.value; 
			document.joinform.birth.value=birth;
			alert(document.joinform.birth.value);
			return true;
			}
	}
</script>
</html>