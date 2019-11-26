<%@ include file="/WEB-INF/views/adminHeader.jsp" %>
		<h3>Offline Reading</h3>

		<table>
			<tr>
				<c:url value="/writeMessage" var="compose" />
				<a href="<c:out value='${compose}'/>">
					<button class="btn btn-primary" type="submit" name="compose">Compose</button>
				</a>
				<button class="btn btn-primary" type="submit" name="readMore">Read
					More</button>
				<c:url value="/deleteMessage?id=${message.id}" var="delete" />
				<a href="<c:out value='${delete}'/>">
					<button class="btn btn-primary" name="delete">Delete</button>
				</a>
			</tr>

			<tr>
				<td>From: "${message.fromUserName}"</td>
			</tr>
			<p>
			<tr>
				<td>Subject:</td>
				<td>"${message.subject}"</td>
			</tr>
			<p>
			<tr>
				<td>Message:</td>
				<td>"${message.messageBody}"</td>
			</tr>
			<p>
			<tr>
				<td>Time:</td>
				<td>"${message.time}"</td>
			</tr>


		</table>
<%@ include file="/WEB-INF/views/indexFooter.jsp" %>