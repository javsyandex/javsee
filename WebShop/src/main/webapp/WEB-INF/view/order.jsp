

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
                                        <li>
                                            <a href="order.htm">Оформление заявки</a>
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
            <div class="row-fluid">


            </div>
        </div>  
        <div id="left">
            <h3>Итого: <c:out value="${summaryPrice}"/>  </h3>
            <h4>После ознакомления со списком вещей приступайте к оформлению заявки</h4>
            <table class="table table-bordered" border="2" width="2" cellspacing="2" cellpadding="2" >
                <thead>

                </thead>
                <tbody>
                    <tr>
                        <th>Товар</th>

                        <c:forEach items="${name}" var="name"> 
                            <td><c:out value="${name}"/> </td>
                        </c:forEach>

                    </tr> 

                    <tr>
                        <th>Цена</th>
                            <c:forEach items="${price}" var="price">
                            <td>
                                <c:out value="${price}"/>
                            </td>           
                        </c:forEach> 
                    </tr>

                </tbody>
            </table>
            <hr size="3" color="gray">
        </div>  

        <div id="right">
            <h3>Оставьте свои данные:</h3>
            <form action="AddCustomerServlet" method="POST">
                <p>Введите ваше имя : <input class="input-prepend" type="text" name="customerName" value="" size="20" /></p>
                <p>Введите ваш emаil: <input class="input-prepend" type="text" name="customerEmailAdress" value="" size="20" /></p>
                <p>Номер вашей кредитки: <input class="input-prepend" type="text" name="customerCreditCart" value="" size="20" /></p>
                <p>
                    <input class="btn btn-success" type="submit" value="Отправить заявку" name="name" />
                    <input type="hidden" name="target"  value="/endOrder.htm">
                </p>

            </form>

        </div> 
    </div>         
</body>
</html>