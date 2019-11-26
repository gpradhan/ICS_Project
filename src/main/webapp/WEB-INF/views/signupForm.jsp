<%@ include file="/WEB-INF/views/indexHeader.jsp"%>

<h3>Register Employee</h3>

<c:if test="${!empty resultMessage}">
	<h3>${resultMessage}</h3>
</c:if>

<c:if test="${empty resultMessage}">
<form:form action="signupEmployee" method="post"
	modelAttribute="employee" style="width:300px">

	<table>

		<tr>
			<td>Employee Id</td>
			<td><form:input path="employeeId" id="employeeId"
					placeholder="Employee Id" /></td>
		</tr>
		<tr>
			<td>Employee Key</td>
			<td><form:input path="key" id="key" placeholder="Employee Key" /></td>
		</tr>
		<tr>
			<td>User Name</td>
			<td><form:input path="userName" id="userName"
					placeholder="User Name" /></td>
		</tr>

		<tr>
			<td>
				<button class="btn btn-primary" type="submit">SignUp</button>
			</td>
			<td>
				<button class="btn btn-primary" type="reset">Reset</button>
			</td>
		</tr>

	</table>
</form:form>
</c:if>


<%@ include file="/WEB-INF/views/indexFooter.jsp"%>