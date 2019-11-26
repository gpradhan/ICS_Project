<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/commonCssAndJS.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Office Communicator</title>
</head>
<body style="background-color:#00FFFF;">
	<div class="container-fluid">
		<div>
			<img src='<c:url value="/resources/images/ICS_banner.jpg"/>'
				alt="banner1" id="banner1" />
		</div>
		<div style="top: 200px; position: Fixed; padding-left: 100px; z-index=100">
			<%@ include file="/WEB-INF/views/leftNavBar.jsp"%>
		</div>
		<div
			style=" top:200px;left:350px; position:absolute; width:70%">