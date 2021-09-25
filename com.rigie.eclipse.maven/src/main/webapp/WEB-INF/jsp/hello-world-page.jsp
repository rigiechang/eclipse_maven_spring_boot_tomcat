<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
  <title>Maven Tomcat App Homepage</title>
</head>
<body>
<p>Hello World from Maven Tomcat App JSP Page!</p>

<p>&nbsp;</p>

<p>Variable from Controller:</p>

<!-- Error: ModelMap not working , JSP variable is blank 
     Fix: double check the variable name
     model.addAttribute("greeting", "This value passed to the JSP page");
     should use ${greeting} and not {$message}
-->
<p>${greeting}</p>

</body>
</html>