<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


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

   <!-- add logout button -->
   <form:form action="${pageContext.request.contextPath}/logout"  method="POST">
          <input type="submit"  value="Logout"/>
   </form:form>

</body>


</html>