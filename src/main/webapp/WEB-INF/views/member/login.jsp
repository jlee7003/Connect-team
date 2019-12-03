<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#red{
color:red;
}
</style>
<script>
function login_check() 
{
if(document.loginform.email.value == "" || document.loginform.password.value == "" || document.loginform.email.value == null || document.loginform.password.value == null) 
	{
	document.loginform.email.value == ""
	return false;
	}
	else
		{
	
		return true;
		}
}
</script>
<body>
	<jsp:include page="../header.jsp" flush="false" />
	<div class="floor_h70 flex center">
		<div class="shadow padding_50 width25 login_minw login_minh">
			<div class="login container" align=center>
				<div>
					<div class="font_design2 container_w5">
						<img alt="logo" class="margin_left_10 padding" width=74 height=55
							src="resources/img/logo2.PNG">
					</div>
					<hr>
				</div>
				<form method="post" action="login_ok" name=loginform>
					<table>
						<%
							if (session.getAttribute("userid") == null)//세션변수가 없다면
							{
						%>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><span class="font_design">Email</span></td>
						</tr>
						<tr>
							<td><input type=text name=email
								class="input_width100 bd_radius height_20 inputtag"></td>
						</tr>
						<tr>
							<td class="font_design">Password</td>
						</tr>
						<tr >
							<td align=center><input type=password name=password	class="input_width100 bd_radius height_20 inputtag"></td>
						</tr><!--  -->
						<tr>
							<td id=red>${err}</td>
						</tr>

						<tr>
							<td><a href="findid">Forgot password?</a></td>
							<td></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr align=center>
							<td align=center>
								<!-- <a href="Joinus">LOGIN</a><p> --> <input 
								class="input_login font_design color_white" type="submit" onclick="return login_check()"
								value="Login">
								<p>
									<%
										} else {
									%>
								
								<div>
									<input type=button onclick="location='logout'" value=logout>
								</div> <%=session.getAttribute("username")%>님 환영합니다! <a
								href="chatroom">chatroom</a> <%
 	}
 %>
							</td>
							<td></td>
						</tr>
					</table>
				</form>


			</div>
		</div>
	</div>

	<jsp:include page="../footer.jsp" flush="false" />
</body>
</html>