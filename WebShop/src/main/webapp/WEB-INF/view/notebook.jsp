<%-- 
    Document   : notebook
    Created on : 15.04.2013, 22:32:07
    Author     : Michael Shumenko
--%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="notebook">

    <h3>Выбрана категория: Ноутбуки</h3>

    <table border="2" width="2" cellspacing="2" cellpadding="2" >
        <thead>
            <tr>
                <th>№</th>
                <th>Имя</th>
                <th>Модель</th>
                <th>Цена</th>
                <th>Наличие</th>
                <th>В корзину</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${notebook}" var="notebook"> 
                <tr>

                    <td><c:out value="${notebook.id}"/></td>
                    <td><c:out value="${notebook.nameNotebook}"/></td>
                    <td><c:out value="${notebook.modelNotebook}"/></td>
                    <td><c:out value="${notebook.price}"/></td>
                    <td><c:out value="${notebook.amount}"/></td>
                    <td>
                        <form action="addToCartServlet" method="post" >
                            <input type="submit" name="" value="В корзину" /> 
                            <input type="hidden" name="infoItem"  value="${notebook.modelNotebook}">
                            <input type="hidden" name="nameItem"  value="${notebook.nameNotebook}">
                            <input type="hidden" name="priceItem"  value="${notebook.price}">                        
                            <input type="hidden" name="target"  value="/notebook.htm">
                        </form>
                    </td>                
                </tr>
            </c:forEach>
        </tbody>
    </table>




</div>