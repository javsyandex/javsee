<%-- 
    Document   : cart
    Created on : 06.05.2013, 9:50:43
    Author     : Michael Shumenko
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Корзина</title>
    </head>
    <body>
        <div id="header">
            <hr size="3" color="gray">
            <p>
                <a  href="helloPage.htm">Переход на главную страницу</a>
                <a  href="cart.htm">Корзина</a>
                <a  href="order.htm">Оформление заявки</a> </p>        
            <hr size="3" color="gray">
        </div>
        <div id="cart">

            <h3>Корзина</h3>

            <h4>Последняя добавленная вещь в корзину:  <c:out value="${lastItem}"/></h4>
            <h4>Итого:  <c:out value="${summaryPrice}"/></h4>
            <table border="2" width="2" cellspacing="2" cellpadding="2" >
                <thead>
                <h3>Корзина</h3>
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
                    <tr>
                        <th>Убрать</th>
                            <c:forEach items="${name}" var="name">
                            <td>
                                <form action="delete" method="post" >
                                    <input type="submit" name="" value="Убрать" />                         
                                    <input type="hidden" name="nameItem"  value="${name}">
                                    <input type="hidden" name="target"  value="/cart.htm">
                                </form>
                            </td>           
                        </c:forEach> 
                    </tr> 
                </tbody>
            </table>

            <form action="order.htm" method="post">
                <input type="submit" value="Оформить покупку" name="Оформить покупку" />
            </form>
        </div>
    </body>
</html>
