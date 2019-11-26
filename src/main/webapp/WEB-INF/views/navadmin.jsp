<nav class="navbar navbar-inverse" style="width: 98% ;">
	<div class="container" >
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li  style="width:100px"><a href="<c:out value='adminHome'/>">Home</a></li>
				<li  style="width:100px"><a href="<c:out value='address'/>">Address</a></li>

				<li  style="width:150px">
					<%--  <a href="<c:out value='conference'/>">Conference</a></li> --%>

					<div class="dropdown" style="top:13px;">
						<span>Conference</span>
						<div class="dropdown-content">
							<a href="<c:out value='loginRoom'/>"><p>Login Room</p></a>
							<a href="<c:out value='createRoom'/>"><p>Create Room</p></a>
							<a href="<c:out value='myRoom'/>"><p>My Room</p></a>
						</div>
					</div>
				</li>
				<li  style="width:150px"><a href="<c:out value='offline'/>">Offline</a></li>
				<li  style="width:150px">
				<%-- <a href="<c:out value='userRelated'/>">User Related</a> --%>
				<div class="dropdown" style="top:13px;">
						<span>User Related&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<div class="dropdown-content">
							<a href="<c:out value='addEmployee'/>"><p>Add Employee</p></a>
							<a href="<c:out value='deleteEmployee'/>"><p>Delete User</p></a>
							<a href="<c:out value='banUser'/>"><p>Ban User</p></a>
							<a href="<c:out value='activateUser'/>"><p>Activate User</p></a>
						</div>
					</div>
				</li>
				<li  style="width:150px">
				<%-- <a href="<c:out value='options'/>">Options</a> --%>
				<div class="dropdown" style="top:13px;">
						<span>Options</span>
						<div class="dropdown-content">
							<a href="<c:out value='myProfile'/>"><p>My Profile</p></a>
							<a href="<c:out value='otherProfiles'/>"><p>Other Profiles</p></a>
							<a href="<c:out value='adminChangePassword'/>"><p>Change Password</p></a>
							<a href="<c:out value='userStatus'/>"><p>User Status</p></a>
							<a href="<c:out value='otherProfiles'/>"><p>Search User</p></a>
							<a href="<c:out value='readAdvices'/>"><p>Read Advices</p></a>
						</div>
					</div>
				</li>
				<li  style="width:150px"><a href="<c:out value='statistics'/>">Statistics</a></li>
				<li  style="width:150px"><a href="<c:out value='logout'/>">Logout</a></li>
			</ul>

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<div class='container' style="top:150px;left:50px; position:relative">