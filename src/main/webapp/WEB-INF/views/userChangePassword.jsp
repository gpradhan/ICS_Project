<%@ include file="/WEB-INF/views/adminHeader.jsp"%>

<h3>Change Password</h3>
<br>
<c:if test="${!empty resultMessage}">
<h3>${resultMessage}</h3>
</c:if>
<c:if test="${empty resultMessage}">
	<form:form action="updatePassword" method="post"
		modelAttribute="myUser" style="width:300px">
		<form:hidden path="id" value="${myUser.id}" />
		<div class="form-group">
			<label for="oldPassword">Old Password</label>
			<form:input class="form-control" path="oldPassword" id="oldPassword"
				placeholder="Old Password" value="${myUser.oldPassword}" />
		</div>
		<div class="form-group">
			<label for="password">New Password</label>
			<form:password class="form-control" path="password" id="password"
				placeholder="New Password" value="${myUser.password}" />
		</div>
		<div class="form-group">
			<label for="email1">Confirm Password</label>
			<form:password class="form-control" path="confirmPassword"
				id="confirmPassword" placeholder="Confirm Password"
				value="${myUser.confirmPassword}" />
		</div>
		<button type="submit" class="btn btn-primary">Change Password</button>
	</form:form>
</c:if>
<%@ include file="/WEB-INF/views/indexFooter.jsp"%>