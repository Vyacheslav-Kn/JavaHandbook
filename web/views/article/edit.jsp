<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/tags.tld" prefix="tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<div class="article-content">
    <form action="/article/edit" method="post">
        <p>Изменить текст статьи:</p>
        <textarea name="Content" required="required">${article.getContent()}</textarea>

        <p>Изменить описание статьи:</p>
        <textarea name="Description" required="required">${article.getDescription()}</textarea>

        <input type="text" name="Id" value="${article.getId()}" style="display: none">
        <p></p>

        <button>Сохранить</button>
    </form>
</div>
</body>
</html>
