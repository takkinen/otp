<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : Mar 8, 2014, 10:27:25 AM
    Author     : fotakkihe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:useBean id="person" scope="page" class="fi.hamk.Person" >
        <jsp:setProperty name="person" property="*" />
    </jsp:useBean>
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:getProperty name="person" property="etunimi" />
        <jsp:getProperty name="person" property="sukunimi" />
        ${person.ika}
        <%= request.getParameter("arvo") %>
        <c:out value="${person.etunimi}" />
    
    </body>
</html>
