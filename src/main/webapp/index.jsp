<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quest-game</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1><%= "Квест-игра \"Лесные приключения!\"" %>
    </h1>
    <br/>
    <form action="start" method="post" class="form-horizontal">
        <fieldset>

            <!-- Form Name -->
            <legend>Регистрация для участия в игре</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="nickinput">Ваш nickname</label>
                <div class="col-md-4">
                    <input id="nickinput" name="nickinput" type="text" placeholder="Введите ник" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="emailinput">Ваш email</label>
                <div class="col-md-4">
                    <input id="emailinput" name="emailinput" type="text" placeholder="Введите email" class="form-control input-md">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="passwordinput">Ваш пароль</label>
                <div class="col-md-4">
                    <input id="passwordinput" name="passwordinput" type="password" placeholder="от 8 символов" class="form-control input-md">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton">Отправить данные</label>
                <div class="col-md-4">
                    <button id="singlebutton" name="singlebutton" class="btn btn-primary" onclick="registration()">Регистрация</button>
                </div>
            </div>

        </fieldset>
    </form>
    <br><br>
    <p>Ник игрока: <%= session.getAttribute("nickname")%></p>
    <p>Email игрока: <%= session.getAttribute("email")%></p>
    <p>Id сессии: <%= session.getId()%></p>
</div>


</body>
</html>