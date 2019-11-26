<%@ include file="/WEB-INF/views/adminHeader.jsp" %>

		<h3>Write Message</h3>



		<form:form action="sendChatMessage" method="post" enctype="multipart/form-data"
			modelAttribute="chatMessage" style="width:300px">
			<table>
				<tr>
					<td colspan="2"><textarea rows="20" cols="50" disabled="true">${chatmessages}</textarea></td>
				</tr>
				<p>
				<tr>
					<td>${chatMessage.userName}:</td>
					<td><form:input path="messageBody" id="messageBody" 
							placeholder="Type Your Message" /></td>

					<td>
						<button class="btn btn-primary" type="submit">Send</button>
					</td>
				</tr>
				
				<tr>
				<td><form:label path="file">Select a file to upload</form:label></td>
				<td><form:input type="file" name="file" path="file"/></td>
				</tr>

			</table>

		</form:form>
<%@ include file="/WEB-INF/views/indexFooter.jsp" %>