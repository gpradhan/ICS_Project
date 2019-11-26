<%@ include file="/WEB-INF/views/adminHeader.jsp" %>

		<h3>My Profile</h3>

		<form:form action="updateProfile" method="post"
			modelAttribute="myUser" style="width:300px">
			<form:hidden path="id" value="${myUser.id}" />
			<div class="form-group">
				<label for="userName">User Id</label>
				<form:input class="form-control" path="userName" id="userName"
					placeholder="Name" value="${myUser.userName}" readonly="true"/>
			</div>
			<div class="form-group">
				<label for="name1">Name</label>
				<form:input class="form-control" path="name" id="name1"
					placeholder="Name" value="${myUser.name}" />
			</div>
			<div class="form-group">
				<label for="email1">Email address</label>
				<form:input class="form-control" path="email" id="email1"
					placeholder="Email" value="${myUser.email}" />
			</div>
			<div class="form-group">
				<label for="mobile1">Mobile Number</label>
				<form:input class="form-control" path="mobile" id="mobile1"
					placeholder="Mobile" value="${myUser.mobile}" />
			</div>
			<button type="submit" class="btn btn-primary">Update</button>
		</form:form>
<%@ include file="/WEB-INF/views/indexFooter.jsp" %>