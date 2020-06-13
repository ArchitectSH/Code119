<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Home</title>
		<%@ include file="commonLibrary.jsp" %>
		
		<script src="resources/ace-builds-master/src-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>
		
		<script src="resources/javascript/index.js?ver=1" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" href="resources/css/index.css?ver=1">
	</head>
	<body>
		<c:choose>
			<c:when test="${ joinResult!=null && joinResult==true}">
				<script> $(function(){ alert("정상적으로 가입되었습니다. 로그인해주세요."); }); </script>
			</c:when>
			<c:when test="${ joinResult!=null && joinResult==false }">
				<script> $(function(){ alert("이미 가입되어 있는 주소입니다."); }); </script>
			</c:when>
			<c:when test="${ loginResult!=null && loginResult==false }">
				<script> $(function(){ alert("이메일 주소나 비밀번호가 맞지 않습니다"); }); </script>
			</c:when>
		</c:choose>
		<div id="all">
			<table id="allTble">
				<tr>
					<td colspan="2">
						<%@ include file="header.jsp" %>
					</td>
				</tr>
				<tr>
					<td>
						<c:choose>
							<c:when test="${fileName!=null}">
								<input type="text" id="fileNameTxt1" value="${fileName}" />
							</c:when>
							<c:otherwise>
								<input type="text" id="fileNameTxt1" value="Test.java" />
							</c:otherwise>
						</c:choose>
						<Button id="saveCodeBtn" class="btn btn-danger">
							코드 저장
						</Button>
						<br />
						<c:choose>
							<c:when test="${contents!=null}">
<div id="editor">${contents}</div>
							</c:when>
							<c:otherwise>
<div id="editor">class Test{
	public static void main(String[] args){

		System.out.println("ok");
	
	}
}</div>
							</c:otherwise>
						</c:choose>
					</td>
					<td rowspan="2" id="rightPannelTd">
						<c:choose>
							<c:when test="${ email==null }">
								<form class="form-inline" id="loginForm" method="post">
									<div id="emailDiv" class="form-group">
										<label id="emailLabel" for="exampleInputEmail2">Email</label>
										<input type="email" name="email" class="form-control" id="email" placeholder="user_id@example.com">
									</div>
									<br />
									<div id="pwdDiv" class="form-group">
										<label id="pwdLabel" for="exampleInputName2">Password</label>
										<input type="password" name="pwd" class="form-control" id="pwd">
									</div>
									<br />
									<button type="submit" id="loginBtn" class="btn btn-default">Login</button>
									<button type="submit" id="joinBtn" class="btn btn-default">Join</button>
								</form>
							</c:when>
							<c:otherwise>
								<div id="logoutDiv">
									<div id="emailDiv">${email}</div><br /><br />
									<form id="logoutForm" method="post" action="logout.do">
										<Button id="logoutBtn" class="btn btn-default">
											로그아웃
										</Button>
									</form>
								</div>
							</c:otherwise>
						</c:choose>
						<br />
						<form method="get" action="loadFile.do">
							<button type="button" id="manageCodeBtn" class="btn btn-info">
								코드 관리하기
							</button>
						</form>
						<br />
						<form method="get" action="searchFile.do">
							<input type="hidden" name="fileName" value="">
							<button type="button" id="searchCodeBtn" class="btn btn-info">
								코드 구경하기
							</button>
						</form>
						<br />
						<button id="errorBoxBtn" disabled class="btn btn-info">
							에러 창고
						</button>
					</td>
				</tr>
				<tr>
					<td>
						<table id="tble2">
							<tr>
								<td>
								</td>
								<td>
									<textarea id="inputTxt" class="form-control" placeholder="type the input in this area."></textarea>
								</td>
							</tr>
							<tr>
								<td id="runBtnTd" >
									<c:choose>
										<c:when test="${fileName!=null}">
											<input type="text" id="fileNameTxt2" value="${fileName}" disabled>
										</c:when>
										<c:otherwise>
											<input type="text" id="fileNameTxt2" value="Test.java" disabled>
										</c:otherwise>
									</c:choose>
									<br />
									<button type="button" id="runBtn" class="btn btn-success">Run</button>
								</td>
								<td>
									<textarea id="resultTxt" class="form-control" readonly></textarea>
									<br />
									<select id="fromSelect" class="select">
										<option value="English" selected>English</option>
									</select>
									<span class="glyphicon glyphicon-arrow-right"></span>
									<select id="toSelect" class="select"> 
										<option value="Korean" selected>Korean</option>
									</select>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>