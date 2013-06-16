<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" type="text/css" href="css/validation.css" media="screen" />
        <title>Валидация</title>
    </head>
    <body>
        <form id="signup">
            <h1>Регистрация</h1>
            <h2>Поля помеченные (*) обязательны для заполнения</h2>
            <fieldset>
                <legend>Информация</legend>
                <ol>
                    <li>
                        <label for="msg">Имя *</label> 
                        <input type="text" id="msg" name="msg" placeholder="Ф.И.О" required />
                    </li>
                    <li>
                        <label for="email">Почта *</label> 
                        <input type="email" id="email" name="email" placeholder="valera@domain.ru" title="Введите email" required />
                        <p class="validation01">
                            <span class="invalid">Введите email</span>
                            <span class="valid">Спасибо</span>
                        </p>
                    </li>
                    <li>
                        <label for="tel">Телефон *</label> 
                        <input type="tel" id="tel" name="tel" pattern="^[ 0-9]+$" placeholder="Введите номер телефона" required />
                        <p class="validation01">
                            <span class="invalid">Пример (098)-758-64-61</span>
                            <span class="valid">Спасибо</span>
                        </p>
                    </li>
                </ol>
            </fieldset>
            <fieldset>
                <legend>Адресс</legend>
                <ol>
                    <li>
                        <label for="address">Адресс *</label>
                        <input id="address" name="address" type="text" required />
                    </li>
                    <li>
                        <label for="suburb">Дополнительно *</label>
                        <input id="suburb" name="suburb" type="text" required />
                    </li>
                    <li>
                        <label for="postcode">Индекс *</label>
                        <input id="postcode" name="postcode" type="number" min="100000" max="999999" maxlength="7" required />
                        <p class="validation01">
                            <span class="invalid">Пример: 111</span>
                            <span class="valid">Спасибо</span>
                        </p>
                    </li>
                    <li>
                        <label for="state">Город</label>
                        <select name="state" id="state">
                            <option>Москва</option>
                            <option>Питер</option>
                        </select>
                    </li>
                </ol>
            </fieldset>
            <input type="submit" value="Зарегистрировать" />
        </form>
    </body>
</html>
