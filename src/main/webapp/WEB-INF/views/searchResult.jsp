<%@ include file="/WEB-INF/views/adminHeader.jsp" %>

		<h3>User Profile</h3>
		<c:if test="${empty resultMessage}">
			<p>
			<Table class="table table-striped">
				<tr>
					<td>User Name</td>
					<td>${resultUser.userName}</td>
				</tr>
				<tr>
					<td>Name</td>
					<td>${resultUser.name}</td>
				</tr>
				<tr>
					<td>Address</td>
					<td></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td>${resultUser.mobile}</td>
					</tr>
				<tr>
					<td>Email</td>
					<td>${resultUser.email}</td>
				</tr>
				<tr>
					<td>Gender</td>
					<td></td>
				</tr>
				<tr>
					<td>City</td>
					<td></td>
				</tr>
			</Table>
		</c:if>
		<p>
		<h3>${resultMessage}</h3>
		<p>
		<p>
		<h4>
			<a href="<c:out value='homePage'/>">Home</a>
		</h4>
<%@ include file="/WEB-INF/views/indexFooter.jsp" %>