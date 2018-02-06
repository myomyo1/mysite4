<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/main.css" rel="stylesheet"
	type="text/css">
<title>${pageContext.request.contextPath}</title>
</head>
<body>
	<div id="container">
		<!-- header -->
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>

		<!-- /navigation -->
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>

		<div id="wrapper">
			<div id="content">
				<div id="site-introduction">
					<img style="width: 500px" id="profile" src="${pageContext.request.contextPath}/assets/images/profile2.jpg">
					<h2>
						멍멍! 멍!!멍멍멍!! 왈!!! 왈왈!! <br />
					</h2>
					<p>	
						왈왈 엄마가 여기는 웹 프로그램밍 실습과제 예제 사이트래요!!왈!! <br>
						JAVA 수업 + 데이터베이스 수업 + 웹프로그래밍 수업 사이ㅌ으으 멍멍!!!!!!<br>
															
						<br> <a href="${pageContext.request.contextPath}/gb/list">방명록</a>에 글 남기기 <br>
					</p>
				</div>
			</div>
		</div>

		<!-- /footer -->
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>

	</div>
</body>
</html>