<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center">
	<h3 style="text-decoration:underline">Q & A</h3>
	<div style="position:absolute;width:1000px; height:500px; left:50%; top:50%; margin:-250px 0 0 -500px;">
	<table style="width:1000px; border:1px solid lightgrey">
		<tr style="height:50px;">
			<td colspan="2">${dto.qa_sub}</td>  
		</tr>
		<tr style="height:50px">
			<td style="width:150px;">${dto.qa_name} </td>
			<td style="width:150px;">${dto.qa_date}</td>
		</tr>		
		<tr style="height:300px">
			<td colspan="2">${dto.qa_con}</td>
		</tr>
		<tr style="height:50px"	>
			<td style="width:150px">Password</td>
			<td><form action="Check.ok"><input type="password" name="pwd">삭제하려면 비밀번호를 입력하세요.</form></td>
		</tr>
	</table>
	
	<br/>
	<p style="width:150px; height:30px; border:1px solid lightgrey;display:inline;text-align:left"><a href="/board2/qaList.khy">
	LIST</a></p> <!--  css 96번 a:visited, a:hover 참고  -->
	<p style="width:150px; height:30px; border:1px solid lightgrey;display:inline;text-align:right"><a href="/board2/qaModify.khy">
	EDIT</a></p>
	<p style="width:150px; height:30px; border:1px solid lightgrey;display:inline;text-align:right"><a href="/board2/qaModify.khy">
	DELETE</a></p>
	<br/><br/>
	<%-- <% if(("admin").equals(session.getAttribute("id"))) {%> --%>
	<form>
	<fieldset>
		<p text-align:left ><strong> COMMENT</strong></p>
		<p><textarea name="comment" width=300px></textarea></p>
	</fieldset>
	</form>
	<%-- <% } %> --%>
	<p style="height:500px"><br/><br/><br/><br/>
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</p>
	</div>
	
	
</body>
</html>