<%@ include file="/WEB-INF/views/adminHeader.jsp"%>

<h3>Write Message</h3>

<form:form action="saveMessage" method="post" modelAttribute="message"
	style="width:300px">

	<table>
		<tr>
			<td>To</td>
			<td><form:select path="toUser">
					<form:option value="0" label="Select" />
					<form:options items="${toUserList}" itemValue="id" />
				</form:select></td>
		</tr>
		<tr>
			<td>Subject</td>
			<td><form:input path="subject" id="subject"
					placeholder="Subject" /></td>
		</tr>
		<tr>
			<td>Subject</td>
			<td><form:textarea cols="80" rows="15" path="messageBody"
					id="messageBody" placeholder="Message Body" /></td>
		</tr>

	</table>
<div><p></div>
	<button class="btn btn-primary" type="submit">Send</button>&nbsp;&nbsp;
	<button class="btn btn-primary" type="reset">Reset</button>
</form:form>

<%@ include file="/WEB-INF/views/indexFooter.jsp"%>