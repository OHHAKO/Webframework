<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/lecturescss.css">
</head>
<body>
<h1> 2019년도 1학기 신청 수강 목록</h1>

	<table>
		<tr>
			<th>년도</th>
			<th>학기</th>
			<th>과목이름</th>
			<th>구분</th>
			<th>학점</th>
			<th>코드</th>
		</tr>

		<c:forEach var="lecture" items="${newLectureList}">
			<tr>
				<td><c:out value="${lecture.year}"></c:out></td>
				<td><c:out value="${lecture.semester}"></c:out></td>
				<td><c:out value="${lecture.name}"></c:out></td>
				<td><c:out value="${lecture.type}"></c:out></td>
				<td><c:out value="${lecture.credit}"></c:out></td>
				<td><c:out value="${lecture.code}"></c:out></td>

			</tr>
		</c:forEach>
		

	</table>


</body>
</html>