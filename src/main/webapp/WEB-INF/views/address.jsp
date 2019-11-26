<%@ include file="/WEB-INF/views/adminHeader.jsp" %>
  <div style="top:20%;position:fixed;width :100%" >
		<h3  align="center"  >Address Book</h3>
			</div>

	<div style="top:30%;position:fixed;width :100%">
		<form:form action="addDeleteContact" method="post" modelAttribute="contactBook">
		<div>
			<span style="padding-left:5%;padding-right:5%;"><button type="submit" name="addContact" class="btn btn-success" >Add
				Contact</button></span>

			<span style="padding-left:5%;padding-right:5%;"><input type="button" onclick="selectAllContacts()" value="Check All" class="btn btn-primary" ></span>
			<span style="padding-left:5%;padding-right:5%;"><input type="button" onclick="clearAllContacts()" value="Clear" class="btn btn-primary"></span>
			<span style="padding-left:5%;padding-right:5%;"><button type="submit" class="btn btn-Danger" name="deleteContact" >Delete</button></span>
			</div>
<br>
			<div style="padding-left:5%;padding-right:5%; width: 90%">
		<c:if test="${!empty contactList}">
			<table class="table table-strip">
				<thead>
					<th>Name</th>
					<th>User Id</th>
					<th>DOB</th>
					<th>Email Id</th>
					<th>Phone</th>
					<th>City</th>
				</thead>

				<tbody>

					<c:forEach items="${contactList}" var="contact">
						<tr>
							<%-- <td><%=++siNo%></td> --%>
							<td><form:checkbox path="selectedContacts" value="${contact.id}" class="contactClass"/>${contact.name}</td>
							<td>${contact.userId}</td>
							<td>${contact.dob}</td>
							<td>${contact.email}</td>
							<td>${contact.phone}</td>
							<td>${contact.city}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</c:if>
		
</div>
		</form:form>
</div>
<%@ include file="/WEB-INF/views/indexFooter.jsp" %>