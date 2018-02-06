<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">

		<!-- header -->
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>

		<!-- /navigation -->
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>

		<div id="content">
			<div id="board">
				<form id="search_form" action="${pageContext.request.contextPath}/board/searchKwd" method="post">
					<input type="text" id="kwd" name="kwd" value=""> 
					<input	type="submit" value="찾기">
				</form>
				
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${blist}" var="b" varStatus="status">
						<c:choose>
							<c:when test="${ !empty authUser && authUser.name eq b.name}">
								<tr>
									<td>${b.no}</td>
									<td><a href="${pageContext.request.contextPath}/board/view?no=${b.no }">${b.title }</a></td>
									<td>${b.name }</td>
									<td>${b.hit }</td>
									<td>${b.regDate }</td>
									<td><p align="center"><a href="${pageContext.request.contextPath}/board/delete?no=${b.no }" class="del"> 삭제</a></p></td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td>${b.no }</td>
									<td><a href="${pageContext.request.contextPath}/board/view?no=${b.no }">${b.title }</a></td>
									<td>${b.name }</td>
									<td>${b.hit }</td>
									<td>${b.regDate}</td>
									<td></td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</table>

				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						<li><a href="">1</a></li>
						<li><a href="">2</a></li>
						<li class="selected">3</li>
						<li><a href="">4</a></li>
						<li>5</li>
						<li><a href="">▶</a></li>
					</ul>
				</div>
				<c:choose>
					<c:when test="${empty authUser }">
						<p align="center">로그인 후 사용해주세요</p>
					</c:when>
					<c:otherwise>
						<div class="bottom">
							<a href="${pageContext.request.contextPath}/board/writeform" id="new-book">글쓰기</a>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>

		<!-- /footer -->
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	</div>
	<!-- /footer -->

	</div>
</body>
</html>