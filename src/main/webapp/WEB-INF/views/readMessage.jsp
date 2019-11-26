<%@ include file="/WEB-INF/views/adminHeader.jsp" %>

		<h3>Read Message</h3>


		<table class="table table-strip">
			<thead>
				<th>From</th>
				<th>Subject</th>
			</thead>

			<tbody>
				<c:if test="${!empty messageList}">
					<c:forEach items="${messageList}" var="message1">
						<tr>
							<%-- <td><%=++siNo%></td> --%>
							<td>${message1.fromUserName}</td>
							<td><c:url value="/viewMessageDetails?id=${message1.id}"
									var="viewDetails" /> <a href="<c:out value='${viewDetails}'/>">${message1.subject}</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>


<%@ include file="/WEB-INF/views/indexFooter.jsp" %></html>