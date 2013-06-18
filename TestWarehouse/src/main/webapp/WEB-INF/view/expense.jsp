<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="well well-large">
        <h4 class="help-block" >Документ «Расход»</h4>
    </div>
</div>
<div class="container">
    <div class="well well-large">
        <div>
            <form action="expense.htm" method="post">
                <div>
                    <strong>Дата:  </strong><input type="text" name="date" id="datepicker" style="width: 85px"
                                                   placeholder="Дата" required />

                    <strong>Покупатель:  </strong>
                    <select name="customer" style="width: 125px" required >
                        <option></option>
                        <c:forEach items="${customer}" var="customer">
                            <option><c:out value="${customer.customer}"/></option>
                        </c:forEach>
                    </select>

                    <strong>Склад:  </strong>
                    <select name="warehouse" style="width: 125px" required >
                        <option></option>
                        <c:forEach items="${warehouse}" var="warehouse">
                            <option><c:out value="${warehouse.warehouse}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <input class="btn btn-inverse btn-small" type="submit" value="Просмотреть «Расход»"/>
                </div>
            </form>
        </div>

        <div>
            <table class="table table-bordered" border="2" width="2" cellspacing="2" cellpadding="2" >
                <thead>
                    <tr>
                        <th>Товар</th>
                        <th>Количество</th>
                        <th>Цена(Расчетная)</th>
                        <th>Сумма(расчетная)</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${expense}" var="expense">
                    <tr>
                        <td><c:out value="${expense.product}"/></td>
                    <td><c:out value="${expense.amount}"/></td>
                    <td><c:out value="${expense.notionalPrice}"/> грн.</td>
                    <td><c:out value="${expense.notionalAmount}"/> грн.</td>            
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>

    </div>
</div>    