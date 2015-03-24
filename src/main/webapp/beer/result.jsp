<%@ page import="servlets.model.Movie" %>
<%@ page isELIgnored="false" %>

<%@ taglib prefix="domelTL" uri="DomelTagLibrary"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="tagiTag" tagdir="/WEB-INF/tags" %>
<jsp:directive.page import="java.util.*" />
<html>
<body>

<%java.util.List<servlets.model.Movie> optionsList =  (java.util.List<servlets.model.Movie>)request.getAttribute("movies"); %>
<domelTL:options optionsList="<%=optionsList%>" testAttr="Tomek"></domelTL:options>
<br/><br/>

<tagiTag:TagiTag subTitle="This is subtitle for tag">This is body</tagiTag:TagiTag>
<br/><br/>

<!-- jsp bean how to set type (interface) and class which is required -->
<jsp:useBean id="employee" type="servlets.model.Person" class="servlets.model.Employee" scope="request">
    <jsp:setProperty name="employee" property="name" value="Fred Employee" />
</jsp:useBean>
<jsp:getProperty name="employee" property="name" />
<br/><br/>

<jsp:useBean id="person" type="servlets.model.Person" class="servlets.model.Person" scope="request">
    <jsp:setProperty name="person" property="name" value="Fred Person" />
</jsp:useBean>
<jsp:getProperty name="person" property="name" />
<br/><br/>

<c:forEach items="${movieCollection}" var="movie">
      <br>${movie.name}
</c:forEach>

<!-- it happens at translation time -->
<%@include file="header.jsp" %>
<br/><br/>

<!-- it happens at runtime -->
<jsp:include page="header.jsp">
    <jsp:param name="subTitle" value="We take the string" />
</jsp:include>
<br/><br/>

<!-- it happens in request time -->
<c:import url="header.jsp">
    <c:param name="subTitle" value="We take the string" />
</c:import>
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

<c:if test="${empty requestScope.userName}">
    <jsp:forward page="exit.jsp"></jsp:forward>
</c:if>

<c:catch var="myException">
<!-- just to call error page -->
<% int x1 = 10/0; %>
You will never see this
</c:catch>
<br/>
Exception was: ${myException.message}<br/>
WE SURVIVED

<br/><br/>
<!-- iterate through musicList -->
<c:forEach var="music" items="${musicList}" varStatus="musicListCounter">
    ${musicListCounter.count}
    ${music}<br/>
</c:forEach>
<br/><br/>

<c:choose>
    <c:when test="${empty requestScope.userName}">test</c:when>
    <c:otherwise>otherwise</c:otherwise>
</c:choose>
<br/><br/>

<c:set target="${person.dog}" property="name">
    Pies
</c:set>
Pies?: ${person.dog.name}
<br/><br/>

<!-- how to call tag -->
Tag with required EL argument:
<domelTL:hello user="${requestScope.userName}">${2+3} ${message}</domelTL:hello>
<br/>
Tag with scripting expression:
<domelTL:hello user='<%= request.getAttribute("userName").toString() %>'>
${2+3} 
${message}
</domelTL:hello>
<br/>
Tag with standard action:
<domelTL:hello>
    <jsp:attribute name="user">${requestScope.userName}</jsp:attribute>
    <jsp:body>${2+3} ${message}</jsp:body>    
</domelTL:hello>
<br/><br/>

<!-- how to call funtion name comes from custom.tld and it is not function name -->
${domelTL:helloDifferentName("Tomasz")}
<br/><br/>

<a href="/servlets">Go back to start</a>
</body>
</html>
