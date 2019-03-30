<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<c:if test="${registerErrorMessage != null}">
    <p>${registerErrorMessage}</p>
</c:if>
<form action="register" method="post">
    <input type="text" name="name">
    <input type="password" name="password">
    <input type="password" name="confirmPassword">
    <button>Зарегистрироваться</button>
</form>
</body>
</html>
