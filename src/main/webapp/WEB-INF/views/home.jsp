<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring5 MVC Hibernate Demo</title>

<%@ include file="/WEB-INF/views/commonCssAndJS.jsp" %>
</head>

<body>
<div><h2>${loginSuccessMessage} </h2></div>
<div><c:url value="/books/viewAllBooks" var="viewAllBooks1" /><a href="<c:out value='${viewAllBooks1}'/>">View All Books</a></div>
<div><c:url value="/books/addBook" var="addBook" /><a href="<c:out value='${addBook}'/>">Add Book</a></div>
<div><c:url value="/books/issueBook" var="issueBook" /><a href="<c:out value='${issueBook}'/>">Issue Book</a></div>
<div><c:url value="/books/viewAllIssuedBooks" var="viewAllIssuedBooks" /><a href="<c:out value='${viewAllIssuedBooks}'/>">View All Issued Books</a></div>
<div><c:url value="/books/returnBook" var="returnBook" /><a href="<c:out value='${returnBook}'/>">Return Book</a></div>
<div><c:url value="logout" var="logout" /><a href="<c:out value='${logout}'/>">logout</a></div>
</body>
</html>