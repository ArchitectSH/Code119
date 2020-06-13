<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<script>
	$(function(){
    	$('#manageCodeBtn').click(
   			function(){
   				$this=$(this);
    			<c:choose>
    				<c:when test="${email==null}">
    					alert('로그인 해주세요.');
    				</c:when>
    				<c:otherwise>
    				$this.parents('form').submit();
    				</c:otherwise>
    			</c:choose>
		});
 	});
	
	$(function(){
    	$('#searchCodeBtn').click(
   			function(){
   				$this=$(this);
    			<c:choose>
    				<c:when test="${email==null}">
    					alert('로그인 해주세요.');
    				</c:when>
    				<c:otherwise>
    				$this.parents('form').submit();
    				</c:otherwise>
    			</c:choose>
		});
 	});
</script>
<link rel="stylesheet" href="resources/css/header.css?ver=1">


<div id="titleDiv">
	<a href="home.do"><img src="resources/images/title.jpg"></a>
	<br />
</div>
<hr />