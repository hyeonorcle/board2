<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	
<title>Insert title here</title>
</head>
<body style="text-align:center">
	<br/><br/>
	<h3>Q & A</h3>
	<div style="position:absolute;width:1000px; height:500px; left:50%; top:50%; margin:-250px 0 0 -500px;">
	<table style="width:1000px;text-align:center;">
		<tr style="border-bottom: 1px solid lightgrey; border-top:1px solid lightgrey; height:50px" >
			<td style="width:150px">No</td>
			<td>Subject</td>
			<td style="width:150px">Date</td>
			<td style="width:150px">Name</td>
		</tr>
		<c:forEach  var="l" items="${list}">
		<tr style="border-bottom:1px solid lightgrey">
			<td style="width:150px">${l.qa_id}</td>
			<td><a href="qaConCommand.khy?qa_id=${l.qa_id}" name="subject">${l.qa_sub}</a>
			<c:if test="${l.qa_count>0}">[답변 완료]</c:if></td>
			<td style="width:150px">${l.qa_date}</td>
			<td style="width:150px">${l.qa_name}</td> 
		</tr>				
		</c:forEach>
		<tr style="height:50px"><td colspan="4"></td></tr>
		<tr style="height:50px">
		<td colspan="4" style="text-align:left">
		<form action= " " >&nbsp&nbsp
		<input type="text" name="search"><input type="submit" value="search"></form>
		</tr>		
	</table>
	</div>
	
</body>
</html>