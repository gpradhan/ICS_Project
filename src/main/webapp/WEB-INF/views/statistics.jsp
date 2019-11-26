<%@ include file="/WEB-INF/views/adminHeader.jsp"%>

<h3>Statistics</h3>
<table>
	<tr>
		<td>
			<h4 style="color: red">
				Total no. of Users: ${totalUsers} <br> Online: ${onLineUsers} <br>
				Ofline: ${offlineUsers}
			</h4> <br> <br>
			<h4 style="color: green">
				Total no. of Rooms: ${totalRooms } <br>Active: 0 <br>Inactive:
				${totalRooms }
			</h4>
		</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>View Active <select>
				<option>Users</option>
		</select> <br> <br> <a href="<c:out value='viewOnlineEmployeeList'/>"><button
					class="btn btn-primary">View</button></a> <br> <br> 
		<%--
		<br> View Messages By <select>
				<option>Room</option>
		</select>
		<br> <br>
		
		<form:form action=""
				method="post" modelAttribute="chatRoom" style="width:300px">

				<table>
					<tr>
						<td>Room Name</td>
						<td><form:input path="roomName" id="roomName"
								placeholder="Room Name" /></td>
					</tr>
					<tr>
						<td>User Id</td>
						<td><form:input path="userName" id="userName"
								placeholder="User Id" /></td>
					</tr>
					<tr>
						<td colspan="2"><p></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="button"  class="btn btn-primary" value="View" >
						</td>
					</tr>

				</table>
			</form:form>
			 --%> <br> <br>
			<h4>
				<a href="<c:out value='getEmployeeList'/>">View Employee List</a>
			</h4>
		</td>
	</tr>

</table>

<%@ include file="/WEB-INF/views/indexFooter.jsp"%>