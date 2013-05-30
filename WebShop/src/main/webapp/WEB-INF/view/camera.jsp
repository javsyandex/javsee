<%-- 
    Document   : camera
    Created on : 15.04.2013, 22:33:05
    Author     : Michael Shumenko
--%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="camera">
    <h3>Выбрана категория: Камеры</h3>
    <hr size="3" color="gray">
    <h4>Последняя добавленная вещь в корзину: <c:out value="${lastItem}"/> </h4>
    <h4>Итого: <c:out value="${summaryPrice}"/> </h4>
    <table class="table table-bordered" border="2" width="2" cellspacing="2" cellpadding="2" >
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
            <c:forEach items="${camera}" var="camera">
                <tr>

                    <td><c:out value="${camera.id}"/></td>
                    <td><c:out value="${camera.nameCamera}"/></td>
                    <td><c:out value="${camera.modelCamera}"/></td>
                    <td><c:out value="${camera.price}"/></td>
                    <td><c:out value="${camera.amount}"/></td>
                    <td>
                        <form action="addToCartServlet" method="post" >
                            <input class="btn btn-inverse" type="submit" name="" value="В корзину" /> 
                            <input type="hidden" name="infoItem"  value="${camera.modelCamera}">
                            <input type="hidden" name="nameItem"  value="${camera.nameCamera}">
                            <input type="hidden" name="priceItem"  value="${camera.price}">                        
                            <input type="hidden" name="target"  value="/camera.htm">
                        </form>
                    </td>                
                </tr>
            </c:forEach>
        </tbody>
    </table>



</div>