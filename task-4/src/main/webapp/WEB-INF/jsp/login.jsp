<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="include/header.jsp" %>
<link rel="stylesheet" href="http://getbootstrap.com/examples/signin/signin.css">
<div class="head_shift"></div>

<div class="container">
    <form class="form-signin" action="/task-4/login" method="POST">
        <h2 class="form-signin-heading">Пожалуйста введите свои данные</h2>
        <label for="inputEmail" class="sr-only">Имя</label>
        <input type="text" name="name" id="inputEmail" class="form-control" placeholder="Введите ваше имя" required=""
               autofocus="">
        <label for="inputPassword" class="sr-only">Пароль</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Пароль" required="">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
        <input type="hidden" name="type" value="${type}">
    </form>
</div>

<%@include file="include/footer.jsp" %>