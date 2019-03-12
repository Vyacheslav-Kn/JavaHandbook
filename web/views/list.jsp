<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/tags.tld" prefix="tags" %>
<html>
<head>
    <title>Articles</title>
</head>
<body>
<tags:header></tags:header>
<div>
    <%
        List<String> data = (List<String>) request.getAttribute("data");

        if (data != null && !data.isEmpty()) {
            for (String row : data) {
                out.println("<li>" + row + "</li>");
            }
        }
    %>
</div>
</body>
</html>
