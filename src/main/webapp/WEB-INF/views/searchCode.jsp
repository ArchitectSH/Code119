<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Home</title>
		<%@ include file="commonLibrary.jsp" %>
		
		<script src="resources/javascript/searchCode.js?ver=1" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" href="resources/css/searchCode.css?ver=1">
	</head>
	<body>
		<div id="all">
			<table id="allTble">
				<tr>
					<td colspan="2" id="titleTd">
						<%@ include file="header.jsp" %>
					</td>
				</tr>
				<tr>
					<td>
						<form method="get" action="searchFile.do">
							<select id="searchKind">
								<option>fileName</option>
								<option>email</option>
							</select>
							<input type="text" id="searchTxt" name="fileName">
							<button type="button" id="searchCodeBtn" class="btn btn-default">검색</button>
						</form>
						<div id="fileDiv">
							<table id="fileTable" class="table">
								<tr>
									<td id="nameTd"><label>파일명</label></td>
									<td id="createdTd"><label>생성일</label></td>
									<td id="writerTd"><label>작성자</label></td>
								</tr>
								<c:forEach var="file" items="${fileList}" varStatus="i">
									<tr>
										<td><a href="openFile.do?fileName=${file.path}">${file.path}</a></td>
										<td>${file.created}</td>
										<td>
											${file.email}
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</td>
					<td rowspan="2" id="rightPannelTd">
						<div id="logoutDiv">
							<div id="emailDiv">${email}</div><br /><br />
							<form id="logoutForm" method="post" action="logout.do">
								<Button id="logoutBtn" class="btn btn-default">
									로그아웃
								</Button>
							</form>
						</div>
						<br />
						<form method="get" action="home.do">
							<button id="mainBtn" class="btn btn-info">
								메인 화면
							</button>
						</form>
						<br />
						<form method="get" action="loadFile.do">
							<button id="manageCodeBtn" class="btn btn-info">
								코드 관리하기
							</button>
						</form>
						<br />
						<button id="errorBoxBtn" class="btn btn-info" disabled>
							에러 창고
						</button>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>