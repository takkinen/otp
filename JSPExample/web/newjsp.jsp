<%-- 
    Document   : newjsp
    Created on : Apr 5, 2014, 9:40:56 AM
    Author     : fotakkihe
--%>





<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
<title>Auto Refresh Header Example</title>
</head>
<body>
<center>
<h2>Auto Refresh Header Example</h2>
<%
   // Set refresh, autoload time as 5 seconds
   response.setIntHeader("Refresh", 1);
   Calendar calendar = new GregorianCalendar();
   int sec = calendar.get(Calendar.SECOND);
   String string = "";
   for (int i=0;i<sec;i++) {
       string = string + "*";
   }
   out.println(string);
   
%>
</center>
</body>
</html>



<!--
// Get current time
   Calendar calendar = new GregorianCalendar();
   String am_pm;
   int hour = calendar.get(Calendar.HOUR);
   int minute = calendar.get(Calendar.MINUTE);
   int second = calendar.get(Calendar.SECOND);
   if(calendar.get(Calendar.AM_PM) == 0)
      am_pm = "AM";
   else
      am_pm = "PM";
   String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
   out.println("Current Time: " + CT + "\n");
-->