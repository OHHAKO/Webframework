<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		<a href="${pageContext.request.contextPath}/lectures"> 학기별 이수 학점 조회</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/registerlecture"> 2019년 1학기 수강 신청 </a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/registeredlecture"> 2019년 1학기 신청 수강 조회 </a>
	</p>
	
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>

	<form id="logout" action="<c:url value="/logout" />" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
 
 
</body>
</html>
