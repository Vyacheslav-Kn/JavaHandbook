<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/tags.tld" prefix="tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="../content/style.css" rel="stylesheet">
    <title>Office</title>
</head>
<body>
<div class="content">
    <div class="manage-buttons">
        <a href="/article/add">Добавить статью</a>
    </div>
    <p>Мои статьи:</p>
    <c:forEach var="article" items="${articles}">
        <div class="article">
            <p>
            <c:if test="${sessionScope.get('user') != null}">
            <form action="/article/edit" method="get">
                <input type="text" name="ArticleId" value="${article.getId()}" style="display: none">
                <button>Редактировать</button>
            </form>
            <form action="/article/delete" method="post">
                <input type="text" name="ArticleId" value="${article.getId()}" style="display: none">
                <button>Удалить</button>
            </form>
            </c:if>
            <a href="/article/show?id=${article.getId()}"><c:out value="${article.getTitle()}"/></a>
            <c:out value="${article.getPublicationDate()}" />
            <c:out value="${article.getCategory().getTitle()}" />
            <c:out value="${article.getDescription()}" />
            </p>
        </div>
    </c:forEach>
</div>
</body>
</html>