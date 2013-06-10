<%-- 
    Document   : remainder
    Created on : 09.06.2013, 16:23:21
    Author     : miha
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
                                        <li class="dropdown active">
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
                <h4 class="help-block" >Документ «Остатки»</h4>
            </div>
        </div>

        <div class="container">
            <div class="well well-large">
                <form action="remainder.htm" method="post">
                    <strong>Дата:  </strong><input type="text" name="date" id="datepicker" style="width: 85px"/>
                    <div>
                        <input class="btn btn-inverse btn-small" type="submit" value="Просмотреть «Остатки»"/>
                    </div>
                </form>  
                <div>
                    <table class="table table-bordered" border="2">
                        <thead>
                            <tr>
                                <th></th>
                                    <c:forEach items="${warehouse}" var="warehouse">
                                    <th><c:out value="${warehouse.warehouse}"/></th>
                                    </c:forEach>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${remainder}" var="remainder">  
                                <tr>
                                    <td><c:out value="${remainder.product}"/></td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${remainder.amountWH1>0}">
                                                <c:out value="${remainder.priceWH1}"/> грн.<br>
                                                <c:out value="${remainder.amountWH1}"/> шт.
                                            </c:when>
                                            <c:otherwise>
                                                --
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${remainder.amountWH2>0}">
                                                <c:out value="${remainder.priceWH2}"/> грн.<br>
                                                <c:out value="${remainder.amountWH2}"/> шт.
                                            </c:when>
                                            <c:otherwise>
                                                --
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${remainder.amountWH3>0}">
                                                <c:out value="${remainder.priceWH3}"/> грн.<br>
                                                <c:out value="${remainder.amountWH3}"/> шт.
                                            </c:when>
                                            <c:otherwise>
                                                --
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${remainder.amountWH4>0}">
                                                <c:out value="${remainder.priceWH4}"/> грн.<br>
                                                <c:out value="${remainder.amountWH4}"/> шт.
                                            </c:when>
                                            <c:otherwise>
                                                --
                                            </c:otherwise>
                                        </c:choose>
                                    </td>>
                                    <td>
                                        <c:choose>
                                            <c:when test="${remainder.amountWH5>0}">
                                                <c:out value="${remainder.priceWH5}"/> грн.<br>
                                                <c:out value="${remainder.amountWH5}"/> шт.
                                            </c:when>
                                            <c:otherwise>
                                                --
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>