<%@ include file="/WEB-INF/views/adminHeader.jsp" %>

		<c:if test="${empty employeeAddedMessage}">
			<h3>Add Employee</h3>

			<form:form action="saveEmployee" method="post"
				modelAttribute="employee" style="width:300px">

				<table>

					<tr>
						<td>Employee Id</td>
						<td><form:input path="employeeId" value="${employee.employeeId}" disabled="true"/>
						<form:hidden path="employeeId" id="employeeId" value="${employee.employeeId}"/>
						</td>
					</tr>
					<tr>
						<td>Employee Key</td>
						<td><form:input path="key" id="key"
								placeholder="Employee Key" /></td>
					</tr>
					<tr>
						<td>User Name</td>
						<td><form:input path="userName" id="userName"
								placeholder="User Name" /></td>
					</tr>
					<tr>
						<td>Date Of Joining</td>
						<td><form:input path="dateOfJoining" id="dateOfJoining"
								placeholder="DOJ(DD/MM/YYYY)" /></td>
					</tr>

					<tr>
						<td>
							<button class="btn btn-primary" type="submit">Add Emp</button>
						</td>
					</tr>

				</table>
			</form:form>
		</c:if>
		<h3>${employeeAddedMessage}</h3>
<%@ include file="/WEB-INF/views/indexFooter.jsp" %>