<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet"
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
				<div id="guestbook" class="delete-form">

					<form action="${pageContext.request.contextPath}/gb/delete" method="get">

						<label>비밀번호</label> 
						<input type="password" name="password" value=""> 
						
						<input type="hidden" name="no" value="${param.no}"> 
						<input type="submit" value="확인">

					</form>
					<a href="${pageContext.request.contextPath}/gb/list">방명록 리스트</a>

				</div>
			</div>
			<!-- /content -->
		</div>
		<!-- /wrapper -->

		<!-- /footer -->
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	</div>
	<!-- /footer -->

	</div>
	<!-- /container -->

</body>
</html>
