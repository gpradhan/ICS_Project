<%@ include file="/WEB-INF/views/adminHeader.jsp" %>
	<h3>Successfully Created The Room.</h3>

	<div>
		<c:url value="writeMessage" var="writeMessage" />
		<h4>
		<a href="<c:out value='${writeMessage}'/>">Send Group mail to
			invite the person to conference</a>
		</h4>
	</div>
	<div>
		<h4>
			<a href="<c:url value='#'/>">Send Later </a>
		</h4>
<%@ include file="/WEB-INF/views/indexFooter.jsp" %>