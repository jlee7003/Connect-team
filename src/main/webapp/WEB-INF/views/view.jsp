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
<title>Insert title here</title>
</head>
<script>
$(document).ready(function(){
	  $("p").hide();
	  // $("ul > li:first-child a").next().show();
	  $("ul li a").click(function(){
	    $(this).next().slideToggle(300);
	    // $(this).next().slideDown(300);
	    $("ul li a").not(this).next().slideUp(300);
	    return false;
	  });
	  $("ul li a").eq(0).trigger("click");
	});
</script>
<style>
.500{

}
</style>
<body>
<!-- test1 -->
<table cellspacing=0 width=100% height=632 align=center style="text-align:center; padding:10px;">
			<tr height=62 style="height:62px; max-height:120px; border:1px solid black; background:black; color:white; text-align:center;">
				<td height=62  style="border-radius:5px 0px 0px 0px; ">번호</td>
				<td height=62>작성자</td>
				<td height=62>제목</td>
				<td height=62 style="border-radius:0px 5px 0px 0px; ">작성일</td>
			</tr>
			
			
				<tr class="btn-3" style="background:white; border-bottom:5px solid black;">
					<td  style="border-bottom:1px solid #1187CF;">247</td>
					<td style="border-bottom:1px solid #1187CF;"><a href="content?id=247&gid=6&boardid=27&page=1">
					테스터4</a></td>
					<td style="border-bottom:1px solid #1187CF;"><a href="content?id=247&gid=6&boardid=27&page=1">
							overflow </a></td>
					<td style="border-bottom:1px solid #1187CF;">2019-12-11</td>
				</tr>
			



			<tr height=62 style=" border-radius:0px 0px 5px 5px; color:white;">
				<td  colspan=4 align=right style=" background:black; border-radius:0px 0px 5px 5px;"><a style="width:100%; height:100%; background:black; border-radius:0px 0px 5px 5px; color:white; margin-right:50px;"
					href="write?gid=6&boardid=27&page=1"> 글쓰기 </a></td>
			</tr>
		</table>
</body>
</html>