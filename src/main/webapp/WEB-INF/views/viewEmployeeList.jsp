<%@ include file="/WEB-INF/views/adminHeader.jsp" %>
  <div style="top:20%;position:fixed;width :100%" >
		<h3  align="center"  >Employee List</h3>
			</div>

	<div style="top:30%;position:fixed;width :100%">

			<div style="padding-left:5%;padding-right:5%; width: 90%">
		<c:if test="${!empty employeeList}">
			<table class="table table-bordered">
				<thead>
					<th>EmpId</th>
					<th>Key</th>
					<th>Account</th>
					<th>DOJ</th>
					<th>User Id</th>
				</thead>

				<tbody>

					<c:forEach items="${employeeList}" var="employee">
						<tr>
							<%-- <td><%=++siNo%></td> --%>
							<td>${employee.employeeId}</td>
							<td>${employee.key}</td>
							<td>${employee.activate}</td>
							<td>${employee.dateOfJoining}</td>
							<td>${employee.userName}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</c:if>
		
</div>
</div>
<%@ include file="/WEB-INF/views/indexFooter.jsp" %>