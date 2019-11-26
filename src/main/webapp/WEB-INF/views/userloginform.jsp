<%@ include file="/WEB-INF/views/indexHeader.jsp"%>
	<h2>${error}</h2>
	<h3>User Login</h3>
	<form:form action="userLogin" method="post" modelAttribute="myUser"
		style="width:300px">
		<div class="form-group">
			<label for="userName">User Id</label>
			<form:input class="form-control" path="userName" id="userName"
				placeholder="User Id" />
		</div>
		<div class="form-group">
			<label for="password1">Password</label>
			<form:password class="form-control" path="password" id="password1"
				placeholder="Password" />
		</div>
		<button type="submit" class="btn btn-primary">Login</button>
	</form:form>
	<div>
		<a href='<c:url value="signupForm"/>'>Signup New User</a> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		<a href='<c:url value="forgotPassword"/>'>Forgot Password</a>
	</div>

<%@ include file="/WEB-INF/views/indexFooter.jsp"%>
