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
        <title>Покупатели</title>
    </head>
    <body>
        <div id="header">
            <hr size="3" color="gray">
            <p>
                <a  href="customers.htm">Переход на страницу покупателей</a>       
            <hr size="3" color="gray">
        </div>

        <div id="customers">
            <table border="2" width="2" cellspacing="2" cellpadding="2" >
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