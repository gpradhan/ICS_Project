<%@ include file="/WEB-INF/views/adminHeader.jsp" %>

		<h3>View Profile</h3>

		<form:form action="searchUser" method="post" modelAttribute="myUser"
			style="width:300px">
			<form:hidden path="id" value="${myUser.id}" />
			<div class="form-group">
				<label for="userName">User Id</label>
				<form:input class="form-control" path="userName" id="userName"
					placeholder="Enter UserId" />
			</div>
			<button type="submit" class="btn btn-primary">Get Profile</button>
		</form:form>
<%@ include file="/WEB-INF/views/indexFooter.jsp" %>