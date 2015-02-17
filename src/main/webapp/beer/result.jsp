<%@ page import="java.util.*" %>

<html>
<body>
<%List brands = (List)request.getAttribute("brands"); 
for (Object object : brands) {
    out.println(object.toString());    
}
%>
<a href="/servlets">Go back to start</a>
</body>
</html>
