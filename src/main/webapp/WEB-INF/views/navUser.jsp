<nav class="navbar navbar-inverse" style="width: 98% ;">
	<div class="container">
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1" align="center">
			<ul class="nav navbar-nav" style="width: 100% ;">
				<li style="width:14%"><a href="<c:out value='userHome'/>">Home</a></li>
				<li style="width:14%"><a href="<c:out value='address'/>">Address</a></li>

				<li style="width:14%">
					<%--  <a href="<c:out value='conference'/>">Conference</a></li> --%>

					<div class="dropdown" style="top:13px;">
						<span>Conference</span>
						<div class="dropdown-content" style="background-color: #ffcccc;">
							<a href="<c:out value='loginRoom'/>"><p>Login Room</p></a>
							<a href="<c:out value='createRoom'/>"><p>Create Room</p></a>
							<a href="<c:out value='myRoom'/>"><p>My Room</p></a>
						</div>
					</div>
				</li>
				<li style="width:14%"><a href="<c:out value='offline'/>">Offline</a></li>
				<li style="width:14%"><a href="<c:out value='userStatus'/>">View Status</a></li>
				<li  style="width:150px">
				<div class="dropdown" style="top:13px">
						<span>Options</span>
						<div class="dropdown-content" style="background-color: #ffcccc;">
							<a href="<c:out value='myProfile'/>"><p>My Profile</p></a>
							<a href="<c:out value='otherProfiles'/>"><p>Other Profiles</p></a>
							<a href="<c:out value='userChangePassword'/>"><p>Change Password</p></a>
						</div>
					</div>
				</li>
				<li style="width:14%"><a href="<c:out value='otherProfiles'/>">Search</a></li>
				<%-- <li style="width:150px"><a href="<c:out value='logout'/>">Logout</a></li> --%>
			</ul>

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<div class='container' style="top:150px;left:50px; position:relative">