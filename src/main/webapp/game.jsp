<%--
Created by IntelliJ IDEA.
User: Олег
Date: 07.06.2024
Time: 19:16
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.questexample.Entity.StatusEnum" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script
            src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous"></script>
</head>
<body>

<c:set var="start" value="<%=StatusEnum.START%>"/>
<c:set var="call" value="<%=StatusEnum.CALL%>"/>
<c:set var="bridge" value="<%=StatusEnum.BRIDGE%>"/>
<c:set var="victory" value="<%=StatusEnum.VICTORY%>"/>
<c:set var="reject" value="<%=StatusEnum.REJECT%>"/>

<div class="container">
    <c:if test="${status == start}">
    <h1> Спасибо за регистрацию, <%= session.getAttribute("nickname")%>. Добро пожаловать в игру!)</h1>
    <button type="button" class="btn btn-primary" onclick="postRedirect()">Принять вызов</button>
    </c:if>
    <c:if test="${status == call}">
    <h1> Ты принял вызов. Поднимаешься на мостик к капитану?</h1>
    <div class="btn-group" role="group" aria-label="Basic example">
        <button type="button" class="btn btn-primary" onclick="postRedirect('bridge')">Подняться</button>
        <button type="button" class="btn btn-primary" onclick="postRedirect('reject')">Отказаться</button>
    </div>
    </c:if>
    <c:if test="${status == bridge}">
    <h1> Ты поднялся на мостик. Ты кто?</h1>
        <div class="btn-group" role="group" aria-label="Basic example">
    <button type="button" class="btn btn-primary" onclick="postRedirect('victory')">Сказать правду</button>
    <button type="button" class="btn btn-primary" onclick="postRedirect('reject')">Солгать</button>
        </div>
    </c:if>
    <c:if test="${status == victory}">
    <h1> Тебя вернули домой. ПОБЕДА!</h1>
    <button type="button" class="btn btn-primary" onclick="restart()">Сыграть ещё раз</button>
    </c:if>
    <c:if test="${status == reject}">
    <h1> Ты проиграл!</h1>
    <button type="button" class="btn btn-primary" onclick="restart()">Попытаться ещё раз</button>
    </c:if>
    <br><br>
    <p>Ник игрока: <%= session
            .
            getAttribute
                    (
                            "nickname"
                    )%>
    </p>
    <p>Email игрока: <%= session
            .
            getAttribute
                    (
                            "email"
                    )%>
    </p>
    <p>Id сессии: <%= session
            .
            getId
                    (
                    )%>
    </p>

    <script>
        function postRedirect(userdata) {
            $.ajax({
                url: 'redirect',
                type: 'POST',
                data: {text: userdata},
                success: function () {
                    location.reload();
                }
            });
        }

        function restart() {
            $.ajax({
                url: 'redirect',
                type: 'GET',
                success: function () {
                    location.replace("/index.jsp");
                }
            });
        }

    </script>
</body>
</html>