<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="include/header.jsp"%>
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Факультатив</h1>
        <p>Добро пожловать в факультатив Task-4</p>
        <%--<p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more »</a></p>--%>
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>Учитесь</h2>
          <p>Найдите лучшие курсы, пройдите лекции и получите оценки и отзывы лучших преподавателей. </p>
          <p><a class="btn btn-default" href="/task-4/course" role="button">Найти курс »</a></p>
        </div>
        <div class="col-md-4">
          <h2>Преподавайте</h2>
          <p>Лучшие программные решения для преподавателей, автоматизированная зачетка и отслеживание записи студентов.</p>
          <p><a class="btn btn-default" href="#" role="button">Перейти »</a></p>
       </div>
        <div class="col-md-4">
          <h2>Оценить разработку</h2>
          <p>Ваша оценка и комментарий поможет разработчику улучшить приложение.</p>
          <p><a class="btn btn-default" target="_blank" href="https://docs.google.com/spreadsheets/d/1h_rfvDkudY6PAqzeDA_6hDL5IEwdQWyCcRA0Fvo8lVM/edit?invite=CI_zgJcM&pli=1#gid=1" role="button">Оценить »</a></p>
        </div>
      </div>
<%@include file="include/footer.jsp"%>