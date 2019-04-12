<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/tags.tld" prefix="tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Article</title>
</head>
<body>
<div class="article-content">
    <p>Заголовок статьи:</p>
    <div>${article.getTitle()}</div>

    <p>Категория статьи:</p>
    <div>${article.getCategory().getTitle()}</div>

    <p>Дата модификации:</p>
    <div>${article.getPublicationDate()}</div>

    <p>Краткое описание статьи:</p>
    <div>${article.getDescription()}</div>

    <p>Текст статьи:</p>
    <div>${article.getContent()}</div>
</div>
</body>
</html>
