<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">

    <div class="badge-important well well-small">
        <span class="label label-important"><h4>Внимание!</h4></span>
        <c:forEach items="${productError}" var="productError" >                   
            <p><span class="label label-important">К сожалению <c:out value="${productError.date}"/> на <c:out value="${productError.warehouse}"/> поступлений товара <c:out value="${productError.product}"/> не было!</span></p>
        </c:forEach> 
        <p><span class="label label-important">Остальной товар добавлен в "Расход"</span></p>    
    </div> 

    <div class="well well-large">
        <div>
            <form action="addCustomerInfo.htm" method="post">
                <div>
                    <strong>Дата:  </strong><input type="text" name="date" id="datepicker" 
                                                   style="width: 85px" placeholder="Дата" required />

                    <strong>Покупатель:  </strong>
                    <select name="customer" style="width: 125px" required>
                        <option></option>
                        <c:forEach items="${customer}" var="customer">
                            <option><c:out value="${customer.customer}"/></option>
                        </c:forEach>
                    </select>

                    <strong>Склад:  </strong>
                    <select name="warehouse" style="width: 125px" required>
                        <option></option>
                        <c:forEach items="${warehouse}" var="warehouse">
                            <option><c:out value="${warehouse.warehouse}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <table class="table table-bordered" border="3" width="2" cellspacing="2" cellpadding="2" >
                        <thead>
                            <tr>
                                <th>Товар</th>
                                <th>Количество</th>
                                <th>Цена за шт.</th>
                                <th>Сумма(расчетная)</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="count" value="1" scope="page" />
                            <c:forEach begin="1" end="${rowAmount}" step="1">
                                <tr>
                                    <td>
                                        <input type="text" name="product${count}" placeholder="Продукт" required />
                                    </td>
                                    <td>
                                        <input type="text" name="amount${count}" placeholder="Кол-во" required pattern="^[ 0-9]+$" />
                                    </td>
                                    <td>
                                        <input type="text" name="price${count}" placeholder="Цена" required pattern="\d+(\.\d{2})?" />
                                    </td>
                                    <td>
                                        <input type="text" name="amountToBePaid${count}" placeholder="Итог" required pattern="\d+(\.\d{2})?"/>
                                    </td>
                                </tr>
                                <c:set var="count" value="${count + 1}" scope="page"  />

                            </c:forEach>
                        </tbody>
                    </table>

                </div>

                <input class="btn btn-success" type="submit" name="" value="Сделать покупку" />
            </form>
        </div>
        <form action="customer.htm" method="post">
            <input class="btn btn-success" type="submit" name="" value="Добавить строку" />
            <input type="hidden" name="addRow"  value="${rowAmount+1}">
            <input type="hidden" name="total"  value="${count}">
        </form>             
    </div>    
</div>

