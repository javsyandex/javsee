<%-- 
    Document   : hello
    Created on : 05.05.2013, 5:42:22
    Author     : Michael Shumenko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>  

<div class="hero-unit" >
    <div id="myCarousel" class="carousel slide"  > 

        <ol class="carousel-indicators">
            <li class="active" data-target="#myCarousel" data-slide-to="0"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <div style="margin-top: -45px" class="carousel-inner">
            <div  class="item active">
                <img style="float: left" src="http://localhost:8080/WebShop/img/notebook.jpg"/>

                <div class="span5" style="float: left">
                    <h2>
                        Ноутбуки
                    </h2>
                    <p>
                        Ноутбук (англ. notebook — блокнот, блокнотный ПК) — портативный персональный компьютер, в корпусе которого объединены типичные компоненты ПК, включая дисплей, клавиатуру и устройство указания (обычно сенсорная панель, или тачпад), а также аккумуляторные батареи. Ноутбуки отличаются небольшими размерами и весом, время автономной работы ноутбуков изменяется в пределах от 4 до 15 часов.
                    </p>
                    <p>
                        <a class="btn btn-primary btn-large" href="notebook.htm">Перейти к покупке »</a>
                    </p>
                </div>
                <div style="float: right" class="carousel-caption ">
                    <a href="notebook.htm"><h4>Ноутбуки</h4></a>
                    <p>Лучшие ноутбуки по доступным ценам.</p>
                </div>
            </div>
            <div class="item">
                <img style="float: left" src="http://localhost:8080/WebShop/img/camera.jpg"/>

                <div class="span5" style="float: left">
                    <h2>
                        Системы видеонаблюдения
                    </h2>
                    <p>
                        Видеонаблюдение (англ. Сlosed Circuit Television, CCTV — система телевидения замкнутого контура) — процесс, осуществляемый с применением оптико-электронных устройств, предназначенных для визуального контроля или автоматического анализа изображений (автоматическое распознавание лиц, государственных номеров).
                    </p>
                    <p>
                        <a class="btn btn-primary btn-large" href="camera.htm">Перейти к покупке »</a>
                    </p>
                </div>
                <div style="float: bottom" class="carousel-caption">
                    <h4>Видеокамеры</h4>
                    <p>С нашими камерами видеонаблюдения, ничто не сможет ускользнуть от Вас </p>
                </div>
            </div>
            <div class="item">
                <img style="float: left" src="http://localhost:8080/WebShop/img/cable.jpg"/>

                <div class="span5" style="float: left">
                    <h2>
                        Кабель
                    </h2>
                    <p>
                        Коаксиа́льный ка́бель (от лат. co — совместно и axis — ось, то есть «соосный»), также известный как коаксиал (от англ. coaxial), — электрический кабель, состоящий из расположенных соосно центрального проводника и экрана. Обычно служит для передачи высокочастотных сигналов. Изобретён и запатентован в 1880 году британским физиком Оливером Хевисайдом.
                    </p>
                    <p>
                    <form>
                        <input type="hidden" value="cable" name="viewName"/>
                        <a class="btn btn-primary btn-large" href="cable.htm">Перейти к покупке »</a>
                    </form>
                    </p>
                </div>
                <div style="float: bottom" class="carousel-caption">
                    <h4>Кабель</h4>
                    <p>В наличии коаксиальный кабель, витая пара, оптоволоконный кабель.</p>
                </div>
            </div>
        </div>

        <a class="carousel-control left" data-slide="prev" href="#myCarousel">&lsaquo;</a>
        <a class="carousel-control right" data-slide="next" href="#myCarousel">&rsaquo;</a>

    </div>
</div>
