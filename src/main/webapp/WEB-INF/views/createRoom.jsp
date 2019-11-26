<%@ include file="/WEB-INF/views/adminHeader.jsp"%>

<h3>Create Room</h3>

<form:form action="createChatRoom" method="post"
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
		<td colspan="2"><p> </td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button class="btn btn-primary" type="submit">Create</button>
			</td>
		</tr>

	</table>
</form:form>

<%@ include file="/WEB-INF/views/indexFooter.jsp"%>