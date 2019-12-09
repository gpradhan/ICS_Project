<%@ include file="/WEB-INF/views/adminHeader.jsp" %>
<div style="top:20%;position:fixed;width :100%" >
		<h3  align="center"  ><u>My Rooms</u></h3>
			</div>

	<div style="top:30%;position:fixed;width :100%">

			<div style="padding-left:5%;padding-right:5%; width: 90%">
			
			<c:if test="${empty myRoomsList}">
				No rooms created!! Please create room.
			</c:if>
			
		<c:if test="${!empty myRoomsList}">
			<table class="table table-bordered">
				<thead>
					<th>Room Name</th>
					<th>Key</th>
				</thead>

				<tbody>

					<c:forEach items="${myRoomsList}" var="room">
						<tr>
							<%-- <td><%=++siNo%></td> --%>
							<td>${room.id}</td>
							<td>${room.key}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</c:if>
		
</div>
</div>
<%@ include file="/WEB-INF/views/indexFooter.jsp" %>