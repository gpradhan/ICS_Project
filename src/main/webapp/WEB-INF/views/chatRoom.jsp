<%@ include file="/WEB-INF/views/adminHeader.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	scrollDownChatMessages();
});
</script>
		<h3>Write Message</h3>

		<form:form action="sendChatMessage" method="post" enctype="multipart/form-data"
			modelAttribute="chatMessage" style="width:50%;height: 100px">
			<table>
				<tr>
					<td colspan="3"  >
					<%--  <textarea rows="20" cols="50" disabled="true">${chatmessages}</textarea>  --%>
					<div style="background-color: white;height:300px;width:500px; overflow-y: auto" draggable="true" id="messages">
					<c:forEach items="${chatmessages}" var="message">
					<p>${message}<br/><br/>
					</c:forEach>
					</div> 
					</td>
				</tr>
			<tr><td><p/><p></td></tr>
				<tr>
					<td>${chatMessage.userName}:</td>
					<td><form:input path="messageBody" id="messageBody" 
							placeholder="Type Your Message" /></td>
					<td>
						<button class="btn btn-primary" type="submit">Send</button>
					</td>
				</tr>
				<tr><td><p/><p></td></tr>
				<tr>
				<td colspan="2"><form:input type="file" name="file" path="file"/></td>
				</tr>

			</table>

		</form:form>
<%@ include file="/WEB-INF/views/indexFooter.jsp" %>