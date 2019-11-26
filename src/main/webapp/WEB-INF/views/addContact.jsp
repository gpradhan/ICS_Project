<%@ include file="/WEB-INF/views/adminHeader.jsp" %>

		<h3>Add Contact</h3>

		<form:form action="addContact" method="post" modelAttribute="contactBook" style="width:300px">

			<table>

				<tr>
					<td>Name</td>
					<td><form:input path="name" id="name" placeholder="Name" /></td>
				</tr>
				<tr>
					<td>User Id</td>
					<td><form:input path="userId" id="userId" placeholder="userId" /></td>
				</tr>
				<tr>
					<td>Date Of Bitrh</td>
					<td><form:input path="dob" id="datepicker" placeholder="Date of Birth(DD/MM/YYYY)" /></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td><form:input path="email" id="email" placeholder="email" /></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><form:input path="phone" id="phone" placeholder="phone" /></td>
				</tr>
				<tr>
					<td>City</td>
					<td><form:input path="city" id="city" placeholder="city" /></td>
				</tr>

				<tr>
					<button class="btn btn-primary" type="submit" class="btn btn-teal btn-rounded btn-sm m-0">Add</button>
					<button class="btn btn-primary" type="reset" class="btn btn-teal btn-rounded btn-sm m-0">Clear</button>
				</tr>

			</table>
		</form:form>

<%@ include file="/WEB-INF/views/indexFooter.jsp" %>