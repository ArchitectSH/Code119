<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Home</title>
		<%@ include file="commonLibrary.jsp" %>
		
		<script src="resources/javascript/manageCode.js?ver=1" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" href="resources/css/manageCode.css?ver=1">
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
						<div id="fileDiv">
							<table id="fileTable" class="table">
								<tr>
									<td id="nameTd"><label>파일명</label></td>
									<td id="createdTd"><label>생성일</label></td>
									<td id="hideTd"><label>공개</label></td>
									<td></td>
								</tr>
								<c:forEach var="file" items="${fileList}" varStatus="i">
									<tr>
										<td><a href="openFile.do?fileName=${file.path}">${file.path}</a></td>
										<td>${file.created}</td>
										<td>
											<c:choose>
												<c:when test="${file.hide}">
													<button id="hideBtn" class="btn btn-info">비공개</button>
												</c:when>
												<c:otherwise>
													<button id="hideBtn" class="btn btn-info">공개</button>
												</c:otherwise>
											</c:choose>
										</td>
										<td>
											<button id="deleteBtn" class="btn btn-danger">삭제</button>
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
							<button id="mainBtn" class="btn btn-info">메인 화면</button>
						</form>
						<br />
						<form method="get" action="searchFile.do">
							<input type="hidden" name="fileName" value="">
							<button id="searchCodeBtn" class="btn btn-info">코드 구경하기</button>
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