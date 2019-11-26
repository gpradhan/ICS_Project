<%@ include file="/WEB-INF/views/adminHeader.jsp"%>

<h3>View Status</h3>
<h4>${resultMessage}</h4>
<form:form action="getUserStatus" method="post" modelAttribute="myUser"
	style="width:300px">

	<div class="form-group">
		<label for="userName">User Id</label>
		<form:input class="form-control" path="userName" id="userName"
			placeholder="Enter UserId" />
	</div>
	<button type="submit" class="btn btn-primary">View Status</button>
</form:form>
<%@ include file="/WEB-INF/views/indexFooter.jsp"%></html>