<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="include/header.jsp" %>
<link rel="stylesheet" href="http://getbootstrap.com/examples/signin/signin.css">
<div class="head_shift"></div>

<div class="container">
    <form class="form-signin" action="/task-4/addCourse" method="POST">
        <h2 class="form-signin-heading">Новый курс</h2>

        <label for="inputEmail" class="sr-only">Название</label>
        <input type="text" name="name" id="inputEmail" class="form-control" placeholder="Название" required=""autofocus="">

        <label for="desc" class="sr-only">Описание</label>
        <input type="text" name="description" id="desc" class="form-control" placeholder="Описание" required="">

        <label for="start" class="sr-only">Начало</label>
        <input type="text" name="start" id="start" class="form-control" placeholder="Начало" required="">

        <label for="end" class="sr-only">Конец</label>
        <input type="text" name="end" id="end" class="form-control" placeholder="Конец" required="">

        <button class="btn btn-lg btn-primary btn-block" type="submit">Сохранить</button>
    </form>
</div>

<%@include file="include/footer.jsp" %>