<%@ include file="/WEB-INF/views/adminHeader.jsp" %>
		<h3>Offline Checking</h3>
		<div>
			<a href="<c:url value='writeMessage'/>"><button
					class="btn btn-primary">Write Message</button></a>
		</div>
		<p>
		<div>
			<a href="<c:url value='readMessage'/>"><button
					class="btn btn-primary">Read Message</button></a>
		</div>
		<p>
		<%--<div><h4>Read()</h4></div>
		<div><h4>Unread()</h4></div>
		 --%>
<%@ include file="/WEB-INF/views/indexFooter.jsp" %>