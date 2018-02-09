<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/javaScript/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.min.js"></script>


<title>${pageContext.request.contextPath}</title>
</head>

<body>
	<!-- 삭제팝업(모달)창 -->
	<div class="modal fade" id="del-pop">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title">방명록삭제</h4>
				</div>
				<div class="modal-body">
					<input type="text" name="modalNo" value="" id="modalNo"> <br>	
					<label>비밀번호</label>
					<input type="password" name="modalPassword" id="modalPassword"><br>	
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-danger" id="btn_del">삭제</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->


	<!-- 글 작성 테이블 -->
	<div id="container">
		<!-- header -->
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>

		<!-- /navigation -->
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>

		<div id="wrapper">
			<div id="content">
				<div id="guestbook">
						<table>
							<tr>
								<td>이름</td>
								<td><input type="text" name="name" /></td>
								<td>비밀번호</td>
								<td><input type="password" name="password" /></td>
							</tr>
							<tr>
								<td colspan=4><textarea name="content" id="content"></textarea></td>
							</tr>
							<tr>
								<td colspan=4 align=right><input id="write" type="submit" VALUE=" 확인 " /></td>
							</tr>
						</table>
										
					<ul id="listArea">

					</ul>
					
					<input id="btnNext" type="button" value="다음글 5개 가져오기">
					
				</div>
				<!-- /guestbook -->
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
var page = 1;

$(document).ready(function(){
	fetchList();
});

$("#btnNext").on("click", function(){
	page = page+1;
	console.log(page);
	
	fetchList();
});

function fetchList(){
	$.ajax({
		url : "${pageContext.request.contextPath }/gb/api/list",		
		type : "post",
		data : {page : page},
					
		dataType : "json",
		success : function(glist){ 
			console.log(glist);
			
			for(var i =0; i<glist.length; i++){
				render(glist[i], "down");	
			}	
		},
		error : function(XHR, status, error) { 	
			console.error(status + " : " + error);
		}
	});
};
		
function render(gvo, updown){ //함수에 정의하고 위에서 불러줄 것. + 변수선언안해도됨, 이전에는 String updown이라고 해줬음
	//list에서 짠 foreach문처럼 보일 수 있게 문자열로 보여준 것. 
	var str="";
	str += "<li id= 'liNo"+ gvo.no+"' >";
	str += "	<table>";
	str += "		<tr>";
	str += "			<td>["+ gvo.no+ "]</td>";
	str += "			<td>" + gvo.name + "</td>";
	str += "			<td>" + gvo.regDate +"</td>";
	str += "			<td><input class='delbtn' data-no='"+ gvo.no +"' type='button' value = '삭제하기'></td>";		
	str += "		</tr>";
	str += "		<tr>";
	str += "			<td colspan=4>" + gvo.content +"</td>";
	str += "		</tr>";
	str += "	</table>";
	str += "	<br>";
	str += "</li>"
	
	if(updown == "up"){
		$("#listArea").prepend(str);
	}else if(updown =="down"){
		$("#listArea").append(str);	
	}else {
		console.log("updown오류");
	}
}

///////////////////////////////////////////////////////

$("#write").on("click", function(){
	var name = $("[name=name]").val();
	var password = $("[name=password]").val();
	var content =$("[name=content]").val();

	 console.log(name);
	 console.log(password);
	 console.log(content);
	var gvo = { //자바스크립트용 객체만든 것 위에있는 변수 담은 것.
			name : name,
			password : password,
			content : content
	};
	
	$.ajax({
		url : "${pageContext.request.contextPath }/gb/api/write",		
		type : "post",
		contentType : "application/json",
		data : JSON.stringify(gvo),
					
		
		dataType : "json",
		success : function(gvo){ 
			render(gvo,"up");
		},
		error : function(XHR, status, error) { 	
			console.error(status + " : " + error);
		}
	});
	
	$("[name=name]").val("");	
	$("[name=password]").val("");	
	$("[name=content]").val("");	
});

///////////////////////////////////////////////////////////

$("ul").on("click",".delbtn", function(){ //ul에 이벤트 걸어놓고 .delbtn에게 일 시킨 것.
	var $this = $(this);
	var no = $this.data("no");
	console.log(no);
	$("#modalNo").val(no); //modalNo의 value값에 no값 저장
	$("#del-pop").modal();	
});

$("#btn_del").on("click", function(){
	var no = $("#modalNo").val();
	var password = $("#modalPassword").val();
	
	$.ajax({
		url : "${pageContext.request.contextPath }/gb/api/delete",		
		type : "post",
		data : {no : no , password : password},
					
		dataType : "json",
		success : function(result){ 
			console.log(result)
			if(result==1){
				console.log("DB에서 삭제함");
				$("#liNo"+no).remove(); //화면에서도 삭제해준것-> .remove()로 선택자로 지정된 태그 삭제해줄 수 있음.
				$("#del-pop").modal("hide");
				$("#modalPassword").val(""); //패스워드값 안들어가있게 초기화해준 것
			}else{
				console.log("삭제실패");
				$("#modalPassword").val(""); //패스워드값 안들어가있게 초기화해준 것
			}
		},
		error : function(XHR, status, error) { 	
			console.error(status + " : " + error);
		}
	});
	
});


</script>
</html>