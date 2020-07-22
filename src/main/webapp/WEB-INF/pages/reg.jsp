<%--<!DOCTYPE html>--%>
<%--<html xmlns="http://www.w3.org/1999/xhtml">--%>
<%--<head>--%>
<%--    <title>Sign up</title>--%>
<%--    <meta charset="UTF-8">--%>
<%--</head>--%>
<%--<body>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<h3>Регистрация</h3>
<form action="/registration" method="post">
    <span>${message}</span>
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><label> Full name: <input type="text" name="fullName"/> </label></div>
    <div>
        <label> I am patient <input type="radio" value="PATIENT" name="roleName"/>  </label><br>
        <label> I am doctor <input type="radio" value="DOCTOR" name="roleName"/>  </label><br>
    </div>
    <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
    <div><input type="submit" value="Зарегистрироваться"/></div>
</form>
<br>
<p>Уже зарегистрированы? <a href="/login">Войти в личный кабинет</a></p>
<br>
<a href="/">Вернуться</a><br><br>
<%--<br>--%>
<%--<a href="/"><h5>Home page</h5></a>--%>
<%--</body>--%>
<%--</html><!--тестовая страница-->--%>
