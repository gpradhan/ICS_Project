<%@ include file="/WEB-INF/views/adminHeader.jsp"%>
<c:if test="${empty message}">
	<h3>Ban Employee</h3>

	<form:form action="banUser" method="post" modelAttribute="employee"
		style="width:300px" align="center">

		<table>
			<tr>
				<td>Enter UserId</td>
				<td><form:input path="userName" id="userName"
						placeholder="Enter UserId" /></td>
			</tr>

			<tr><td colspan="2"><p></td></tr>
			<tr>
				<td colspan="2" align="center">
					<button class="btn btn-danger" type="submit">Ban User</button>
				</td>
			</tr>

		</table>
	</form:form>
</c:if>

<h3>${message}</h3>
<%@ include file="/WEB-INF/views/indexFooter.jsp"%>