<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sender main page</title>
    <style>
        form {
            width: 35%;
            height: 55px;
        }

        .label {
            width: 20%;
            height: 100%;
        }

        .input {
            width: 30%;
            float: right;
            margin-right: 40%;
        }
    </style>
</head>
<body>
<form method="post">
    <h2>Введите сообщение</h2>
    <label class="label">Введите число</label>
    <input type="number" name="number" class="input" required="" max="999999999"><br><br>

    <label class="label">Введите дату</label>
    <input type="date" name="date" class="input" required=""><br><br>

    <label class="label">Выберите текст</label>
    <select name="text" class="input">
        <c:forEach items="${textValues}" var="textValue">
            <option value="${textValue}">
                    ${textValue}
            </option>
        </c:forEach>
    </select><br><br>

    <input type="submit" value="Отправить" name="send"><br><br>
</form>
</body>
</html>