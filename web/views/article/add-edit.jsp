<%@ page import="app.entities.Article" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/tags.tld" prefix="tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String actionPath = "/article/edit";
    Article article = (Article) request.getAttribute("article");
    if(article.getId() == 0){
        actionPath = "/article/add";
    }
%>
<html>
<head>
    <title>Operate on article</title>
</head>
<body>
<div class="article-content">
    <form action="<%= actionPath %>" method="post">
        <p>Заголовок статьи:</p>
        <input type="text" name="Title" required="required" value="${article.getTitle()}">

        <p>Текст статьи:</p>
        <textarea name="Content" required="required">${article.getContent()}</textarea>

        <input type="text" name="Id" value="${article.getId()}" style="display: none">
        <p></p>

        <button>Сохранить</button>
    </form>
</div>
</body>
</html>
