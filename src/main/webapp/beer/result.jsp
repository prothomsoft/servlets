<%@ page import="java.util.*" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="domelTL" uri="DomelTagLibrary"%>

<html>
<body>

<!-- how to call tag -->
<domelTL:Hello/>
<br/><br/>

<!-- how to call funtion -->
${domelTL:hello()}
<br/><br/>

<!-- it happens at translation time -->
<%@include file="header.jsp" %>
<br/><br/>

<!-- it happens at runtime -->
<jsp:include page="header.jsp" />
<br/><br/>

${musicList[numbers[0]]}
${musicList[numbers[0]+1]}
${musicList[numbers[1]]}
${musicList[numbers[numbers[1]]]}
<br/><br/>

${person["name"]} dog ${person.dog.name} toys are:
${person.dog.toys[0].name} and ${person.dog.toys[1].name} and ${person.dog.toys[2].name}.
<br/><br/>

${cookie.username.value}
<!-- it applies to context parameters -->
${initParam.adminEmailContext}
<br/><br/>

<%! int countOutOfSer=0; %>
<% int countInService=0; %>

<%!
public void jspInit() {    
    ServletConfig sConfig = getServletConfig();
    String adminEmailAddress = sConfig.getInitParameter("adminEmailContext");
    ServletContext ctx = getServletContext();
    ctx.setAttribute("mail", adminEmailAddress);
}
%>

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
<% ArrayList list = new ArrayList();
  list.add(new String("foo"));%>
<%= list.get(0) %>
<br/>
<%! int x = 42; %>
<% int x = 22; %>
<%=x %>

<br/>
<a href="/servlets">Go back to start</a>
</body>
</html>