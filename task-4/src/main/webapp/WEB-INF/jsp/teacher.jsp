<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="include/header.jsp" %>
<div class="head_shift"></div>

<div class="container">
    <div class="page-header">
        <h1>Курсы
            <small>мои лекции</small>
        </h1>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Название</th>
            <th>Описание</th>
            <th>Начало</th>
            <th>Конец</th>
            <th>Преподаватель</th>
            <th>Участников</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${courses}" var="course" varStatus="status">
            <tr>
                <th scope="row">${status.index + 1}</th>
                <td>${course.name}</td>
                <td>${course.description}</td>
                <td><fmt:formatDate value="${course.start}" pattern="dd/MMM/yyyy"/></td>
                <td><fmt:formatDate value="${course.end}" pattern="dd/MMM/yyyy"/></td>
                <td>${course.teacher.name}</td>
                <td>${fn:length(course.students)}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="col-md-4">
        <p><a class="btn btn-default" href="/task-4/addCourse" role="button">Добавить курс »</a></p>
    </div>
</div>

<%@include file="include/footer.jsp" %>