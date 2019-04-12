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
                <form action="user/office" method="get">
                    <button>Личный кабинет</button>
                </form>
            </c:if>
        </div>
</div>
<div>
    <hr></hr>
</div>
<div class="content" id="articles">
    <c:forEach var="article" items="${articles}">
        <div class="article">
                <a href="article/show?id=${article.getId()}"><c:out value="${article.getTitle()}"/></a>
                <c:out value="${article.getPublicationDate()}" />
                <c:out value="${article.getCategory().getTitle()}" />
                <c:out value="${article.getDescription()}" />
        </div>
    </c:forEach>
    <c:if test="${currentPage != 1}">
        <a href="/home?page=${currentPage-1}">Назад</a>
    </c:if>
    <span>Текущая страница: <c:out value="${currentPage}" /></span>
    <c:if test="${currentPage < numberOfPages}">
        <a href="/home?page=${currentPage+1}">Вперед</a>
    </c:if>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>