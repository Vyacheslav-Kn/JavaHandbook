<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/tags.tld" prefix="tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="../content/style.css" rel="stylesheet">
    <title>Articles</title>
</head>
<body>
<tags:header></tags:header>
<div class="content">
    <c:forEach var="article" items="${articles}">
        <p>
            <c:out value="${article.getTitle()}" />
            <c:out value="${article.getPublicationDate()}" />
        </p>
    </c:forEach>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>
