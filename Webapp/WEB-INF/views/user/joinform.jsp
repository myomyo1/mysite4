<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/javaScript/jquery/jquery-1.12.4.js"></script>

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
				<div id="user">

					<form id="join-form" name="joinForm" method="post"
						action="${pageContext.request.contextPath}/user/join">
					
						<label class="block-label" for="name">이름</label>
						<input id="name" name="name" type="text" value="">
						
						<label class="block-label" for="email">이메일</label> 
						<input id="email" name="email" type="text" value=""> 
						<input id="emailCheckBtn" type="button" value="id 중복체크"> 
						<div id="checkMsg"></div> 
						
						<label class="block-label">패스워드</label>
						<input name="password" type="password" value="">

						<fieldset>
							<legend>성별</legend>
							<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
							<label>남</label> <input type="radio" name="gender" value="male">
						</fieldset>

						<fieldset>
							<legend>약관동의</legend>
							<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
							<label>서비스 약관에 동의합니다.</label>
						</fieldset>

						<input type="submit" value="가입하기">

					</form>

				</div>
				<!-- /user -->
			</div>
			<!-- /content -->
		</div>
		<!-- /wrapper -->

		<!-- /footer -->
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>

	</div>
	<!-- /container -->

</body>

<script type="text/javascript">
	$("#emailCheckBtn").on("click", function(){ //소괄호 안에는 파라미터 값 들어갈 수 있음
		var email = $("#email").val(); //input 박스는 val(=value)로 읽는다. //자바스크립트용 email 변수 만들고 #email.val(); 사용자가 준 값 읽어오는 것.
		var password;
		//console.log(email); //콘솔에 먼저 확인하기 위함
		var uservo = { //자바스크립트용 객체만든 것 위에있는 변수 담은 것.
				email : email,
				password : password
		}
		//가져온코드
		$.ajax({
			
//데이터 보내는코드 ->컨트롤러로 			
			url : "${pageContext.request.contextPath }/user/api/emailcheck",		
			type : "post",
			contentType : "application/json", //보낼때 제이슨방식으로 보내겠다는 뜻
			//data : {email : email}, /* 키값, 데이터값 써준 것. header이용해서 보내는 것 */ 
			data : JSON.stringify(uservo), //제이슨 방식으로 보내는 것이므로 contentType살려줘야함. body에 담아 보내야하는것. 위에 uservo객체 만들어줘야함
			
//데이터 가져오는코드			
			dataType : "json",
			success : function(result){ 	/*성공시 처리해야될 코드 작성*/
				console.log(result);
				if(result==true){
					$("#checkMsg").text("사용할 수 있는 이메일입니다.");
				}else{
					$("#checkMsg").text("이미 사용중인 이메일입니다.");
				}
			},
			error : function(XHR, status, error) { 	/*실패시(이메일조회가안되는경우가 아니라 통신장애) 처리해야될 코드 작성*/
				console.error(status + " : " + error);
			}
		});



	});




</script>


</html>