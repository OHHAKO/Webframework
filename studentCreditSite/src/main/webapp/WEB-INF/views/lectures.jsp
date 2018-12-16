<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lecture list</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/lecturescss.css">
</head>
<body>
	<h1>* LECTURE LIST *</h1>
	<h2> 학년/학기별 이수 총 학점  </h2>
	
	<table>
		<tr>
			<th>년도</th>
			<th>학기</th>
			<th>이수 학점</th>
			<th>상세보기</th>
		</tr>
		
	
		<c:forEach var="lecture" items="${lectureList}">
			<tr>
				<td> <c:out value="${lecture.year}"></c:out> </td>
				<td> <c:out value="${lecture.semester}"></c:out> </td>
				<td> <c:out value="${lecture.credit}"></c:out> </td>
				<!--<td> <a>상세보기</a></td>-->
				<td> <a href="${pageContext.request.contextPath}/selectedlecture?lecId="+"${lecture.year}"+"-"+"${lecture.semester}"> 상세보기 </a> </td>
				
			</tr>
		</c:forEach>
	
	</table>
</body>
</html>