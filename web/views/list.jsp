<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Articles</title>
</head>
<body>
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
