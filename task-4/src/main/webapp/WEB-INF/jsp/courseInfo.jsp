<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="include/header.jsp" %>
<div class="head_shift"></div>

<div class="container">
    <div class="page-header">
        <h1>${course.name}
            <small>${course.description}</small>
        </h1>
    </div>

    <table class="table">
        <thead>
            <tr>
                <th>#</th>
                <th>Имя</th>
                <th>Оценка</th>
                <th>Отзыв</th>
                <th>&nbsp;</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${students}" var="student" varStatus="status">
                <tr>
                    <th scope="row">${status.index + 1}</th>
                    <td>${student.student.name}</td>
                    <td>${student.score}</td>
                    <td>${student.feedback}</td>
                    <td>
                        <a href="/task-4/course/student?student=${student.studentId}&course=${course.id}">Оценить</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="include/footer.jsp" %>