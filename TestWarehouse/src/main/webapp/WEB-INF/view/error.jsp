

<%-- 
    Document   : index
    Created on : 14.04.2013, 16:32:25
    Author     : Mihael Shumenko
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Warehouse App</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <!-- Bootstrap -->
        <link href="http://localhost:8080/WebShop/css//bootstrap.css" rel="stylesheet">
        <link href="http://localhost:8080/WebShop/css//bootstrap-responsive.css" rel="stylesheet">
        <link href="http://localhost:8080/WebShop/css//style-for-text.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="http://localhost:8080/WebShop/js/bootstrap.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css" />
        <script>
            $(function() {
                $("#datepicker").datepicker({
                    changeMonth: true,
                    changeYear: true,
                    dateFormat: "yy-mm-dd"
                });
            });
        </script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <div class="navbar nav-header">
                        <div class="navbar-inner">
                            <div class="container-fluid">
                                <a data-target="navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a> <a href="#" class="brand"><img src=""/></a>
                                <div class="nav-collapse collapse navbar-responsive-collapse">
                                    <ul class="nav">
                                        <li class="">
                                            <a href="helloPage.htm">Главная</a>
                                        </li>
                                        <li class="dropdown">
                                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">Учет<strong class="caret"></strong></a>
                                            <ul class="dropdown-menu">
                                                <li class="nav-header">
                                                    Учет поступлений товаров на склады 
                                                </li>
                                                <li>
                                                    <a href="incoming.htm">Документ «Приход»</a>
                                                </li>
                                                <li class="divider">
                                                </li>
                                                <li class="nav-header">
                                                    Учет реализации товаров со склада
                                                </li>
                                                <li>
                                                    <a href="expense.htm">Документ «Расход»</a>
                                                </li>
                                                <li class="divider">
                                                </li>
                                                <li class="nav-header">
                                                    Отчет по остаткам на складах 
                                                </li>
                                                <li>
                                                    <a href="remainder.htm">В виде кросс-таблицы</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="">
                                            <a href="shipper.htm">Поставщикам</a>
                                        </li>
                                        <li class="">
                                            <a href="customer.htm">Покупателям</a>
                                        </li>
                                    </ul>
                                    <form class="navbar-form pull-right" >
                                        <input type="text" class="span8"/>
                                        <button type="submit" class="btn btn-success">Поиск</button>
                                    </form>
                                </div>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <div class="row-fluid">


            </div>
        </div>
        <div class="container">
            <div class="well well-large">
                Error!
            </div>
        </div>
