<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/tags.tld" prefix="tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add article</title>
</head>
<body>
<div class="article-content">
    <form action="/article/add" method="post">
        <p>Заголовок статьи:</p>
        <input type="text" name="Title" required="required">

        <p>Категория статьи:</p>
        <select name="CategoryId">
            <option value="1">Категория 1</option>
            <option value="2">Категория 2</option>
            <option value="3">Категория 3</option>
        </select>

        <p>Описание статьи:</p>
        <textarea name="Description" required="required"></textarea>

        <p>Текст статьи:</p>
        <textarea name="Content" required="required"></textarea>

        <input type="text" name="Id" value="${article.getId()}" style="display: none">
        <p></p>

        <button>Сохранить</button>
    </form>
</div>
</body>
</html>
