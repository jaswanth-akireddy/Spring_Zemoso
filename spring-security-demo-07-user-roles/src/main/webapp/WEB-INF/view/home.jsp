<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>




<html>
<head>
   <title>Zemoso Home Page</title>
</head>


<body>
   <h2>Zemoso Home Page Login Retention Test</h2>
   <hr>
<p>
   Welcome to the Zemoso Home Page
   </p>
   <--display user name and role-->
   <p>
   User: <security:authentication property="principal.username"/>
   <br><br>
    Role(s): <security:authentication property="principal.authorities"/>
   </p>


   <!-- Add a link to point to /leaders ....or managers-->
   <security:authorize access="hasRole('MANAGER')">
   <p>
       <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
       (Only for Manager Peeps)
   </p>
 </security:authorize>

   <!-- Add a link to point to /systems ... this is for the admins -->

    <security:authorize access="hasRole('ADMIN')">
   	<p>
   		<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
   		(Only for Admin peeps)
   	</p>
   	 </security:authorize>

   	<hr>

   <!-- add logout button -->
   <form:form action="${pageContext.request.contextPath}/logout"  method="POST">
          <input type="submit"  value="Logout"/>
   </form:form>
</body>


</html>