<%@ include file="/WEB-INF/views/adminHeader.jsp" %>

<h3>User Registration Form</h3>
  <form:form action="addLibrarian" method="post" modelAttribute="myUser" style="width:300px">
  <div class="form-group">
    <label for="name1">Name</label>
    <form:input class="form-control" path="userName" id="name1" placeholder="Name"/>
  </div>
  <div class="form-group">
    <label for="email1">Email address</label>
    <form:input class="form-control" path="email" id="email1" placeholder="Email"/>
  </div>
  <div class="form-group">
    <label for="password1">Password</label>
    <form:password class="form-control" path="password" id="password1" placeholder="Password"/>
  </div>  
  <div class="form-group">
    <label for="mobile1">Mobile Number</label>
    <form:input class="form-control" path="mobile" id="mobile1" placeholder="Mobile"/>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form:form>

<%@ include file="/WEB-INF/views/indexFooter.jsp" %>