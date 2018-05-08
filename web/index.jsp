<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: shado
  Date: 5/8/2018
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>WebApp Tutorial Page</title>
  </head>
  <body>
  <h1>Hello world</h1>
  <p>This is my first webApp </p>

  <%

    String name= "Nikos";
    out.print(name);
    out.print(new Date());

  %>
  </body>
</html>
