<%@ include file="/WEB-INF/views/adminHeader.jsp"%>

<h3>User Status</h3>
<p>
<Table class="table table-striped" style="border: 2px">
	<tr>
		<td>User Name</td>
		<td>${resultUser.userName}</td>
	<tr>
	<tr>
		<td>Status</td>
		<td>${resultUser.status}</td>
	<tr>
		<c:if test="${resultUser.status=='Online'}">
			<tr>
				<td>Logged Room</td>
				<td></td>
			<tr>
			<tr>
				<td>Login Time</td>
				<td>${loginTime}</td>
			<tr>
			<tr>
				<td>Login Date</td>
				<td>${loginDate}</td>
			<tr>
		</c:if>
</Table>
<p>
<p>
<p>
<h4>
	<a href="<c:out value='homePage'/>">Home</a>
</h4>
<%@ include file="/WEB-INF/views/indexFooter.jsp"%>