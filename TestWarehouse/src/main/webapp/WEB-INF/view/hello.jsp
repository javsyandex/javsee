

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
                                        <li class="active">
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
                <h3 class="help-block">Тестовое задание:</h3>
                <blockquote>
                    <em>Используя Java и СУБД Oracle, создать web-приложение обеспечивающее следующий функционал:</em>
                </blockquote>
                <ol class="">
                    <li>Учет поступлений товаров на склады. Документ «Приход».</li> 
                    <ul>
                        <li>Реквизиты шапки: Дата, Поставщик, Склад (на который приходуется товар).</li>
                        <li>Реквизиты строк: Товар, Количество, Цена, Сумма (расчетная)</li>
                    </ul>

                    <li>Учет реализации товаров со склада. Документ «Расход». </li>
                    <ul>
                        <li>Реквизиты шапки: Дата, Покупатель, Склад (с которого продается товар).</li>
                        <li>Реквизиты строк: Товар, Количество, Цена (расчетная), Сумма (расчетная)</li>
                        <li class="text-error">ВАЖНО!: Цена списания должна рассчитываться при сохранении документа по методу средневзвешенной (Цена = Общая сумма остатка на складе / Общее количество на складе)</li>
                    </ul>

                    <li>Отчет по остаткам на складах в виде кросс-таблицы</li>
                    <table class="table table-bordered" border="3">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Склад1</th>
                                <th>Склад2</th>
                                <th>Склад3</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th>Карандаш</th>
                                <td>100,00 грн<br>
                                    50 шт.
                                </td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Блокнот</th>
                                <td></td>
                                <td></td>
                                <td>500,00 грн<br>
                                    20 шт.
                                </td>
                            </tr>
                            <tr>
                                <th>...</th>
                                <td>...</td>
                                <td>...</td>
                                <td>...</td>
                            </tr>
                            <tr>
                                <th>Яблоко</th>
                                <td>120,00 грн<br>
                                    30 кг
                                </td>
                                <td>200,00 грн<br>
                                    30 кг
                                </td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>

                </ol>
            </div>
        </div>