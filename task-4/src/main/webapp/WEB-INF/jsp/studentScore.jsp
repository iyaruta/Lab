<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="include/header.jsp" %>
<link rel="stylesheet" href="http://getbootstrap.com/examples/signin/signin.css">
<div class="head_shift"></div>

<div class="container">
    <form class="form-signin" action="/task-4/course/student" method="POST">
        <h2 class="form-signin-heading">Оценить ${student.name}</h2>
        <label for="score" class="sr-only">Оценка</label>
        <select id="score" name="score">
            <option value="BAD">Неудовлетворительно</option>
            <option value="MIDDLE">Средне</option>
            <option value="GOOD">Нормально</option>
            <option value="EXCELLENT">Отлично</option>
        </select>
        <label for="feedback" class="sr-only">Отзыв</label>
        <input type="feedback" name="feedback" id="feedback" class="form-control" placeholder="Отзыв" required="">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Сохранить</button>
        <input type="hidden" name="courseId" value="${courseId}">
        <input type="hidden" name="studentId" value="${student.id}">
    </form>
</div>

<%@include file="include/footer.jsp" %>