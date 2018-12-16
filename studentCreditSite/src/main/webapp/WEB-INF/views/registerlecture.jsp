<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	<h1>2019년 1학기 수강신청</h1>


	<form method="post"
		action="${pageContext.request.contextPath}/dolecturecreate">

		<table class="formtable">

			<tr>
				<td class="label">Year :</td>
				<td><input class="control" type="text" name="year" value="2019"></td>
			</tr>
			<tr>
				<td class="label">Name :</td>
				<td><input class="control" type="text" name="semester" value="1"></td>
			</tr>
			<tr>
				<td class="label">Name :</td>
				<td><input class="control" type="text" name="name"></td>
			</tr>
			<tr>
				<td class="label">Code :</td>
				<td><input class="control" type="text" name="code"></td>
			</tr>
			<tr>
				<td class="label">Type :</td>
				<td><input class="control" type="text" name="type"></td>
			</tr>
			<tr>
				<td class="label">Credit :</td>
				<td><input class="control" type="text" name="credit"></td>
			</tr>

			<tr>
				<td class="label"></td>
				<td><input class="control" type="submit" value="신청하기"></td>
			</tr>

		</table>
	</form>
</body>
</html>