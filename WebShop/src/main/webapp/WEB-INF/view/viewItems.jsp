

<%-- 
    Document   : index
    Created on : 14.04.2013, 16:32:25
    Author     : Mihael Shumenko
--%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Интернет Магазин</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <!-- Bootstrap -->
        <link href="http://localhost:8080/WebShop/css//bootstrap.css" rel="stylesheet">
        <link href="http://localhost:8080/WebShop/css//bootstrap-responsive.css" rel="stylesheet">
        <link href="http://localhost:8080/WebShop/css//style-for-text.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="http://localhost:8080/WebShop/js/bootstrap.js"></script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <div class="navbar navbar-inverse">
                        <div class="navbar-inner">
                            <div class="container-fluid">
                                <a data-target="navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a> <a href="#" class="brand"><img src=""/></a>
                                <div class="nav-collapse collapse navbar-responsive-collapse">
                                    <ul class="nav">
                                        <li class="active">
                                            <a href="helloPage.htm">Главная</a>
                                        </li>
                                        <li class="dropdown">
                                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">Категории<strong class="caret"></strong></a>
                                            <ul class="dropdown-menu">
                                                <li class="nav-header">
                                                    Компьютеры
                                                </li>
                                                <li>
                                                    <a href="notebook.htm">Ноутбуки</a>
                                                </li>
                                                <li class="divider">
                                                </li>
                                                <li class="nav-header">
                                                    Системы видеонаблюдения
                                                </li>
                                                <li>
                                                    <a href="camera.htm">Камеры</a>
                                                </li>
                                                <li>
                                                    <a href="cable.htm">Кабель</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li>
                                            <a href="customers.htm">Покупатели</a>
                                        </li>
                                        <li>
                                            <a href="cart.htm">Корзина</a>
                                        </li>

                                    </ul>
                                    <form class="navbar-form pull-right" >
                                        <input type="text" class="span8"/>
                                        <button type="submit" class="btn">Поиск</button>
                                    </form>
                                </div>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <div id="customers">
                <table class="table table-bordered" border="2" width="2" cellspacing="2" cellpadding="2" >
                    <thead>
                        <tr>
                            <th>Имя</th>
                            <th>Цена</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${items}" var="items"> 
                            <tr>
                                <td><c:out value="${items.nameItem}"/></td>
                                <td><c:out value="${items.priceItem}"/></td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>  
            </div>

    </body>
</html>     