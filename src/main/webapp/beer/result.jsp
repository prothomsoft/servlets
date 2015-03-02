<%@ page import="java.util.*" %>

<html>
<body>
<%List brands = (List)request.getAttribute("brands"); 
for (Object object : brands) {
    out.println(object.toString());    
}
%>
<br/>
<%
String adminEmail = (String)request.getAttribute("adminEmail");
out.println(adminEmail);
%>
<br/>
<%
String emailNames = (String)request.getAttribute("emailNames");
out.println(emailNames);
%>
<br/>
<%
String adminEmailContext = getServletContext().getInitParameter("adminEmailContext");
out.println(adminEmailContext);
%>
<br/>
<%
String breed = getServletContext().getInitParameter("breed");
out.println(breed);
%>
<br/>
<%
String sessionStatus = (String)request.getAttribute("sessionStatus");
out.println(sessionStatus);
%>
<br/>
<%
String cookie = (String)request.getAttribute("cookie");
out.println(cookie);
%>
<br/>
<%
String activeSessions = request.getAttribute("activeSessions").toString();
out.println(activeSessions);
%>
<br/>
<a href="/servlets">Go back to start</a>
</body>
</html>
