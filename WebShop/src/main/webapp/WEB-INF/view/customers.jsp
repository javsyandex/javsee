<%-- 
    Document   : cart
    Created on : 06.05.2013, 9:50:43
    Author     : miha
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Покупатели</title>
    </head>
    <body>
        <div id="header">
            <hr size="3" color="gray">
            <p>
                <a  href="helloPage.htm">Переход на главную страницу</a>       
            <hr size="3" color="gray">
        </div>
        
        <div id="customers">
          <table border="2" width="2" cellspacing="2" cellpadding="2" >
        <thead>
            <tr>
                <th>Имя</th>
                <th>Emeil</th>
                <th>Кредитная карта</th>
                <th>Сумма к оплате</th>
                <th>Список купленых вещей</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${customers}" var="customers"> 
                <tr>

                    <td><c:out value="${customers.customerName}"/></td>
                    <td><c:out value="${customers.customerEmeilAdress}"/></td>
                    <td><c:out value="${customers.creditCart}"/></td>
                    <td><c:out value="${customers.sumPayment}"/></td>

                    <td>
                        <form action="viewItems.htm" method="post" >
                            <input type="submit" name="" value="просмотреть" /> 
                            <input type="hidden" name="idCustomer"  value="${customers.customerId}">
                        </form>
                    </td>                
                </tr>
            </c:forEach>
        </tbody>
    </table>  
       </div>
        
    </body>
</html>     