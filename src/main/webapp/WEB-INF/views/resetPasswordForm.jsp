<%@page session="false" %>
<%@ include file="/WEB-INF/views/indexHeader.jsp"%>

<h3>Change Password</h3>
<br>
<c:if test="${!empty resultMessage}">
	<h3 style="color: blue">${resultMessage}</h3>
</c:if>
<%-- <c:if test="${empty resultMessage}"> --%>

	<form:form action="resetPassword" method="post"
		modelAttribute="myUser" style="width:300px">
		<div class="form-group">
			<label for="userName">User Name</label>
			<form:input class="form-control" path="userName" id="userName"
				placeholder="User Name" />
		</div>
		<div class="form-group">
			<label for="oldPassword">Old Password</label>
			<form:password class="form-control" path="oldPassword" id="oldPassword"
				placeholder="Old Password"/>
		</div>
		<div class="form-group">
			<label for="password">New Password</label>
			<form:password class="form-control" path="password" id="password"
				placeholder="New Password" />
		</div>
		<div class="form-group">
			<label for="confirmPassword">Confirm Password</label>
			<form:password class="form-control" path="confirmPassword"
				id="confirmPassword" placeholder="Confirm Password" />
		</div>
		<div class="form-group">
			<label for="hintQuestion">Hint Question</label>
			<form:input class="form-control" path="confirmPassword" disabled="true"
				id="hintQuestion" placeholder="hintQuestion" value="${myUser.hintQuestion}"/>
		</div>
		<div class="form-group">
			<label for="answer">Answer</label>
			<form:input class="form-control" path="answer"
				id="answer" placeholder="Answer"/>
		</div>
		<button type="submit" class="btn btn-primary">Reset Password</button>
	</form:form>
<%-- </c:if> --%>
<%@ include file="/WEB-INF/views/indexFooter.jsp"%>