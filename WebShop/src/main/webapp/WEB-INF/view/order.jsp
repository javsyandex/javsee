<%-- 
    Document   : order
    Created on : 06.05.2013, 9:51:04
    Author     : Michael Shumenko
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Оформление заявки</title>
    </head>
    <body>
        <div id="mainDiv">
            <div id="head">
                <hr size="3" color="gray">
                <p>
                    <a  href="helloPage.htm">Переход на главную страницу</a>
                    <a  href="cart.htm">Корзина</a>
                    <a  href="order.htm">Оформление заявки</a> </p>        
                <hr size="3" color="gray">
            </div>   
            <div id="left">
                <h3>Вы желаете купить такие вещи</h3>
                <h3>На сумму: <c:out value="${summaryPrice}"/>  </h3>
                <h4>После ознакомления со списком вещей приступайте к оформлению заявки</h4>
                <table border="2" width="2" cellspacing="2" cellpadding="2" >
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
                    <p>Введите ваше имя : <input type="text" name="customerName" value="" size="20" /></p>
                    <p>Введите ваш emаil: <input type="text" name="customerEmailAdress" value="" size="20" /></p>
                    <p>Номер вашей кредитки: <input type="text" name="customerCreditCart" value="" size="20" /></p>
                    <p>
                        <input type="submit" value="Отправить заявку" name="name" />
                        <input type="hidden" name="target"  value="/endOrder.htm">
                    </p>
                    
                </form>

            </div> 
        </div>         
    </body>
</html>