<%@ include file="/WEB-INF/views/adminHeader.jsp"%>

<h3>Login Room</h3>
<p>
<h4>${error}</h4>
<form:form action="loginChatRoom" method="post"
	modelAttribute="chatRoom" style="width:300px">

	<table>
		<tr>
			<td>Room Name</td>
			<td><form:input path="roomName" id="roomName"
					placeholder="Room Name" /></td>
		</tr>
		<tr>
			<td>Room Key</td>
			<td><form:input path="key" id="key" placeholder="Room Key" /></td>
		</tr>
		<tr>
			<td colspan="2"><p></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button class="btn btn-primary" type="submit">Login</button>
			</td>
		</tr>

	</table>
</form:form>
<%@ include file="/WEB-INF/views/indexFooter.jsp"%>