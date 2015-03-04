<%@ page import="java.util.*" %>
<%@ page isELIgnored="false" %>

<%@ taglib prefix="domelTL" uri="DomelTagLibrary"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<!-- jsp bean how to set type (interface) and class which is required -->
<jsp:useBean id="employee" type="foo.Person" class="foo.Employee" scope="request">
    <jsp:setProperty name="employee" property="name" value="Fred Employee" />
</jsp:useBean>
<jsp:getProperty name="employee" property="name" />
<br/><br/>

<jsp:useBean id="person" type="foo.Person" class="foo.Person" scope="request">
    <jsp:setProperty name="person" property="name" value="Fred Person" />
</jsp:useBean>
<jsp:getProperty name="person" property="name" />
<br/><br/>

<!-- how to call tag -->
<domelTL:Hello/>
<br/><br/>

<!-- how to call funtion name comes from custom.tld and it is not function name -->
${domelTL:helloDifferentName("Tomasz")}
<br/><br/>

<!-- it happens at translation time -->
<%@include file="header.jsp" %>
<br/><br/>

<!-- it happens at runtime -->
<jsp:include page="header.jsp">
    <jsp:param name="subTitle" value="We take the string" />
</jsp:include>
<br/><br/>

<!-- it happens in request time -->
<c:import url="header.jsp"></c:import>
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

<%if(request.getAttribute("userName") == null) {%>
    <!-- with jsp:forward action buffor is cleared before the forward -->
    <jsp:forward page="exit.jsp"></jsp:forward>
<%} else {%>
    Hello <%= request.getAttribute("userName").toString() %> ${requestScope.userName}
<%}%>
<br/>

<c:if test="${empty requestScope.userName}">
    <jsp:forward page="exit.jsp"></jsp:forward>
</c:if>

<!-- just to call error page -->
<% //int x1 = 10/0; %>


<a href="/servlets">Go back to start</a>
</body>
</html>