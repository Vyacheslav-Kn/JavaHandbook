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
<div class="entrancePanel">
        <div class="entrance">
            <c:if test="${sessionScope.get('user') == null}">
                <form action="user/login" method="get">
                    <button>Войти</button>
                </form>
                <form action="user/register" method="get">
                    <button>Зарегистрироваться</button>
                </form>
            </c:if>
            <c:if test="${sessionScope.get('user') != null}">
                <form action="user/logout" method="get">
                    <button>Выйти</button>
                </form>
            </c:if>
        </div>
</div>
<div>
    <hr></hr>
</div>
<div class="content">
    <c:forEach var="article" items="${articles}">
        <div class="article">
            <p>
                <c:if test="${sessionScope.get('user') != null}">
                    <form action="article/edit" method="get">
                        <input type="text" name="ArticleId" value="${article.getId()}" style="display: none">
                        <button>Редактировать</button>
                    </form>
                </c:if>
                <a href="article/show?id=${article.getId()}"><c:out value="${article.getTitle()}"/></a>
                <c:out value="${article.getPublicationDate()}" />
            </p>
        </div>
    </c:forEach>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>