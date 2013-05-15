<%-- 
    Document   : Cable
    Created on : 15.04.2013, 22:32:41
    Author     : Michael Shumenko
--%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="cable">
    <h3>Выбрана категория: Кабель</h3>

    <table border="2" width="2" cellspacing="2" cellpadding="2" >
        <thead>
            <tr>
                <th>№</th>
                <th>Имя</th>
                <th>Цена</th>
                <th>Наличие</th>
                <th>В корзину</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${cable}" var="cable">
                <tr>

                    <td><c:out value="${cable.id}"/></td>
                    <td><c:out value="${cable.nameCable}"/></td>
                    <td><c:out value="${cable.price}"/></td>
                    <td><c:out value="${cable.amount}"/></td>
                    <td>
                        <form action="addToCartServlet" method="post" >
                            <input type="submit" name="" value="В корзину" /> 
                            <input type="hidden" name="infoItem"  value=" ">
                            <input type="hidden" name="nameItem"  value="${cable.nameCable}">
                            <input type="hidden" name="priceItem"  value="${cable.price}">                        
                            <input type="hidden" name="target"  value="/cable.htm">
                        </form>
                    </td>                
                </tr>
            </c:forEach>
        </tbody>
    </table>



</div>