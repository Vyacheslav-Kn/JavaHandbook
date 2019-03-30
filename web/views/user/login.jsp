<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<c:if test="${loginErrorMessage != null}">
    <p>${loginErrorMessage}</p>
</c:if>
    <form action="login" method="post">
        <input type="text" name="name">
        <input type="password" name="password">
        <button>Войти</button>
    </form>
</body>
</html>
