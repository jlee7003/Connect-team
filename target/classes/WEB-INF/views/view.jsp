<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.500{

}
</style>
<body>
<!-- test -->

 <%
 if(session.getAttribute("userid")==null)//세션변수가 없다면
 {
 %>
<a href="Joinus">LOGIN</a><p>
<a href="findid">idforget</a>
<a href="findpwd">pwdforget</a>
<%}
 else
 {
 %>
 <%=session.getAttribute("username")%>
	<div><a href="logout">logout</a></div>
 <%
 }
 %>
		<div class="500">
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>	<table border=1>
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
			@ <select name="email2" id="email2" >
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

	
	



<!-- 				<form method=post action=findid_ok.jsp name=plusemail -->
<!-- 					onsubmit="return checkall()"> -->
<!-- 					<input type=hidden name=sel value=0>  -->
<!-- 					<input type=hidden name=hiddenval value=0 id=hv> -->
<!-- 						 <input type=hidden name=val> -->
<!-- 					<input type=hidden name=name> <input type=submit value="확인" style="color:white" -->
<!-- 						id=aa3> -->
<!-- 				</form> -->

Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>
Test1<p>
Test2<p>

</div>
</body>
</html>