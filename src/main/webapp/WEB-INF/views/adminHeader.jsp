<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" session="true"%>
<%@ include file="/WEB-INF/views/commonCssAndJS.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Office Communicator</title>
</head>
<body style="background-color: #00FFFF;">
	<div class="container-fluid">

		<img src='<c:url value="/resources/images/ICS_banner.jpg"/>'
			alt="banner1" id="banner1">
		<div align="right" style="position: fixed; width: 98%">
			<h4 style="color: yellow;">Welcome ${myUser.userName}</h4>
			<h5 align="center"
				style="color: yellow; background-color: #ffcccc; width: 50px;">
				<a href="<c:out value='logout'/>">Logout</a>
			</h5>
		</div>
		<div style="top: 10%; position: fixed; width: 100%">
			<c:choose>
				<c:when test="${myUser.userName=='admin'}">
					<%@ include file="/WEB-INF/views/navadmin.jsp"%>
				</c:when>
				<c:otherwise>
					<%@ include file="/WEB-INF/views/navUser.jsp"%>
				</c:otherwise>
			</c:choose>
		</div>
		<!-- <div style="padding-left: 300px; z-index=1; position: absolute; float: top"  > -->

		<div align="center" style="top: 25%; position: relative; width: 100%;">