
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%> 

<div id="book">
    <h2>Выбрана категория: Книги</h2>

    <div id="leftBook">


        <table class="table table-bordered" border="2" width="2" cellspacing="2" cellpadding="2">
            <thead>
                <tr>
                    <th>№</th>
                    <th>Название</th>
                    <th>Автор</th>
                    <th>Цена</th>
                    <th>Кол-во страниц</th>
                    <th>Год издания</th>
                    <th>Наличие</th>
                    <th>Покупка</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${book}" var="book">
                    <tr>

                        <td><c:out value="${book.id}"/></td>
                        <td><c:out value="${book.nameBook}"/></td>
                        <td><c:out value="${book.author}"/></td>
                        <td><c:out value="${book.price}"/></td>
                        <td><c:out value="${book.numberOfPages}"/></td>
                        <td><c:out value="${book.yearOfPublication}"/></td>
                        <td><c:out value="${book.amount}"/></td>
                        <td>
                            <form action="addToCartServlet" method="post" >
                                <input class="btn btn-inverse" type="submit" name="" value="В корзину" /> 
                                <input type="hidden" name="infoItem"  value="${book.author}">
                                <input type="hidden" name="nameItem"  value="${book.nameBook}">
                                <input type="hidden" name="priceItem"  value="${book.price}">                        
                                <input type="hidden" name="target"  value="/book.htm">
                            </form>
                        </td>                
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>






</div>