<%@ include file="/WEB-INF/views/indexHeader.jsp"%>

<h3>Register Employee Details</h3>

<form:form action="registerEmployee" method="post"
	modelAttribute="employee" style="width:300px">

	<table>

		<tr>
			<td>Password</td>
			<td><form:password path="password" id="password"
					placeholder="Password" /></td>
		</tr>
		<tr>
			<td>Confirm Password</td>
			<td><form:password path="confirmPassword" id="confirmPassword"
					placeholder="Confirm Password" /></td>
		</tr>

		<tr>
			<td>Name</td>
			<td><form:input path="name" id="name" placeholder="Name" /></td>
		</tr>

		<tr>
			<td>Hint Question</td>
			<td><form:input path="hintQuestion" id="hintQuestion" style="width:150%" readonly="true"/></td>
		</tr>
		<tr>
			<td>Answer</td>
			<td><form:input path="answer" id="answer" placeholder="Answer" /></td>
		</tr>
		<tr>
			<td>
				<p>
			</td>
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
	<form:hidden path="id" id="id" value="${employee.id}"/>
	<form:hidden path="userName" id="userName" value="${employee.userName}"/>
	<form:hidden path="employeeId" id="employeeId" value="${employee.employeeId}"/>
	<form:hidden path="key" id="key" value="${employee.key}"/>
</form:form>


<%@ include file="/WEB-INF/views/indexFooter.jsp"%>