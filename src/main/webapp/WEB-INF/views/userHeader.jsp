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
<title>Intranet Communication System</title>
</head>
<body>
	<div class="container-fluid">
		<div class="item active">
			<img src='<c:url value="/resources/images/ICS_banner.jpg"/>'
				alt="baby 1">
			<hr style="width: 1000px; height: 10px; background-color: #CCA01C"
				align="left">

		</div>
		<%@ include file="/WEB-INF/views/navUser.jsp"%>
		<div
			style="padding-left: 300px; z-index =1; position: absolute; float: top">